package com.czxy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //获得对象
        User user= new User();

        FutureTask<String> futureTask= new FutureTask<String>(user);

        //启动线程
        new Thread(futureTask).start();
        //获取异步执行的结果，如果没有结果可用，此方法会阻塞直到异步计算完成
        String result = futureTask.get();
        System.out.println(result);

    }
}

class User implements Callable<String>{

    private int num=10;

    @Override
    public String call() throws Exception {
        String result="";
        while (num>0){
            System.out.println("票还剩"+num+"张");
            num--;
        }
        result="票买光了";
        return result;
    }
}
