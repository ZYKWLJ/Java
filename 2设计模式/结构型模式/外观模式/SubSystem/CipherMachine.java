package com.EthanYankang.结构型模式.外观模式.SubSystem;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-18 11:06
 **/

//密码机，文件加密类
public class CipherMachine {
    public String encode(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            char aChar1 = (char) (aChar % 2 + 97);
            stringBuilder.append(aChar1);
        }
        return stringBuilder.toString();
    }
}
