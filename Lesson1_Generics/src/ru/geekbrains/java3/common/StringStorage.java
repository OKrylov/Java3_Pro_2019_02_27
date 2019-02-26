package ru.geekbrains.java3.common;

public class StringStorage implements Storage {

    private String[] data;
    private int currentSize;

    public StringStorage(int size) {
        this.data = new String[size];
    }

    @Override
    public Object get(int index) {
        return data[index];
    }

    public void add(Object value) {
        add(value, currentSize);
    }

    public void add(Object value, int index) {
        data[index] = (String) value;
        currentSize++;
    }

    public void remove(int index) {
        data[index] = null;
        currentSize--;
    }

    public boolean find(Object value) {
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