package com.itheima.深信服;

import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-03 21:24
 **/

/*T1
*题目描述：给定一串字符串，仅包含RGB，要求你移除其中一些字符串，使得最终的字符串两两之间不相同
* 输入：一串字符串
* 输出：最少移除个数
* 例如：
* 输入：RRG
* 输出：1
*/
public class StackUsing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true){
        String str = input.nextLine();
        StringBuilder str1 = new StringBuilder();
        str1.append(str.charAt(0));
        int count=0;
        for (int i = 1; i < str.length(); i++) {
            char ch=str.charAt(i);
            if (ch==str1.charAt(str1.length()-1)){
                count++;
            }else {
                str1.append(ch);
            }
        }
        System.out.println(count);
            System.out.println("str1 = " + str1);
    }}
}
