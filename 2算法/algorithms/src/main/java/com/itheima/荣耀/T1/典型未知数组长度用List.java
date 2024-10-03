package com.itheima.荣耀.T1;

import java.util.*;


/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-26 19:11
 **/
public class 典型未知数组长度用List {
    public static void main(String[] args) {
    //    最好的方式还是list加入!!

    //    (list 转数组，笔记！！)
    //    LinkedList<String> strings = new LinkedList<>();
    //    strings.add("aaaaa");
    //    strings.add("bbbbb");
    //    strings.add("ccccc");
    //    Object[] array = strings.toArray();
    //    System.out.println("array = " + Arrays.toString(array));

    //方法1： 近路，直接使用List，因为这是数组长度未知的，后面直接转为数组就好了
       Scanner input = new Scanner(System.in);
        String a = input.next();
        int an = input.nextInt();
        String b = input.next();
        int bn = input.nextInt();
        input.nextLine();


        LinkedList<String> strings1 = new LinkedList<>();

        for (int i = 0; i < an; i++) {
            String string = input.nextLine();
            if (!string.equals("-")){
                strings1.add(string);
            }
        }

        LinkedList<String> strings2 = new LinkedList<>();

        for (int i = 0; i < bn; i++) {
            String string = input.nextLine();
            if (!string.equals("-")){
                strings2.add(string);
            }
        }

        Arrays.sort(strings1.toArray());
        Arrays.sort(strings2.toArray());
        System.out.println(strings1.equals(strings2)?a+" == "+b:a+" != "+b);

        //方法2： 绕远路，使用数组法！！
        //Result result = getResult(an, input, bn);
        //System.out.println(equal(result.stringsA(), result.stringsB())?a+" == "+b:a+" != "+b);
    }



    //方法2
    private static Result getResult(int an, Scanner input, int bn) {

        //    //
        ////    比较两个字符串数组，初始化长度不同的话会怎样呢？照样不相等！！
        //    String[] strings1 = new String[2];
        //    String[] strings2 = new String[3];
        //    strings1[0]="2";
        //    strings2[0]="2";
        //    System.out.println(equal(strings1,strings2)?"相等":"不相等");

        String[] stringsA = new String[an];
        int countA=0;
        for (int i = 0; i < an; i++) {
            String stringA = input.nextLine();
            if (!Objects.equals(stringA, "-")){
                stringsA[countA++]=stringA;
            }
        }

        String[] stringsB = new String[bn];
        int countb=0;
        for (int i = 0; i < bn; i++) {
            String stringB = input.nextLine();
            if (!Objects.equals(stringB, "-")){
                stringsB[countb++]=stringB;
            }
        }

        Arrays.sort(stringsA);
        Arrays.sort(stringsB, Comparator.nullsLast(Comparator.naturalOrder()));
        Result result = new Result(stringsA, stringsB);
        return result;
    }

    private record Result(String[] stringsA, String[] stringsB) {
    }

    private static boolean equal(String[] stringsA, String[] stringsB) {
        int an=stringsA.length;
        int bn=stringsB.length;
        int i=0;
        while(stringsA.equals(stringsB)&&i<an&&i<bn){
            return false;
        }
        return true;
    }
}
