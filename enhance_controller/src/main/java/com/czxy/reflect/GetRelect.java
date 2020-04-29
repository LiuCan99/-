package com.czxy.reflect;

import org.junit.Test;

/**
 *  根据反射获得String类的class对象
 * @Author: liucan
 * @Date: 2020/4/29 10:40
 */
public class GetRelect {

    /**
     *方式一：Class.forName("全类名")
     */
    @Test
    public void getRelect1() throws ClassNotFoundException {
        Class<?> c1 = Class.forName("java.lang.String");

        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());
    }

    /**
     *方式二： 对象.getClass();
     */
    @Test
    public void getRelect2() {
        String str="aaa";

        Class<? extends String> c2 = str.getClass();

        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());

    }


    /**
     *方式三：类.class;
     */
    @Test
    public void getRelect3() {
        Class<String> c3 = String.class;

        System.out.println(c3.getName());
        System.out.println(c3.getSimpleName());
    }

}
