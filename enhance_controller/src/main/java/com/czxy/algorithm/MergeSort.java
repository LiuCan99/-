package com.czxy.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: liucan
 * @Date: 2020/5/18 15:49
 */
public class MergeSort {

    @Test
    public void test(){
        int[] array={5,9,1,4,2};
        int[] merge = aa(array);
        System.out.println(merge[0]+","+merge[1]+","+merge[2]);
    }


    public static int[] aa(int[]arr){
        if(arr.length<2){        return arr;          }
        int mid=arr.length/2;
        int[] left=Arrays.copyOfRange(arr,0,mid);
        int[] rigth=Arrays.copyOfRange(arr,mid,arr.length);
        return bb(aa(left),aa(rigth));
    }
    public static int[]bb(int[] left,int[] right){
        int len=left.length+right.length;
        int[] result=new int[len];

        for(int index=0,i=0,j=0;index<len;index++){
            if(i>=left.length){
                result[index]=right[j++];
            }
            else if(j>=right.length){
                result[index]=left[i++];
            }
            else if(left[i]>right[j]){
                result[index]=right[j++];
            }
            else {
                result[index]=left[i++];
            } }
        return result;
    }
}
