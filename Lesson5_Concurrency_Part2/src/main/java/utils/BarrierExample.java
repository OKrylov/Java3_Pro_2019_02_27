package utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BarrierExample {


    private static final int THREADS_COUNT = 6;


    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cb = new CyclicBarrier(THREADS_COUNT);

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT, new ThreadFactoryBuilder()
                .setNameFormat("Thread - %s")
                .build());

        List<Callable<Object>> tasks = new ArrayList<>();

        for (int i = 0; i < THREADS_COUNT; i++) {
            Runnable task = createTask(cb);
            tasks.add(Executors.callable(task));
        }

        executorService.invokeAll(tasks);

        executorService.shutdown();
    }

    private static Runnable createTask(CyclicBarrier cb) {
        return () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " готовится");
                Thread.sleep(100 + (int) (3000 * Math.random()));
                System.out.println(Thread.currentThread().getName() + " готов");

                cb.await();

                System.out.println(Thread.currentThread().getName() + " запустился");

            } catch (Exception e) {
                e.printStackTrace();
            }

        };
    }
}
