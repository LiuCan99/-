package com.czxy.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liucan
 * @Date: 2019/12/16 10:37
 */
public class Test_7 {
    public static void main(String[] args) {
        int n=4;
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        System.out.println(ans.toString());
    }

    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max){
            backtrack(ans, cur+"(", open+1, close, max);
        }

        if (close < open){
            backtrack(ans, cur+")", open, close+1, max);
        }

    }



}
