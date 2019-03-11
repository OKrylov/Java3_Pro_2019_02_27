package ru.geekbrains.java3.lesson4;

public class Increment {

    private int value;
    private static int staticValue;

    private Object incrementLock = new Object();
    private Object printLock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Increment increment1 = new Increment();
        Increment increment2 = new Increment();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment1.incrementValue();
                increment1.printValue();
                sleep(10);
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment1.incrementValue();
                increment1.printValue();
//                increment2.incrementValue();
                sleep(10);
            }
        }, "t2");


        t1.start();
        t2.start();
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void incrementValue() {
//        value = value + 1;
//        synchronized (Increment.class) {
//            System.out.println(Thread.currentThread().getName() + " data = " + ++staticValue);
//        }

        synchronized (incrementLock) {
            ++value;
        }
    }

    private void printValue() {
        synchronized (printLock) {
            System.out.println(Thread.currentThread().getName() + " data = " + value);
        }
    }
}