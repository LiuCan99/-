package com.czxy.thread;

/**
 *
 *取钱线程不断取钱，每次取1000以内，如果不够则等待
 * 存钱线程不断存钱，每次存1000以内，存完之后，通知取钱线程，并睡眠两秒
 * 余额不允许出现0或负数
 * @Author: liucan
 * @Date: 2020/4/28 18:01
 */
public class Bank {
    public static void main(String[] args) {
        Account account=new Account();
        account.setMoney(1000.0);
        account.setAccountId("001");

        Withdraw withdraw=new Withdraw(account);
        withdraw.start();

        Deposit deposit=new Deposit(account);
        deposit.start();


    }
}


/**
 * 取钱
 * 取钱线程不断取钱，每次取1000以内，如果不够则等待
 */
class Deposit extends Thread {
    Account account;

    public Deposit(Account account) {
        this.account = account;
    }

    @Override
    public  void run() {
        while (true){
            synchronized (account){
                int money= (int) (Math.random()*1001);
                while (money>=account.getMoney()){
                    try {
                        account.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    account.notify();
                }

                account.setMoney(account.getMoney()-money);
                System.out.println("取了"+money+"钱，当前余额为"+account.getMoney());


            }
        }
    }
}

/**
 * 存钱
 *  存钱线程不断存钱，每次存1000以内，存完之后，通知取钱线程，并睡眠两秒
 */
class Withdraw extends Thread {
    Account account;

    public Withdraw(Account account) {
        this.account = account;
    }

    @Override
    public  void run() {
        while (true){
            synchronized (account){
                int money= (int) (Math.random()*1001);
                account.setMoney(account.getMoney()+money);
                System.out.println("存了"+money+"钱，当前余额为"+account.getMoney());

                account.notify();
                try {
                    account.wait(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}



/**
 * 账号信息类
 */
class Account{
    private  String accountId;

    private  Double money;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Account() {
    }

    public Account(String accountId, Double money) {
        this.accountId = accountId;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", money=" + money +
                '}';
    }
}
