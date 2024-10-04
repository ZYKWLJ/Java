package com.EthanYankang.结构型模式.组合模式;

import com.EthanYankang.结构型模式.组合模式.Component.AbstractFile;
import com.EthanYankang.结构型模式.组合模式.Composite.Folder;
import com.EthanYankang.结构型模式.组合模式.Leaf.ImageFile;
import com.EthanYankang.结构型模式.组合模式.Leaf.TextFile;
import com.EthanYankang.结构型模式.组合模式.Leaf.VideoFile;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-16 10:01
 **/
public class Client {
    public static void main(String[] args) {
    //    依据依赖倒转原则，针对接口编程
        AbstractFile file1,file2,file3,file4,file5,folder1,folder2,folder3,folder4;

        folder1=new Folder("EthanYankang的资料");
        folder2=new Folder("图像文件");
        folder3=new Folder("文本文件");
        folder4=new Folder("视频文件");
        file1 = new ImageFile("小龙女.jpg");
        file2 = new ImageFile("张无忌.gif");
        file3 = new TextFile("九阴真经.txt");
        file4 = new TextFile("葵花宝典.doc");
        file5 = new VideoFile("笑傲江湖.rmvb");

        folder2.add(file1);
        folder2.add(file2);
        folder3.add(file3);
        folder3.add(file4);
        folder4.add(file5);
        folder1.add(folder2);
        folder1.add(folder3);
        folder1.add(folder4);

        //从“Sunny的资料”节点开始进行杀毒操作
        folder1.killVirus();

    }
}
