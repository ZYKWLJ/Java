package com.EthanYankang.结构型模式.桥接模式.ConcreteImplementor;

import com.EthanYankang.结构型模式.桥接模式.Implmentor.ImageImp;
import com.EthanYankang.结构型模式.桥接模式.Matrix.Matrix;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-15 10:51
 **/
public class WindowsImpl implements ImageImp {
    @Override
    public void doPaint(Matrix m) {
        System.out.println("在Windows操作系统下显示图像");
    }
}
