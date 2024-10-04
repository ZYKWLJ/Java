package com.EthanYankang.结构型模式.桥接模式;

import com.EthanYankang.结构型模式.桥接模式.Abstraction.Image;
import com.EthanYankang.结构型模式.桥接模式.Implmentor.ImageImp;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-15 11:04
 **/
class Client {
    public static void main(String args[]) {
        //如下，将图像种类与显示的操作系统分离
        Image image;
        ImageImp imp;

        image = (Image)XMLUtil.getBean("image");
        imp = (ImageImp)XMLUtil.getBean("os");
        image.setImageImp(imp);
        image.parseFile("小龙女");
    }
}