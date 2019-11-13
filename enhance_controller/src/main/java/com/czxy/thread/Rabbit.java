package com.czxy.thread;

/**
 * @author lenovo
 */
public class Rabbit extends Thread {
    @Override
    public void run(){
        //线程体
        for(int i=0;i<10;i++){
            System.out.println("兔子:"+i);
        }
    }
}

class Tortoise implements Runnable{
    @Override
    public void run() {
        //线程体
        for(int i=0;i<10;i++){
            System.out.println("乌龟:"+i);
        }
    }
}
