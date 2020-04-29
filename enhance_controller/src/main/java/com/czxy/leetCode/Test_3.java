package com.czxy.leetCode;

import org.apache.activemq.store.kahadb.disk.index.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Test_3 {

    /**
     *58. 最后一个单词的长度
     */
    @Test
    public void lengthOfLastWord() {
        String s ="aa aaaa ";
        s = s.trim();
        int start = s.lastIndexOf(" ") + 1;
        System.out.println(s.substring(start).length());
    }


    /**
     * 多线程——
     */
    private boolean one=true;
    private boolean two=true;

    @Test
    public void Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this){
            printFirst.run();
            one=false;
            this.notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this){
            while (one){
                this.wait();
            }
            printSecond.run();
            two=false;
            this.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this){
            while (two){
                this.wait();
            }
            printThird.run();
            this.notifyAll();;
        }

    }

    /**
     * 多线程--交替打印RooBar
     */

    private int n;
    private volatile boolean finish;

    public void FooBar(int n) {
        this.n = n;

    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for(int i=0;i<n;i++){
            while (finish){
                Thread.yield();
            }

            printFoo.run();
            finish=true;

        }

    }

    public void bar(Runnable printBar) throws InterruptedException {
        for(int i=0;i<n;i++){
            while (!finish){
                Thread.yield();
            }
            printBar.run();
            finish=false;
        }

    }


    /**
     * 比较版本号
     */
    @Test
    public void te (){
        String version1 = "1.21";
        String version2 = "1.001";

        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int one=-1;
        int two=-1;

        for(int i=0;i<Math.max(split1.length,split2.length);i++){
            one=split1.length>i?Integer.valueOf(split1[i]):0;
            two=split2.length>i?Integer.valueOf(split2[i]):0;

            if(one>two){
                System.out.println(1);
            }else if(one<two){
                System.out.println(-1);
            }
        }
        System.out.println(0);

    }


    /**
     *  求众数
     */
    @Test
    public void majorityElement() {
        int[] nums={2,2,1,1,1,2,2};
        Arrays.sort(nums);
        int len=nums.length/2;
        int count=1;

       for(int i=1;i<nums.length;i++){

           if(i+1<nums.length){
               count=(nums[i]==nums[i+1]?count++:2);
           }

           if(count>len){
               System.out.println(nums[i]);
           }
       }
    }

    /**
     *
     * @return
     */
    @Test
    public void reverseWords() {
        String s=" the sky is blue";


        char[] chars = s.toCharArray();
        int a=chars[0]==' '?0:1;

        String[] s1 = s.split(" ");

        StringBuilder stringBuilder=new StringBuilder();
        for(int i=s1.length-1;i>-1;i--){
            if(i>0){
                stringBuilder.append(s1[i]+" ");
            }else  if(i>0&&a==0){
                stringBuilder.append(s1[i]+" ");
            } else if((i>0&&a==1)) {
                stringBuilder.append(s1[i]);
            }
        }
        String s2 = stringBuilder.toString();
        System.out.println(s2);
    }


    public static void main(String[] args) {
        int[]nums={1,2,3,4,1};
        //是否有重复数
        System.out.println(containsDuplicate(nums));
        //反转链表


//        reverseList();

    }

    public static boolean containsDuplicate(int[] nums) {

        return  Arrays.stream(nums).distinct().count()!=nums.length;
    }


    /**
     * 是否有重复数
     * @param nums
     * @return
     */
    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set=new HashSet<>(nums.length);

        for(Integer num:nums){

            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }

        return false;
    }


    public ListNode reverseList(ListNode head) {


        return new ListNode();
    }


}
