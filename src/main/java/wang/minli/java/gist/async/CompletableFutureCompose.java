package wang.minli.java.gist.async;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureCompose {

    /**
     * thenAccept子任务和父任务公用同一个线程
     */
    @SneakyThrows
    public static void thenRunAsync() {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1;
        });

        CompletableFuture<Void> cf2 = cf1.thenRunAsync(() -> {
            System.out.println(Thread.currentThread() + " cf2 do something...");
        });
        //cf3是copy的cf1的任务
        CompletableFuture<Integer> cf3 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf3 do something....");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1;
        });
        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.get());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());
        //任务3和任务1同时执行
        System.out.println("cf3结果->" + cf3.get());

    }

    /**
     * 这个同时演示了同步和异步的操作
     * @param args
     */
    public static void main(String[] args) {
        thenRunAsync();
    }
}

