package com.itheima.荣耀.T3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * @Author: Ethan Yankang
 * @Program: 秋招算法真题
 * @Date: 2024-09-26 19:59
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(reverse(input));
    }

    private static String reverse(String input) {
        char[] charArray = input.toCharArray();
        ArrayList<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (isVaildChar(ch)) {
                if (ch == '-' && !isValidDash(charArray, i)) {
                    if (word.length() > 0) {
                        words.add(word.toString());
                        word.setLength(0);
                    } else {
                        word.append(ch);
                    }
                } else {
                    if (word.length() > 0) {
                        words.add(word.toString());
                        word.setLength(0);
                    }
                }
            }
            if (word.length() > 0) {
                words.add(word.toString());
            }
            Collections.reverse(words);
        }
            return String.join(" ", word);

        }

    private static boolean isValidDash(char[] chars, int i) {
        return chars[i]=='-'
                &&i>0&&i<chars.length-1
                &&Character.isLetterOrDigit(chars[i-1])
                &&Character.isLetterOrDigit(chars[i+1]);
    }

    private static boolean isVaildChar(char ch) {
        return Character.isLetterOrDigit(ch)||ch=='-';
    }

}
