package com.czxy.DesignPattern.singleton;

public class LazySingleton {

    private static  class Lazy{
        private  static  final  LazySingleton INGLETON = new LazySingleton();
    }

    private LazySingleton() {
        System.out.println("实例化了一个新的单例。。。。。");
    }

    public static final LazySingleton getInstance(){
        return Lazy.INGLETON;
    }



}
