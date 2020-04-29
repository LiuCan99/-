package com.czxy.thread;

/**
 * 多线程中多对多 （多个生产者和多个消费者）
 * @Author: liucan
 * @Date: 2020/4/28 17:19
 */
public class Productor2Customer2 {

    public static void main(String[] args) {
        Clerk2 clerk=new Clerk2();
        Productor2 productor1=new Productor2(clerk,"生产者一号");
        productor1.start();

        Productor2 productor2=new Productor2(clerk,"生产者二号");
        productor2.start();

        Productor2 productor3=new Productor2(clerk,"生产者三号");
        productor3.start();


        Customer2 customer1=new Customer2(clerk,"消费者一号");
        customer1.start();

        Customer2 customer2=new Customer2(clerk,"消费者二号");
        customer2.start();

        Customer2 customer3=new Customer2(clerk,"消费者三号");
        customer3.start();
    }

}

/**
 * 生产者
 */
class Productor2 extends Thread{

    private  Clerk2 clerk;
    public Productor2(Clerk2 clerk,String name){
        super(name);
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
class Customer2 extends  Thread{
    private  Clerk2 clerk;
    public Customer2(Clerk2 clerk,String name){
        super(name);
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
class Clerk2{
    //剩余库存数
    int clerk=0;

    //生产者生产库存，增加库存数量
    public synchronized void   save(){
        //库存最大为20
        while (clerk>=20){
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
        System.out.println(Thread.currentThread().getName()+"生产了一件商品，当前库存为："+(++clerk));

        //生产商品后，唤醒消费者
        notifyAll();
    }

    //消费者消费库存，减少库存数量
    public synchronized void get(){
        //库存小于1时，不允许继续消费
        while (clerk<=1){
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
        System.out.println(Thread.currentThread().getName()+"消费了一件库存，当前库存为："+(--clerk));

        //唤醒生产者，进行生产
        notifyAll();
    }
}
