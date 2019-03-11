package ru.geekbrains.java3.lesson4;

import java.util.concurrent.*;

public class Main4 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello, " + Thread.currentThread().getName());
                System.out.println("State MyThread: " + Thread.currentThread().getState());
//                System.out.println("Priority, " + Thread.currentThread().getPriority());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        System.out.println("State before start: " + thread1.getState());

        thread1.setName("My Thread1");
        thread1.setPriority(10);

        System.out.println("Hello, " + Thread.currentThread().getName());


        thread1.setDaemon(true);

        thread1.start();
        System.out.println("State after start: " + thread1.getState());
        Thread.sleep(100);
        System.out.println("State after start: " + thread1.getState());
        thread1.join();
        System.out.println("State after join: " + thread1.getState());


//        ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service = Executors.newScheduledThreadPool(1);
        ((ScheduledExecutorService) service).scheduleAtFixedRate(() -> System.out.println("Helo!"), 0, 2, TimeUnit.SECONDS);
        service.execute(() -> System.out.println("Helo!"));
        Future<Integer> future = service.submit(() -> {
            System.out.println("Hello!");
            return 5;
        });
        System.out.println("future result = " + future.get());

        Thread.sleep(10000);
        service.shutdown();

    }
}
