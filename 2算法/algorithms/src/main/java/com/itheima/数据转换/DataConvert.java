package com.itheima.数据转换;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-04 20:33
 **/
public class DataConvert {
    int num=65;

    @Test
    public void testNum2otherData(){

        //int2Ascii
        char num2char=(char)num;
        System.out.println("num = " + num);
        System.out.println("num2char = " + num2char);

        //int2String
        String Num2String=num+"";
        System.out.println("num2str = " + Num2String);
        List<Integer> list=new ArrayList<>();

        //int2List
        list.add(num);//自动装箱了
        System.out.println("num2List = " + list);

        //int[]2Integer!!!!!!!!!!（用的最多的）
        int[] num=new int[]{5,6,7,8,1,2,3,4};
        System.out.print("int[]2Integer = ");
        Integer[] num2IntegerArray= Arrays.stream(num).boxed().toArray(Integer[]::new);//直接背这一段
        Arrays.stream(num2IntegerArray).forEachOrdered(System.out::print);
        System.out.println();

        //String2Integer[]
        String str="1235678";
        char[] charArray = str.toCharArray();
        Integer[] integerArr=new Integer[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            integerArr[i]=Character.getNumericValue(charArray[i]);
        }
        System.out.println("integerArr = " + Arrays.toString(integerArr));

        //StringBuilder2String
        StringBuilder stringBuilder=new StringBuilder("sfdfdfd");
        System.out.println(stringBuilder.toString());
        //Character.

    }


}
