package com.czxy.thread;

/**
 * 多线程中一对一 （生产者和消费者）
 * @Author: liucan
 * @Date: 2020/4/28 17:19
 */
public class Productor2Customer {

    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        Productor productor=new Productor(clerk);
        Customer customer=new Customer(clerk);

        productor.start();
        customer.start();
    }

}

/**
 * 生产者
 */
class Productor extends Thread{

    private  Clerk clerk;
    public Productor(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        while (true){
            clerk.save();
        }
    }
}

/**
 * 消费者
 */
class Customer extends  Thread{
    private  Clerk clerk;
    public Customer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        while (true){
            clerk.get();
        }
    }
}


/**
 * 库存
 */
class Clerk{
    //剩余库存数
    int clerk=0;

    //生产者生产库存，增加库存数量
    public synchronized void   save(){
        //库存最大为20
        if (clerk>=20){
          //等待，不再继续生产
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产者生产了一件商品，当前库存为："+clerk++);

        //生产商品后，唤醒消费者
        notify();
    }

    //消费者消费库存，减少库存数量
    public synchronized void get(){
        //库存小于1时，不允许继续消费
        if(clerk<1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费者消费了一件库存，当前库存为："+clerk--);

        //唤醒生产者，进行生产
        notify();
    }
}
