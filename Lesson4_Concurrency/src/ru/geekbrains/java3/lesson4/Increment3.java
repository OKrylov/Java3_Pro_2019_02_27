package ru.geekbrains.java3.lesson4;

import java.util.concurrent.atomic.AtomicInteger;

public class Increment3 {

    private AtomicInteger value = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        Increment3 increment = new Increment3();


        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment.incrementValue();
                increment.printValue();
                sleep(10);
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment.incrementValue();
                increment.printValue();
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
        value.incrementAndGet();
    }

    private void printValue() {
        System.out.println(Thread.currentThread().getName() + " data = " + value);
    }
}