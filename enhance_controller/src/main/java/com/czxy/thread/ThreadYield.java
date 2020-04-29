package com.czxy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadYield {
    public static void main(String[] args) {
        /**
         * 启动一
         */
//        for (int i = 0; i < 100; i++) {
//            System.out.println(Thread.currentThread().getName() + " " + i);
//            if (i == 30) {
//                // 创建一个新的线程  myThread1  此线程进入新建状态
//                Thread myThread1 = new MyThread();
//                Thread myThread2 = new MyThread();
//                // 调用start()方法使得线程进入就绪状态
//                myThread1.start();
//                myThread2.start();
//            }
//        }

        /**
         * 启动二
         */
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                // 创建一个Runnable实现类的对象
                Runnable myRunnable = new MyThread2();
                //myRunnable.run();并不是线程开启，而是简单的方法调用
                Thread thread1 = new Thread(myRunnable, "A窗口（线程）");
//                System.out.println(thread1.getName());
                // 将myRunnable作为Thread target创建新的线程
                Thread thread2 = new Thread(myRunnable, "B窗口（线程）");
                //thread1.run();
                // 如果该线程是使用独立的 Runnable 运行对象构造的，
                // 则调用该 Runnable 对象的 run 方法；否则，该方法不执行任何操作并返回。
                thread1.start(); // 调用start()方法使得线程进入就绪状态
                thread2.start();
            }
        }

        /**
         * 启动三
         */
        // 创建MyCallable对象
//        Callable<Integer> thread3 = new MyThread3();
//        //使用FutureTask来包装MyCallable对象
//        FutureTask<Integer> ft = new FutureTask<Integer>(thread3);
//
//        for (int i = 0; i < 100; i++) {
//            System.out.println(Thread.currentThread().getName() + " " + i);
//            if (i == 30) {
//                //FutureTask对象作为Thread对象的target创建新的线程
//                Thread thread = new Thread(ft);
//                //线程进入到就绪状态
//                thread.start();
//            }
//        }
//        System.out.println("主线程for循环执行完毕..");
//        try {
//            //取得新创建的新线程中的call()方法返回的结果
//            int sum = ft.get();
//            System.out.println("sum = " + sum);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

    }

    }

    /**
     * 创建线程方法一：继承Thread类
     */
    class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        }
    }


    /**
     * 创建线程方法二：实现Runable接口
     */
    class MyThread2 implements Runnable {
        @Override
        public void run() {
            long beginTime = System.currentTimeMillis();
            int count = 0;

            for (int i = 0; i < 500000; i++) {
                // Thread.yield();
                count = count + (i + 1);
            }
            //结束时间
            long endTime = System.currentTimeMillis();
            System.out.println("用时: " + (endTime - beginTime) + "ms");
            System.out.println("count:" + count);
        }
    }

    /**
     * 创建线程的方法三：使用Callable和Future接口创建线程
     */
    class MyThread3 implements Callable<Integer> {
        private int i = 0;

        // 与run()方法不同的是，call()方法具有返回值
        @Override
        public Integer call() {
            int sum = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                sum += i;
            }
            return sum;
        }
    }



