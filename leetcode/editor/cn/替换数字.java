package editor.cn;

import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-05 18:35
 **/
public class 替换数字 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = "12+1+1+23456789";
        System.out.println(string);
        System.out.println(Number2Chars(string));
    }

    private static String Number2Chars(String string) {
        char[] charArray = string.toCharArray();
        StringBuilder s = new StringBuilder();
        for (int i = charArray.length-1; i >= 0; i--) {
            char c=string.charAt(i);
            if (Character.isDigit(c)){
                s= new StringBuilder("number" + s);
            }else {
                s = new StringBuilder(c + "" + s);
            }
        }
        return String.valueOf(s);
    }
}
