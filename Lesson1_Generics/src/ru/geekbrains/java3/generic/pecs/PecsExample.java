package ru.geekbrains.java3.generic.pecs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * PECS (provider - extends, consumer - super)
 */
public class PecsExample<T> {

    class Animal {
        void feed() {
        }
    }

    class Pet extends Animal {
        void call() {
        }
    }

    class Cat extends Pet {
        void mew() {
        }
    }

    class Dog extends Pet {
        void bark() {
        }
    }


    public void test() {
        List<Dog> src = new ArrayList<>();
//        src.add(new Cat());
        src.add(new Dog());

//        List<Pet> dest = new ArrayList<>();
        List<Animal> dest = new ArrayList<>();
        PecsExample.<Pet>copy(src, dest);

        for (Animal p : dest) {
            p.feed();
        }
    }

    private static <T> void copy(Collection<? extends T> src, Collection<? super T> dest) {
        dest.addAll(src);
    }



    public static void main(String[] args) {
        new PecsExample().test();
    }
}
