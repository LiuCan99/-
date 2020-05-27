package com.czxy.algorithm;

import org.junit.Test;

/**
 * @Author: liucan
 * 插入排序
 * @Date: 2019/11/29 16:11
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array={5,9,1,4,2};
        insertionSort(array);
    }

    @Test
    public void aa(){
        int[] array={5,9,1,4,2};
        insertionSort(array);
    }
    /**
     * 插入算法：
     * 是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，
     * 在已排序序列中从后向前扫描，找到相应位置并插入。
     * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
     * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     *
     * 算法描述:
     * 步骤1: 从第一个元素开始，该元素可以认为已经被排序；
     * 步骤2: 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 步骤3: 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 步骤4: 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 步骤5: 将新元素插入到该位置后；
     * 步骤6: 重复步骤2~5。
     *
     *算法分析：
     * 最佳情况：T(n) = O(n)
     * 最坏情况：T(n) = O(n2)
     * 平均情况：T(n) = O(n2)
     *
     */

    public static int[] insertionSort(int[] array){
        if(array.length==0){
            return array;
        }
        for(int i=0;i<array.length-1;i++){
            //记录下一个数的值
            int lastValue=array[i+1];
            //记录当前索引
            int index=i;
            //判断
            while(index>=0&&lastValue>array[index]){
                array[index+1]=array[index];
                index--;
            }
            array[index+1]=lastValue;

        }
        return array;
    }
}
