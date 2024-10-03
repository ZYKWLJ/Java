package com.itheima.米哈游.T1;

import java.net.http.HttpConnectTimeoutException;
import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-07 16:30
 **/
public class T1 {
   static int countMax=0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m=input.nextInt();
        System.out.println(solve(n,m));
    }

    private static int solve(int n, int m) {
        int max=0;
        for (int i = n+1; i <=m; i++) {
            max=Math.max(max,doSolve(i));
        }
        return max==0?Math.max(n,m):max;
    }

    private static int doSolve(int i) {
        int count=0;
        StringBuilder stringBuilder=new StringBuilder(i+"");
        int len=stringBuilder.length();
        for (int j = 0; j < len; j++) {
            char ch= stringBuilder.charAt(j);
            if (ch-'0'==4||ch-'0'==6){
                count++;
            }
        }
        if(count>=countMax){
           countMax=count;
            return i;
        }
        return 0;
    }
}
