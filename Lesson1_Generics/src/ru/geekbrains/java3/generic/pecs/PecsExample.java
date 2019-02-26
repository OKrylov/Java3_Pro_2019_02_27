package ru.geekbrains.java3.generic.pecs;

import java.util.ArrayList;
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
        List<Pet> src = new ArrayList<>();
        src.add(new Cat());
        src.add(new Dog());

        List<Pet> dest = new ArrayList<>();

        for (Pet p : dest) {
            p.call();
        }
    }



    public static void main(String[] args) {
        new PecsExample().test();
    }
}
