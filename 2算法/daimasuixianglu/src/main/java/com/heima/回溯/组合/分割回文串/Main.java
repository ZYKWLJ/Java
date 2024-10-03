package com.heima.回溯.组合.分割回文串;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-10 18:05
 **/
public class Main {
  static List<List<String>> res=new LinkedList<>();
  static List<String> path=new LinkedList<>();
  static int count=0;

    public static void main(String[] args) {
        String str="AABCCEC";
        dfs(str,0);
        System.out.println(res.toString());
    }
    //[[A, A, B, C, C, E, C], [A, A, B, C, CEC], [A, A, B, CC, E, C], [AA, B, C, C, E, C], [AA, B, C, CEC], [AA, B, CC, E, C]]
    //深刻理解dfs的含义：
    //这个和dp一样的，必须理解好它的含义。这样才能深度掌握，从思想上掌握，而不是从记忆上掌握。
    //此处的dfs(str,i)是指，以str串从i开始的所有回文子串的集合。
    public static void dfs(String str, int startIndex){
        if(startIndex==str.length()){
            res.add(new LinkedList<>(path));
        }
        for (int i = startIndex; i < str.length(); i++) {
            System.out.println(count+++str.substring(i));

            if (!isHW(str,startIndex,i+1)){
                continue;
            }
            path.add(str.substring(startIndex,i+1));
            dfs(str,i+1);
            path.removeLast();
        }
    }

    private static boolean isHW(String str, int begin, int end) {
        StringBuilder builder = new StringBuilder(str.substring(begin,end));
        String reversed = builder.reverse().toString();
        return str.substring(begin,end).equals(reversed);
    }
}
