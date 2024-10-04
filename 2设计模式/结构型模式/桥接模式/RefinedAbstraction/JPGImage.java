package com.EthanYankang.结构型模式.桥接模式.RefinedAbstraction;

import com.EthanYankang.结构型模式.桥接模式.Abstraction.Image;
import com.EthanYankang.结构型模式.桥接模式.Matrix.Matrix;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-15 10:55
 **/
public class JPGImage extends Image {
    @Override
    public void parseFile(String fileName) {
    //    模拟解析JPG文件并获得一个矩阵像素对象m
        Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName+"格式为JPG。");
    }
}
