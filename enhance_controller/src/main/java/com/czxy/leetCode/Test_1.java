package com.czxy.leetCode;



import java.util.*;

public class Test_1 {

    /**
     * 猜数字
     * @param guess
     * @param answer
     * @return
     */
    public int game(int[] guess, int[] answer) {
        List<Integer> num=new ArrayList<>();
        for(int i=0;i<guess.length;i++){
            if(guess[i]==answer[i]){
                num.add(i);
                break;
            }
        }
        if(num.size()==3){
            System.out.println("小A 每次都猜对了。");
        }else if(num.size()==2){
            System.out.println("小A 只猜对了第"+num.get(0)+"和第"+num.get(1)+"次。");
        }else if(num.size()==1) {
            System.out.println("小A 只猜对了第"+num.get(0)+"次。");
        }else {
            System.out.println("小A 一次都没猜对");
        }

        return num.size();
    }

    /**
     *无重复字符的最长子串
     * @param s 传递的字符
     * @return
     */

    public int lengthOfLongestSubstring(String s) {

        //如果输入为空""字符串直接返回0
        if(s.length()==0){
           return  0;
        }
        //把输入的字符转换为字符数组
        char[] chars = s.toCharArray();
        //字符数组的长度
        int strLength =chars.length;

        //存放不重复最长子串的集合list
        List<Character> list=new ArrayList<>();
        //把chars字符数组的第一个数据存放(add)到list集合中
        list.add(chars[0]);
        //最长子串的长度
        int maxNum = 1;

        //1.依次遍历输入的字符数组
        for(int i=0;i<strLength;i++){
            //防止后面的索引越界异常
            if(i+1<strLength){
            //2.判断子串中是否包含下一个字符数组中的字符
                if(list.contains(chars[i+1])){
                    //2.1如果包含移除list中相同字符前的所有数据
                    int  n= list.indexOf(chars[i + 1])+1;
                    for(int a=0;a< n;a++){
                        list.remove(0);
                    }
                    //2.2把该字符add到list中
                    list.add(chars[i+1]);
                    //2.3给最长子串的长度赋值
                    maxNum=(maxNum>list.size())?maxNum:list.size();
                }else {
                    //3.如果不包含该字符，直接把该字符添加到list中
                    list.add(chars[i+1]);
                    //3.1给最长子串的长度赋值
                    maxNum=(maxNum>list.size())?maxNum:list.size();
                }
            }
        }
        return maxNum;
    }


    /**
     * 整数反转
     * @param x
     * @return
     */
    public int reverse(int x) {
        //如果为0则直接返回0
        if(x==0){
            return 0;
        }
        //把数字转换为字符数组
        char[] chars = Integer.toString(x).toCharArray();
        //用于接收反转后的数字
        String str="";

        //遍历字符数组
        for(int i=chars.length-1;i>-1;i--){

            //反转后第一位为0，则跳过本轮循环
            if(chars[i]=='0'){
                continue;
            }

            //是否为负数，则把符号放到第一位，然后跳过本轮循环
            if(i==0&&chars[0]=='-'){
                str=chars[i]+""+str;
                continue;
            }
            str+=chars[i];
        }

        //防止异常
        try {
            //数字转换
            Integer num=Integer.parseInt(str);
           return num;

        }catch (NumberFormatException e){
            //发生异常返回0
            return 0;
        }
    }

    /**
     * 整数转罗马数字
     * 数字会在3999之内
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        String Q []= {"", "M", "MM", "MMM"};
        String B []= {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String S []= {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String G []= {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        //详解
        int ge=(int) Math.floor(num%10);
        int shi=(int)Math.floor(num/10%10);
        int bai=(int)Math.floor(num/100%10);
        int qian=(int)Math.floor(num/1000);
        String str=Q[qian]+B[bai]+S[shi]+G[ge];


        String a= Q[(int) Math.floor(num/1000)] + B[(int)Math.floor((num%1000)/100)] + S[(int)Math.floor((num%100)/10)] + G[num%10];

        return a;

    }

    /**
     *全排列
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {

        return null;
    }

    /**
     * 判断是否是回文数
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        int num=0,y=x;

        //传递的数为负数则不为回文数
        if(x<0){
            return false;
        }

        //y=x 判断y>0
        while (y>0){
            num *=10;
            num +=y%10;
            y/=10;
        }
        if(x==num){
            return true;
        }

        return false;
    }

    /**
     * 乘最多水容器
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max=0;
        int low=0;

        for(int i=0;i<height.length-1;i++){
            for(int j=1;j<height.length;j++){
                //获得短的那个长度
                low=height[i]<height[j]?height[i]:height[j];
                max=max>low*(j-i)?max:low*(j-i);
            }
        }

        return max;
    }

    public int maxArea2(int[] height){
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            }
            else{
                r--;
            }

        }
        return maxarea;
    }

    /**
     * 最长公共前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {

        return "";
    }

    /**
     *
     * @param strs
     * @return
     */

    public List<List<String>> groupAnagrams(String[] strs) {

        return null;
    }

    public static void main(String[] args) {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> lists;
        for(int i=0;i<strs.length;i++){
            String tem=strs[i];

            for(int j=1;j<strs.length;j++){

            }

        }


    }

}
