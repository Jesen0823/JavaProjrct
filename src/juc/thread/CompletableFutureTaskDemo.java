package juc.thread;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.*;
import java.util.function.Function;

public class CompletableFutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // main1();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 20,
                1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).thenApply(f -> {
            return f * 2;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("结果：" + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });

        System.out.println("----main over");
        // 等一等，如果立即结束，CompletableFuture线程池会立即结束
        TimeUnit.SECONDS.sleep(4);
        poolExecutor.shutdown();
    }

    private static void main1() throws InterruptedException, ExecutionException {
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");

        });

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 20,
                1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(50),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
        }, poolExecutor);

        CompletableFuture<Integer> completableFuture3 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
            return 3;
        });
        CompletableFuture<Integer> completableFuture4 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
            return 4;
        }, poolExecutor);
        poolExecutor.shutdown();

        System.out.println(completableFuture1.get());
        System.out.println(completableFuture4.get());
    }
}

