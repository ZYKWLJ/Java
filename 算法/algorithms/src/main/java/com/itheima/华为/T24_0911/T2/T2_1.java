package com.itheima.华为.T24_0911.T2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-11 20:17
 **/
public class T2_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] nums=new int[n][3];
        for(int i = 0; i < n*3; i++) {
            nums[i][0]=input.nextInt();
            nums[i][1]=input.nextInt();
            nums[i][2]=input.nextInt();
        }

        System.out.println(MaxHeightBox(nums));
    }

    private static int MaxHeightBox(int[][] nums) {
        Arrays.sort(nums,(a,b)->{
            //按长宽高排序好，如果相同，就按照后面再排序！！！这里
            if (a[0]!=b[0])return a[0]-b[0];
            if (a[1]!=b[1])return a[1]-b[1];
            return a[2]-b[2];
        });

        int n=nums.length;
        int[] dp=new int[n];
        //初始化dp数组
        for (int i = 0; i < n; i++) {
            dp[i]=nums[i][2];//初始化高度为盒子自身高度
        }
        //dp求解最值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j][0]<nums[i][0]&&nums[j][1]<nums[i][1]&&nums[j][2]<nums[i][2]){
                    dp[i]=Math.max(dp[i],dp[j]+nums[i][2]);
                }
            }
        }
        int maxHeight = 0;
        for (int height : dp) {
            maxHeight=Math.max(maxHeight,height);
        }
        return maxHeight;
    }
}
