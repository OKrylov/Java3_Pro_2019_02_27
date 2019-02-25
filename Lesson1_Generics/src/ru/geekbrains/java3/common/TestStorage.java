package ru.geekbrains.java3.common;

public class TestStorage {

    public static void main(String[] args) {
        Storage intStorage = new IntStorage(5);
        intStorage.add(1);
        intStorage.add(2);
        intStorage.add(3);

        intStorage.display();
        System.out.println("---");

        intStorage.remove(1);

        intStorage.display();
    }
}