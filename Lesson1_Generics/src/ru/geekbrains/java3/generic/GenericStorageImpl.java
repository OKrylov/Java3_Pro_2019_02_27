package ru.geekbrains.java3.generic;

public class GenericStorageImpl<E> implements GenericStorage<E> {

    private E[] data;
    private int currentSize;

    public GenericStorageImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
    }

    @Override
    public E get(int index) {
        return data[index];
    }

    public void add(E value) {
        add(value, currentSize);
    }

    public void add(E value, int index) {
        data[index] = value;
        currentSize++;
    }

    public void remove(int index) {
        data[index] = null;
        currentSize--;
    }

    public boolean find(E value) {
        for (int i = 0; i < currentSize; i++) {
            if ( value.equals(data[i]) ) {
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}