package com.czxy.thread;

public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        long begin;
        long end;

        begin=System.currentTimeMillis();
        System.out.println("begin="+begin);

        Thread.sleep(2000);

        end=System.currentTimeMillis();
        System.out.println("end="+end);
        System.out.println("end - begin = " + (end - begin) + "ms");

    }
}
