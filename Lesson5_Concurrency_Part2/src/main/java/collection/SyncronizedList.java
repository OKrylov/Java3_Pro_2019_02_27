package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SyncronizedList {

    public static void main(String[] args) throws InterruptedException {
//        List<String> data = Collections.synchronizedList(new ArrayList<>());
        List<String> data = new CopyOnWriteArrayList<>();

//        List<String> data = new ArrayList<>();
        createProducer(data).start();
        createProducer(data).start();

        createReader(data).start();

        Thread.sleep(5000);
    }

    private static Thread createReader(List<String> data) {
        Thread reader = new Thread(() -> {
            while (true) {
                List<String> snapshot = new ArrayList<>();

                synchronized (data) {
                    snapshot.addAll(data);
                }

                for (String datum : data) {
//                for (String datum : snapshot) {
                    System.out.print(datum);
                }

                System.out.println();

                sleep(10);
            }
        });
        reader.setDaemon(true);
        reader.setName("Reader");
        return reader;
    }

    private static Thread createProducer(List<String> data) {
        Thread producer = new Thread(() -> {
           while (true) {
               data.add((int) (Math.random() * 100) + " ");
               sleep(10);
           }
        });
        producer.setDaemon(true);
        producer.setName("Producer");
        return producer;
    }


    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
