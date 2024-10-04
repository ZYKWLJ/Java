package com.EthanYankang.结构型模式.外观模式.SubSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-18 11:19
 **/
public class FileWriter {
    public String writeFile(String s) throws IOException{
        String path="D:\\设计模式\\CreatePattern\\src\\main\\resources\\结构型模式\\FacadePattern\\密文.txt";
        File file = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(s.getBytes(StandardCharsets.UTF_8));
        return path;
    }
}
