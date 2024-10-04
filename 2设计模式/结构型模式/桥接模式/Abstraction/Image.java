package com.EthanYankang.结构型模式.桥接模式.Abstraction;

import com.EthanYankang.结构型模式.桥接模式.Implmentor.ImageImp;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-15 10:46
 **/

//抽象图像类：抽象类
public abstract class Image {
    protected ImageImp imp;//就是这里实现了不同操作系统之间的桥接@@

    public void setImageImp(ImageImp imp) {
        this.imp = imp;
    }

    public abstract void parseFile(String fileName);
}
