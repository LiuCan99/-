package com.czxy.DesignPattern.singleton;

import org.junit.Test;

public class TestSingleton {
    @Test
    public void  testSinglet1(){
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
    }

    @Test
    public  void testSinglet() throws Exception{

        while (true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    LazySingleton singleton = LazySingleton.getInstance();
                }
            }).start();
        }

    }

    public static void main(String[] args) {
        LazySing lazySing1= LazySing.getInstance();
        lazySing1.setName("123");

        LazySing lazySing2 = LazySing.getInstance();
        lazySing2.setAge(12);

        lazySing1.printInfo();
        lazySing2.printInfo();

        if(lazySing1==lazySing2){
            System.out.println("创建的是同一个实例。。。");
        }else {
            System.out.println("创建的是不同一个实例。。。");

        }
    }


}


