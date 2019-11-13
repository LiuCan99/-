package com.czxy.thread;



import java.util.concurrent.*;

public class Call {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(2);
        Race tortoise=new Race("小乌龟", (long) 1000);
        Race rabbit=new Race("小兔子", (long) 500);

        //获取值
        Future<Integer> result1=service.submit(tortoise);
        Future<Integer> result2=service.submit(rabbit);

        //睡眠2秒
        Thread.sleep(2000);
        //停止线程体循环
        tortoise.setFlag(false);
        rabbit.setFlag(false);

        int num1 = result1.get();
        int num2 = result2.get();
        System.out.println("小乌龟跑了-->"+num1+"步");
        System.out.println("小兔子跑了-->"+num2+"步");

        //停止服务
        service.shutdownNow();
    }
}

class Race implements Callable<Integer>{
    //名称
    private String name;
    //延时时间
    private long time;
    //标识
    private boolean flag=true;
    //步
    private int step=0;

    //空参构造
    public Race() {
    }

    public Race(String name) {
        this.name = name;
    }

    public Race(String name, Long time) {
        this.name = name;
        this.time = time;
    }


    @Override
    public Integer call() throws Exception {
        while (flag){
            //延时
            Thread.sleep(time);
            step++;
        }
        return step;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}