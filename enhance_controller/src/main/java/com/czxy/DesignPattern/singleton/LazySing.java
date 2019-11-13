package com.czxy.DesignPattern.singleton;

public class LazySing {

   String name=null;
   Integer age =null;
   private static LazySing lazy=null;

   private LazySing(){}

   public static LazySing getInstance(){
       if(lazy==null){
           synchronized(LazySing.class){
               if(lazy==null){
                   lazy=new LazySing();
               }
           }
       }
       return lazy;
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void printInfo(){
        System.out.println("这个实例名字为："+name);
        System.out.println("这个实例年龄为："+age);
    }
}
