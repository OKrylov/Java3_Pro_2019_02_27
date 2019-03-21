import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Cat extends SuperCat implements ICat {


    public String color;
    private int age = 10;

    public final boolean catty;


    public Cat(String name, String color, int age) {
        super(name);
        this.color = color;
        this.age = age;
        this.catty = true;
    }

    public Cat(String name) {
        super(name);
        this.catty = true;
    }

    private Cat(String name, int age) {
        super(name);
        this.age = age;
        this.catty = true;
    }

    @Override
    public void meow(int db) {
        System.out.println(name + ": meow - " + db + " dB");
    }

    private void jump() {
        System.out.println(name + ": jump");
    }


    @Override
    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                ", age=" + age +
                ", catty=" + catty +
                '}';
    }
}