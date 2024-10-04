package com.EthanYankang.结构型模式.外观模式.Client;

import com.EthanYankang.结构型模式.外观模式.Facade.Facade;

import java.io.IOException;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-18 11:27
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        Facade facade = new Facade();
        String string = facade.fileEncode("D:\\设计模式\\CreatePattern\\src\\main\\resources\\结构型模式\\FacadePattern\\明文.txt");
        System.out.println(string);
    }
}
