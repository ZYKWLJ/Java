package KMP;

import java.util.Arrays;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-10 20:55
 **/
public class KMP {
    public static void main(String[] args) {
        String str="aabaabaafc";
        String target="aabaaf";
        int[] next = new int[target.length()];
        getNext(target,next);
        System.out.println("next = " + Arrays.toString(next));
        for (int i = 0; i < kmp(str, target, next); i++) System.out.print(" ");
        System.out.println(target+"在");
        System.out.println(str+"中匹配到的序号为"+kmp(str,target,next));
    }

    //两个四行代码
    private static int kmp(String str, String target, int[] next) {
        int j=0;
        for (int i = 0; i < str.length(); i++) {
            while (j>0&&target.charAt(j)!=str.charAt(i))j=next[j-1];//回退
            if (target.charAt(j)==str.charAt(i))j++;
            if (j==target.length())return i+1- target.length();
        }
        return -1;
    }

    //所谓KMP算法就是求目标串的next数组，给定串利用next数组在与目标串匹配时回退。
    private static void getNext(String target, int[] next) {
        int j=0;
        for (int i = 1; i < target.length(); i++) {
            while (j>0&&target.charAt(i)!=target.charAt(j))j=next[j-1];
            if (target.charAt(i)==target.charAt(j))j++;
            next[i]=j;
        }
    }
}
