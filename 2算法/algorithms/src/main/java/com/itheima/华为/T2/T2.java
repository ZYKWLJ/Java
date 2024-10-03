package com.itheima.华为.T2;

import java.util.Scanner;


/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-09 20:32
 **/
public class T2 {
    static StringBuilder str=new StringBuilder();
    static int cursor=0;

    public static void main(String[] args) {
        String[] mode = new String[]{"insert", "delete", "move", "copy", "end"};
        Scanner input = new Scanner(System.in);
        String commod;

        StringBuilder commodPart1;
        StringBuilder commodPart2=new StringBuilder();
        while (true) {
            for (int i = 0; i < 200; i++) {
                commod = input.nextLine();
                //退出模式，直接退出
                if (commod.equals("end")) break;

                commodPart1 = commodPart1(commod);
                if (commodPart1.equals("copy")) {
                   copy();
                   continue;
                }

                commodPart2 = commodPart2(commod);
                switch (choose(mode, commodPart1)) {
                    case 0:
                        insert(commodPart2);
                        break;
                    case 1:
                        delete(commodPart2);
                        break;
                    case 2:
                        move(commodPart2);
                        break;
                    case 3:
                        copy();
                        break;

                    default:
                }
            }
            str = new StringBuilder(str.substring(0, cursor) + "|" + str.substring(cursor));
            System.out.println(str);
        }

    }

    private static void insert(StringBuilder commodPart2) {
    //    判断游标位置，在中间还需要移动呢！
    //    在末尾，直接加
        if (cursor==str.length()){
            cursor=str.length()+commodPart2.length();
           str.append(commodPart2);

        //   在之中，分成两半在相加
        }else {
            StringBuilder strLeft = new StringBuilder(str.substring(0, cursor));
            StringBuilder strRight = new StringBuilder(str.substring(cursor));
            str=strLeft.append(commodPart2).append(strRight);
            cursor+=commodPart2.length();
        }

    }



    private static void delete(StringBuilder commodPart2) {
        //将字符串转化为数字
        int len=StringToInt(commodPart2) ;
        //int strLen=commodPart2.length();
        //为负数，直接退出
        if (commodPart2.charAt(0)!='-')
            return;
        //删除大于游标位置，直接退出
        if (len>cursor)
            return ;

        //    判断游标位置，在中间还需要移动呢！
        //    在末尾，直接加
        if (cursor==str.length()){
            str= new StringBuilder(str.substring(0, cursor - len));
            cursor-=len;
            //删除在之中，分成两半在相加
        }else {
            StringBuilder strLeft = new StringBuilder(str.substring(0, cursor-len));
            StringBuilder strRight = new StringBuilder(str.substring(cursor));
            str=strLeft.append(strRight);
            cursor-=len;
        }
    }



    private static void move(StringBuilder commodPart2) {
       int len;
       if (commodPart2.charAt(0)=='0')return;
       if (commodPart2.charAt(0)=='-'){
           len=StringToInt(new StringBuilder(commodPart2.substring(1)));
           if (len>cursor){
               return;
           }
           cursor-=len;
       }else {
           len=StringToInt(commodPart2);
           if(len+cursor>str.length()){
               return;
           }
           cursor+=len;
       }
    }


    private static void copy() {
        //    判断游标位置，在中间还需要移动呢！
        //    在末尾，直接repeat
        if (cursor==str.length()){
            str = new StringBuilder(str.toString().repeat(2));
            //   在之中，分成两半在相加
        }else {
            StringBuilder strLeft = new StringBuilder(str.substring(0, cursor));
            StringBuilder strRight = str;
            str=strLeft.append(strRight);
        }
    }


    //将数字字符串转化成正数,这是很重要的！！！！！！常用！！！！！
    private static int StringToInt(StringBuilder commodPart2) {
        int len=0;
        for (int i = commodPart2.length()-1; i >=0; i--) {
            char ch=commodPart2.charAt(i);
            len+=(ch-'0')*10*i;
        }
        return len;
    }



    private static StringBuilder commodPart1(String commod) {
        int pos=0;
        if (commod.equals("copy")) return new StringBuilder(commod);

        StringBuilder commodPart1;
        while (commod.charAt(pos)!=' '){
            pos++;
        }
        commodPart1= new StringBuilder(commod.substring(0, pos+1));
        return commodPart1;
    }


    private static StringBuilder commodPart2(String commod) {
        int pos=0;
        StringBuilder commodPart2;
        while (commod.charAt(pos)!=' '){
            pos++;
        }
        commodPart2= new StringBuilder(commod.substring(pos+1));
        return commodPart2;
    }



    private static int choose(String[] mode, StringBuilder commodPart1) {
        for (int i = 0; i < 5; i++) {
            if (mode[i].equals(commodPart1.toString())){
                return i;
            }
        }
        return 5;
    }
}
