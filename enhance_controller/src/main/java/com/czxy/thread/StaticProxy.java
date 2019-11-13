package com.czxy.thread;

/**
 * 线程中的  静态代理
 */
public class StaticProxy {

    public static void main(String[] args) {
        //创建真实角色
        Marry you = new You();
        //创建真实角色+代理角色的引用
        WeddingCompany weddingCompany = new WeddingCompany(you);

        //执行任务
        weddingCompany.marry();

    }
}


//接口
interface Marry{
    public abstract void marry();
}

//真实角色
class You implements Marry{

    //实现Marry中的方法
    @Override
    public void marry() {
        System.out.println("真实角色中的marry方法。。。。");
    }
}

//代理角色
class WeddingCompany implements Marry{

    //持有真实角色的引用
    private Marry you;

    //空参和全参构造
    public WeddingCompany() {
    }
    public WeddingCompany(Marry you) {
        this.you = you;
    }

    private void before(){
        System.out.println("代理角色中的before方法。。。。。");
    }

    private  void after(){
        System.out.println("代理角色中的after方法。。。。。");
    }
    //实现Marry中的方法
    @Override
    public void marry() {
        before();
        you.marry();
        after();
    }
}
