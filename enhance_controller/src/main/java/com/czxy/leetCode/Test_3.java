package com.czxy.leetCode;

import org.junit.Test;


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


    @Test
    public void te (){


    }


}
