package com.itheima.深信服;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-03 21:41
 **/
/*
*题目描述：给定一串字符串，现在你将它切割成回文子串，输出最小切割次数以及切割对应的回文子串、所有回文子串集合。
*/


public class Min_SubStr {
    static int res_min_sub_index;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        List<List<String>> res= new ArrayList<List<String>>();
        List<String> path= new ArrayList<>();
        System.out.println("所有切割中，最少的切割次数为："+backTracking(str, 0, Integer.MAX_VALUE,0,res,path));
        System.out.println("所有切割种类为："+res);
        System.out.println("其中，最少切割次数的方案为："+res.get(res_min_sub_index));
    }

    private static int backTracking(String str, int startIndex, int MinCut, int count,List<List<String>> res,List<String> path) {
        if (startIndex==str.length()){
            //先将这个满足条件的分支加入res结果集中
            res.add(new ArrayList<>(path));

            if (MinCut>count-1){
                //标记最小的切割的串的位置
                res_min_sub_index=res.size()-1;
            }
            MinCut=Math.min(MinCut,count-1);
            return MinCut;
        }

        for (int i = startIndex; i < str.length(); i++) {
            if (isHW(str,startIndex,i)){
                count++;
                path.add(str.substring(startIndex,i+1));
            }else{
                continue;
            }

            //backTracking(str,i+1,MinCut,count,res,path);
            //记住这里一定要返回递归所求最小切割数，否则会错！！因为要一直传递这个Mincut！！
            MinCut = backTracking(str,i+1,MinCut,count,res,path);

            //记得回溯了！！
            count--;
            path.removeLast();
        }
        return MinCut;
    }

    private static boolean isHW(String str, int startIndex, int i) {
        int l=startIndex;
        int r=i;
        while (str.charAt(l++)!=str.charAt(r--))return false;
        return true;
    }
}
