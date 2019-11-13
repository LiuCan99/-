package com.czxy.thread;

public class ThreadStop {
    public static void main(String[] args) throws InterruptedException {
        Study study =new Study();
        //匿名代理 启动线程
        new Thread(study).start();
        //外部干涉 线程睡眠5秒之后 调用stop()方法
        Thread.sleep(5000);
        //停止线程
        study.stop();

    }
}

class Study implements Runnable{

    private boolean flag=true;
    private  int x=1;

    @Override
    public void run() {
        while (flag){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Study"+x+"秒");
            x++;
        }
    }
    //对外提供改变标识的方法
    public  void stop(){
        this.flag=false;
    }
}