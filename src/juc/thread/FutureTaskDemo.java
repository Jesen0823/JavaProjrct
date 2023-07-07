package juc.thread;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
            TimeUnit.SECONDS.sleep(2);
            return 1024;
        });

        new Thread(futureTask, "t1").start();
        while (true) {
            if (futureTask.isDone()) {
                System.out.println("任务完成：" + futureTask.get());
                break;
            } else {
                System.out.println("计算中...");
            }
        }
        System.out.println("---主线程继续");
        CompletedFuture future;
        CompletionStage stage;

        //System.out.println("返回结果："+futureTask.get());
    }
}

