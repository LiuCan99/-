package com.czxy.DesignPattern.singleton;

/**
 * 单例模式
 */
public class Singleton {

    private  static  Singleton instance;

    private Singleton() {
        System.out.println("实例化了一个新的单例。。。。。");
    }

    public static  Singleton getInstance(){
        if (instance==null){
            instance =new Singleton();
        }
        return instance;
    }

}
