package com.czxy.thread;

public class RabbitApp {

    public static void main(String[] args) {
        //创建子类对象
        Rabbit rab = new Rabbit();
        Tortoise tor = new Tortoise();

        /**
         * 调用start方法
         * 多线程原理：相当于玩游戏机，只有一个游戏机（CPU），可是有很多人玩，
         * 于是 start()就是排队，当CPU的运行片段执行完，这个线程就继续排队
         * 等待下一次的run()
         *
         */
        rab.start(); //启动，通过继承Thread类实现的线程
        new Thread(tor).start(); //启动，通过实现Runnable实现的线程

        for(int i=0;i<10;i++){
            System.out.println("main==>"+i);
        }
    }
}
