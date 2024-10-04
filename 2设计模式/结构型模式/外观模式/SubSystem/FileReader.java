package com.EthanYankang.结构型模式.外观模式.SubSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-18 11:14
 **/

//文件读取类
public class FileReader {
    public String readFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        StringBuilder stringBuilder = new StringBuilder();
        int ch = fileInputStream.read();
        while (ch != -1) {
            stringBuilder.append((char) ch);
            ch = fileInputStream.read();
        }
        return stringBuilder.toString();
    }
}
