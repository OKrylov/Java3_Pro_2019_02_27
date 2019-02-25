package ru.geekbrains.java3.generic;

public class TestGeneric {

    public static void main(String[] args) {
        GenericStorage<Integer> intStorage = new GenericStorageImpl(5);
        intStorage.add(1);
        intStorage.add(2);
        intStorage.add(3);

        System.out.println("Find 2: " + intStorage.find(2));
        System.out.println("---");
        intStorage.display();


        GenericStorage<String> strStorage = new GenericStorageImpl(5);
        strStorage.add("1");
    }
}