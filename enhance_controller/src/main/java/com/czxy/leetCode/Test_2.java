package com.czxy.leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class Test_2 {

    /**
     * 移除元素
     */
    @Test
    public void removeElement() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int tage = 2;

        int i = 0;
        for (int num : nums) {
            if (num != tage) {
                nums[i] = num;
                i++;
            }
        }
        System.out.println(i);
    }

    /**
     * 移动零
     */

    @Test
    public void moveZeroes() {
        int[] nums = {0, 1, 0, 3, 12};
        //原数组的长度
        int len = nums.length;
        //记录非0的个数
        int index = 0;

        //把非0的元素全部移动到数组前面来
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        //根据原数组的长度 进行0的填充
        for (int j = index; j < len; j++) {
            nums[j] = 0;
        }
    }


    @Test
    public void sortColors() {
        int[] nums ={2,0,2,1,1,0};
        int zero=0;
        int one=0;
        for(int num:nums){
            if(num==0){
                zero++;
            }
            if (num==1){
                one++;
            }
        }

        for(int i=0;i<zero;i++){
            nums[i]=0;
        }

        for(int i=zero;i<one+zero;i++){
            nums[i]=1;
        }

        for(int i=zero+one;i<nums.length;i++){
            nums[i]=2;
        }

        System.out.println(nums);
    }
}
