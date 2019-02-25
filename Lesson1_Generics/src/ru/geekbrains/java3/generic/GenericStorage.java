package ru.geekbrains.java3.generic;

public interface GenericStorage<E> {

    void add(E value);

    void add(E value, int index);

    void remove(int index);

    E get(int index);

    boolean find(E value);

    void display();
}