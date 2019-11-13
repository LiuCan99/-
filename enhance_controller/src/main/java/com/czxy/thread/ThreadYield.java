package com.czxy.thread;

public class ThreadYield {
    public static void main(String[] args) {
        MyThread thread =new MyThread();
        new Thread(thread).start();
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {
        long beginTime=System.currentTimeMillis();
        int count =0;

        for(int i=0;i<500000;i++){
           // Thread.yield();
            count = count + (i + 1);
        }
        //结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("用时: " + (endTime - beginTime) + "ms");
        System.out.println("count:"+count);
    }
}
