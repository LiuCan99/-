package com.czxy.leetCode;


/**
 * @Author: liucan
 * @Date: 2019/11/22 17:46
 */
public class Test_4 {
    public static void main(String[] args) {

        System.out.println("求阶乘：");
        System.out.println(getNum(6));
    }

    public static int getNum(int num){
        int tem=1;
        if(num == 1){
            return tem;
        }

        tem=num*getNum(num-1);
        return  tem;
    }

}
