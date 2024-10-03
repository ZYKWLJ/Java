package com.itheima.美团.T24_1.T1;

import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 真题
 * @Date: 2024-08-31 21:07
 **/
public class Main1 {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            while (true){
                String str = input.nextLine();
                System.out.println(solve(str));
        }
    }

    private static int solve(String str) {
        int count=0;

        if(str.length()==1&&Character.isUpperCase(str.charAt(0)))
            return 1;

        for (int i = 1; i < str.length(); i++) {
            char c1=str.charAt(i-1);
            char c2=str.charAt(i);
            if(((i==1)&&Character.isUpperCase(c1))||((c1==' ')&&Character.isUpperCase(c2)))
                count++;
        }

        return count;
    }
}
