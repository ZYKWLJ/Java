package com.itheima.欧泊.T24_20240907.T1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-07 10:57
 **/
public class Main {
    static long[] even;
    static long[] odd;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //代表测试组数
        int T = input.nextInt();
        String[] strings=new String[1000];
        //  代表每一组的元素的个数
        for (int i = 0; i < T; i++) {
            int n=input.nextInt();
            long[] nums=new long[n];
            String[] str=new String[T];
            if (n%2==0) {
                //奇数
                even = new long[n / 2 + 1];
                //偶数
                odd = new long[n/2];
            }else {
                even = new long[n / 2+1];
                odd = new long[n/2+ 1];
            }
            int evenIndex=0;
            int oddIndex=0;
            for (int j = 0; j < n; j++) {
                 nums[j]=input.nextLong();
                 if (j%2==0){
                     even[evenIndex++]=nums[j];
                 }else {
                     odd[oddIndex++]=nums[j];
                 }
            }
            //System.out.println(Solve(even,odd));
            strings[i]=Solve(even,odd);

        }
        for (String string : strings) {
            if (string==null)break;
            System.out.println(string);
        }
    }
    //1 2 4 6 7 8
    private static String Solve(long[] even, long[] odd) {
        //n奇数的话，个数为偶数，5/2=2刚好,两者都是n/2+1
        //n偶数的花，个数为奇数，4/2=2,偶数为2，奇数+1
        Arrays.sort(even);
        Arrays.sort(odd);
        for (int i = 0; i < odd.length; i++) {
            if (i==odd.length-1&&even.length!=odd.length&&even[i]<odd[i])return odd[i]>even[i+1]?"NO":"YES";
            if(even[i]>odd[i])return "NO";
        }
        return "YES";
    }
}
