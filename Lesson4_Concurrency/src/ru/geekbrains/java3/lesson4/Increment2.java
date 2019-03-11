package ru.geekbrains.java3.lesson4;

public class Increment2 {

    private int value;
    private static int staticValue;

    private static volatile boolean stop;

    public static void main(String[] args) throws InterruptedException {
        Increment2 increment = new Increment2();


        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    //close resources...
                    break;
                }
                increment.incrementValue();
                try {
                    Thread.sleep((long) 100);
                } catch (InterruptedException e) {
                    //close resources...
                    break;
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            while (true) {
                increment.printValue();
                sleep(10);
            }
        }, "t2");


        t1.start();

        t2.setDaemon(true);
        t2.start();

        Thread.sleep(500);
        t1.interrupt();
        stop = true;
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void incrementValue() {
        ++value;
        this.notify();
    }

    private synchronized void printValue() {
//        while (value % 10 != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }
        System.out.println(Thread.currentThread().getName() + " data = " + value);
    }
}