package com.itheima.美团.T23.T1;

import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-06 10:03
 **/

public class T1 {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        int n = input.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
             nums[i]=input.nextInt();
        }

        int x=input.nextInt();
        int y=input.nextInt();
        System.out.println(solve(n,nums,x,y)?"Yes":"No");
    }


    /*
     * @description 版本二，直接两个一起判定！
     * @params
     * @return
     */

    private static boolean solve(int n, int[] nums, int x, int y) {
        for (int i = 0; i < n; i++) {
            if (nums[i]==x){
                return nums[i+1]==y;
            }else if(nums[i]==y){
                return nums[i]==x;
            }
        }
        return false;
    }

    /*
 * @description 版本一，判断慢一点，只判断了一个
 * @params
 * @return
 */

    //private static boolean solve(int n, int[] nums, int x, int y) {
    //    for (int i = 0; i < n; i++) {
    //        if (nums[i]==x){
    //            return nums[i-1]==y||nums[i+1]==y;
    //        }
    //    }
    //    //防止x或y不存在
    //    return false;
    //}

}
