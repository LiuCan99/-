package com.czxy.thread;

public class ThreadWait {
    private  static  Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        ThreadA t1 = new ThreadA("t1");
        ThreadA t2 = new ThreadA("t2");
        ThreadA t3 = new ThreadA("t3");

        t1.start();
        t2.start();
        t3.start();

        try{
            System.out.println(Thread.currentThread().getName()+" sleep(3000)");
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        synchronized(obj){
        System.out.println(Thread.currentThread().getName()+" notifyAll()");
        obj.notifyAll();
    }

        System.out.println("main------");
    }


    static class ThreadA extends Thread{

        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run(){
            synchronized (obj) {
                try {
                    // 打印输出结果
                    System.out.println(Thread.currentThread().getName() + " wait");

                    // 阻塞当前的wait线程
                    obj.wait();

                    // 打印输出结果
                    System.out.println(Thread.currentThread().getName() + " continue");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

