package com.heima.DP.T4_63不同路径II;

import javax.management.ObjectName;
import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-13 22:18
 **/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m=input.nextInt();
        int[][] dp=new int[m+1][n+1];//dp【i】【j】表示走到i，j位置的不同路径的种数
        //初始化，格外注意如果障碍物在第一行第一列的情况。后面的全部不可达。
        int[][] obstacleGrid=new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        dp[1][1]=1;

        for (int i = 1; i < n + 1; i++) {
                if (dp[i-1][1]!=0&&obstacleGrid[i-1][1]!=1)
                    dp[i][1]=1;
        }
        for (int i = 1; i < n + 1; i++) {
            if (dp[1][i-1]!=0&&obstacleGrid[1][i-1]!=1)
                dp[1][i]=1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        System.out.println(dp[m][n]);

    }
}
