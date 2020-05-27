package com.czxy.algorithm;

/**
 * @Author: liucan
 * 冒泡排序算法
 * @Date: 2019/11/29 14:59
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array={5,9,1,4,2};
        bubbleSort(array);
    }
    /**
     * 定义：
     * 冒泡排序 是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，
     * 如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，
     * 也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     *
     * 实现步骤：
     * 步骤1: 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 步骤2: 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 步骤3: 针对所有的元素重复以上的步骤，除了最后一个；
     * 步骤4: 重复步骤1~3，直到排序完成。
     *
     * 算法分析：
     * 最佳情况：T(n) = O(n)
     * 最差情况：T(n) = O(n2)
     * 平均情况：T(n) = O(n2)
     */

    public static int[] bubbleSort(int[] array){
        //如果数组为空 直接返回
        if(array.length==0){
            return array;
        }
        //循环处理
        for(int i=0;i<array.length;i++){
            for (int j=0;j<array.length-1-i;j++){
                //比较两个相邻元素，如果第一个比第二个大则交换位置
                if(array[j]>array[j+1]){
                    int temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }


}
