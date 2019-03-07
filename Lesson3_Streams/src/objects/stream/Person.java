package objects.stream;

import java.util.Objects;

public class Person extends Human {

    public String name;
    public Person friend;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", friend=" + friend +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(friend, person.friend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, friend);
    }

//        @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//        out.writeObject(name);
//        out.writeObject(friend);
//    }
//
//    @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        name = (String) in.readObject();
//        friend = (Person) in.readObject();
//    }
}
