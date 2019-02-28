import model.Client;
import model.Phone;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class JdbcExample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db")) {
            Statement statement = connection.createStatement();

//            updatePhone(connection, "777-77-77","WORK");

            connection.setAutoCommit(false);
            PreparedStatement insertClient = connection.prepareStatement("INSERT INTO Client (FIRST_NAME, LAST_NAME, BIRTH_DATE) " +
                    "VALUES (?, ?, ?)");

            try {
                for (int i = 0; i < 500000; i++) {
//                    if (i == 3) {
//                        throw new RuntimeException("Test");
//                    }
                    insertClient.setString(1, "Client_NAME" + i);
                    insertClient.setString(2, "Client_SURNAME" + i);
                    insertClient.setString(3, "1990-01-" + (i < 10 ? "0" + i : i));
//                    System.out.println("Row updated: " + insertClient.executeUpdate());
                    insertClient.addBatch();
                }
                statement.executeBatch();
                connection.commit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                connection.rollback();
            }

            for(Client client : readAllClients(statement)) {
                System.out.println(client);
            }
        }
    }

    private static Collection<Client> readAllClients(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Client C\n" +
                "       INNER JOIN Phone P on C.ID = P.CLIENT_ID");

        Map<Integer, Client> clientById = new HashMap<>();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            if (clientById.get(id) == null) {
                clientById.put(id, createClient(resultSet, id));
            }

            Phone phone = createPhone(resultSet);
            int clientId = resultSet.getInt(8);

            Client client = clientById.get(clientId);
            client.getPhones().add(phone);
        }

        return clientById.values();

    }

    private static Phone createPhone(ResultSet resultSet) throws SQLException {
        int phoneId = resultSet.getInt(5);
        String phoneType = resultSet.getString(6);
        String phoneNumber = resultSet.getString(7);

        Phone phone = new Phone();
        phone.setId(phoneId);
        phone.setType(phoneType);
        phone.setNumber(phoneNumber);
        return phone;
    }

    private static Client createClient(ResultSet resultSet, int id) throws SQLException {
        String firstName = resultSet.getString(2);
        String lastName = resultSet.getString(3);
        LocalDate birthDate = LocalDate.parse(resultSet.getString(4));

        Client client = new Client();
        client.setId(id);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setBirthDay(birthDate);
        return client;
    }

    private static void updatePhone(Connection connection, String number, String type) throws SQLException {
        PreparedStatement updatePhones = connection.prepareStatement("UPDATE Phone SET number = ? WHERE type = ?");
        updatePhones.setString(1, number);
        updatePhones.setString(2, type);

        System.out.println("Updated rows: " + updatePhones.executeUpdate());
    }

}
