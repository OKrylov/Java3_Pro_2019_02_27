package ru.geekbrains.java3.generic;

import java.time.LocalDate;

public class TestGeneric {

    public static void main(String[] args) {
        GenericStorage<Integer> intStorage = new GenericStorageImpl<>(5);

        intStorage.add(10);
        intStorage.add(2);
        intStorage.add(1);
        intStorage.add(3);


        Pair<Integer, Integer> min = intStorage.min();
        System.out.println("Min value is " + min.getValueLeft());
        System.out.println("Min index is " + min.getValueRight());

        Integer value = intStorage.get(1);
        System.out.println("Value is " + value);

        System.out.println("Find 2: " + intStorage.find(2));
        System.out.println("---");
        intStorage.display();


        GenericStorage<String> strStorage = new GenericStorageImpl(5);
        strStorage.add("1");

//        strStorage = intStorage;

        GenericStorage<LocalDate> dateStorage = new GenericStorageImpl<>(5);
        dateStorage.add(LocalDate.parse("2019-02-26"));
        dateStorage.add(LocalDate.parse("2019-02-28"));
        dateStorage.add(LocalDate.parse("2019-03-08"));

        Pair<LocalDate, Integer> minDate = dateStorage.min();
        System.out.println("Min date is " + minDate.getValueLeft());
    }
}