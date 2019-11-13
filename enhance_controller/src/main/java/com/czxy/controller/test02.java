package com.czxy.controller;

import com.czxy.domain.User;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Vector;

public class test02 {

    public static void main(String[] args) {

        Class clz = User.class;
        /**
         * 通过反射获取类属性、方法、构造器
         * 我们通过 Class 对象的 getFields() 方法可以获取 Class 类的属性，
         * 但无法获取私有属性。
         */
        Field[] fields = clz.getFields();
        System.out.println("公共属性：");
        for(Field field :fields){
            System.out.println(field.getName());
        }

        /**
         * 而如果使用 Class 对象的 getDeclaredFields()
         * 方法则可以获取包括私有属性在内的所有属性
         *
         * 与获取类属性一样，当我们去获取类方法、类构造器时，如果要获取私有方法或私有构造器，
         * 则必须使用有 declared 关键字的方法。
         */
        Field[] declaredFields = clz.getDeclaredFields();
        System.out.println("所有属性：");
        for(Field declaredField : declaredFields){
            System.out.println(declaredField);
        }

    }

    @Test
    public void  test(){
        String str ="";
        int length = str.split(",").length;
        System.out.println(str.split(","));
        System.out.println(length);

    }
}
