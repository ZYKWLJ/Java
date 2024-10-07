package com.heima.DP.T3_62不同路径;

import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-13 21:53
 **/
public class Main {
    public static void main(String[] args) {
    //    dp[i][j]定义走到(i,j)这个位置，需要的路径。
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n= input.nextInt();
        int[][] dp=new int[m+1][n+1];
        //初始化，刚开始的时候，第一行，第一列是完全只有一条路径的。
        //所以初始化为：1。

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                if (i==1||j==1 ){//在遍历的时候完成初始化if-else
                    dp[i][j]=1;
                }else {
                 dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }

        System.out.println(dp[m][n]);
    }
}
