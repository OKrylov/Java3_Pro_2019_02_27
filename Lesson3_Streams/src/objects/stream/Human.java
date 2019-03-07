package objects.stream;

import java.io.Serializable;

public class Human implements Serializable {
    static final long serialVersionUID = -1L;


    public int age;


    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                '}';
    }
}
