package com.czxy.thread;

/**
 * 窗口卖票
 */
public class TestSaleWindow  implements  Runnable{

    public static void main(String[] args) {
        // 创建了销售窗口对象
        TestSaleWindow saleWindow =new TestSaleWindow();
        // 启动线程，让第一个窗口开始买票
        new Thread(saleWindow).start();
        // 启动线程，让第二个窗口开始买票
        new Thread(saleWindow).start();
        // 启动线程，让第三个窗口开始买票
        new Thread(saleWindow).start();
        // 启动线程，让第四个窗口开始买票
        new Thread(saleWindow).start();

    }
    //初始化总票数
    private static  int ticket=10;

    @Override
    public void run() {
       //获取当前线程的序号从0开始 Thread.currentThread().getName()-->Thread-线程序列  0 1 2
       int threadNum=Integer.parseInt(Thread.currentThread().getName().substring(7));
       //偶数线程执行该方法
        if((threadNum+1)%2==0){
            while (true){
                //同步代码块
                synchronized (TestSaleWindow.class){
                    //销售窗口名称
                    String saleWindowName = "奇数销售窗口" + threadNum;
                    //判断剩余票数
                    if(ticket>0){
                        // 这里为了演示出线程不同步的问题，让线程睡眠一段时间，延时）
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(saleWindowName + " 卖 出 了 " + ticket-- + " 号 票 ！");
                    }else {
                        //没有剩余票了 停止
                        System.out.println("票卖完了。。。。。。");
                        break;
                    }
                }
            }
        }else {
            //奇数线程执行该方法
            while (true){
                /**
                 * 调用偶数窗口买票方法 返回值为
                 * true成功：不终止
                 * false失败：终止
                 */
                if(!saleSuccess()){
                    System.out.println("票卖完了。。。。。。");
                    break;
                }
            }
        }

    }

    public synchronized  static  boolean saleSuccess(){
        /**
         *获取线程的名称，比如Thread-0，
         * 并将它截掉Thread-取0这个数字标识，为了构造下面卖票窗口名称
         */
        int threadNum = Integer.parseInt(Thread.currentThread().getName().substring(7));
        //窗口名称
        String saleWindowName ="偶数销售窗口"+threadNum;

        //判断剩余的票
        if (ticket>0){
            // 这里为了演示出线程不同步的问题，让线程睡眠一段时间，延时）
            try {
                //当前线程睡眠1000ms
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(saleWindowName + " 卖 出 了 " + ticket-- + " 号 票 ！");

            //成功卖出 返回true
            return true;
        }

        //没有票了返回  false
        return false;
    }
}
