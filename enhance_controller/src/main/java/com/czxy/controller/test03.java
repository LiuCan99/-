package com.czxy.controller;


import com.czxy.domain.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class test03 {
    /***
     * List：
     * ArrayList：
     * 扩容为1.5倍；初始化容量为10；有序；底层为数组，查询快，增删慢；线程不安全
     * LinkedList：
     * 有序；底层为链表，查询慢，增删快，线程不安全
     * Vector：
     * 扩容为2倍；初始化容量为10；有序；底层为数组，线程安全
     *
     * Map：
     * HashMap：
     * 扩容为2倍；初始化容量为16（2的4次方），最大容量为2的30次方；
     * 无序；底层为数组+链表，1.8之后加入了红黑树；链表长度超过8之后转换为红黑树
     * 线程不安全；负载因子0.75；允许一个key为null；继承的父类为AbstractMap,实现了Map接口
     * HashTable：
     * 扩容为2倍+1；初始化容量为11
     * 无序；基于hash实现；线程安全；负载因子0.75；不允许key为null；继承父类为dictionary，实现了Map接口
     * LinkedHashMap：
     * 是hashMp的子类；有序，内部有一个双向链表记录顺序，（插入顺序、访问顺序）
     *
     * Set
     * HashSet
     * 无序；不重复；允许有null值；线程不安全；底层通过HashMap实现
     *
     * @param args
     */
    public static void main(String[] args) {

        User u1=new User(1,"jack1","123",new Date());
        User u2=new User(2,"jack2","123",new Date());
        User u3=new User(3,"jack3","123",new Date());

        int dayNum=4;
        List list=new ArrayList();
        list.add(u1);
        list.add(u2);
        list.add(u3);

        List encapsulationList = encapsulation(dayNum, list);
        System.out.println(encapsulationList.toString());
        System.out.println(encapsulationList.size());

    }

    /**
     * @param dayNum
     * @param list
     * @return
     */

    public static List<User> encapsulation(int dayNum,List<User> list){

        List<User> userList= new ArrayList<>();
        userList.addAll(list);
        int num=userList.size();

        while (userList.size()!=dayNum){
            num++;
            User user = new User();
            user.setDate(new Date());
            userList.add(user);

        }
        return userList;
    }


    @Test
    public void test01(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


}
