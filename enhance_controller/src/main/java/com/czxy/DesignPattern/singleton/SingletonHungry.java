package com.czxy.DesignPattern.singleton;

import org.junit.Test;

public class SingletonHungry {

    private  static  SingletonHungry instance=new SingletonHungry();

    public SingletonHungry() {
        System.out.println("实例化了一个新的单例。。。。。");
    }

    public static SingletonHungry getInstance(){
        return instance;
    }

    @Test
    public void testSingletonHungry() throws Exception{
        while(true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    SingletonHungry singletonHungry = SingletonHungry.getInstance();
                }
            }).start();
        }
    }


}
