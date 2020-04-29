package com.czxy.thread;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    public static void main(String[] args) {
       new ThreadPoolExecutor(2,2,0,
               TimeUnit.SECONDS,new ArrayBlockingQueue<>(512),  //使用有界队列，避免OOM
               new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
