package com.czxy.thread;

public class ThreadInterrupt {

    public static void main(String[] args)
            throws InterruptedException {
        MyTheardInterrupt myTheard =new MyTheardInterrupt();
        myTheard.start();
        Thread.sleep(1000);

        System.out.println("改变之前："+myTheard.isInterrupted());

        myTheard.interrupt();

        System.out.println("改变之后："+myTheard.isInterrupted());

        System.out.println("end");

    }
}

class MyTheardInterrupt extends Thread{
    @Override
    public void run() {
       try {
         for(int i=0;i<5000000;i++){
            if(this.isInterrupted()){
                System.out.println("已经是停止状态了，我要退出了");
                throw  new InstantiationException();
                 }
                System.out.println(i);
             }
         System.out.println("for结束");
       } catch (InstantiationException e) {
           System.out.println("进入run中的catch了");
       }

    }
}
