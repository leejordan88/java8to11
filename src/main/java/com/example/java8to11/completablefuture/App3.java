package com.example.java8to11.completablefuture;

import javax.security.auth.callback.Callback;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "java";
        };

        Callable<String> joonsung = () -> {
            Thread.sleep(1000L);
            return "joonsung";
        };

/*        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("Started!");

        System.out.println(helloFuture.get()); // blocking call

        System.out.println(helloFuture.isDone());
        System.out.println("End!!");
        executorService.shutdown();*/

/*        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, joonsung));
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        System.out.println("End!!");
        executorService.shutdown();*/

        String s = executorService.invokeAny(Arrays.asList(hello, java, joonsung));
        System.out.println(s);
        System.out.println("End!!");
        executorService.shutdown();


    }
}
