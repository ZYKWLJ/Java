package com.EthanYankang.结构型模式.桥接模式.RefinedAbstraction;

import com.EthanYankang.结构型模式.桥接模式.Abstraction.Image;
import com.EthanYankang.结构型模式.桥接模式.Matrix.Matrix;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-15 10:59
 **/
public class PNGImage extends Image {
    @Override
    public void parseFile(String fileName) {
//模拟解析PNG文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName + "，格式为PNG。");
    }
}
