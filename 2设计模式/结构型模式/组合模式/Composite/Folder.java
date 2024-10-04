package com.EthanYankang.结构型模式.组合模式.Composite;

import com.EthanYankang.结构型模式.组合模式.Component.AbstractFile;

import java.util.ArrayList;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-16 09:55
 **/
public class Folder extends AbstractFile {
    private String name;
    private ArrayList<AbstractFile> filelist=new ArrayList<AbstractFile>();//用于存放文件的文件夹


    public Folder(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        filelist.add(file);
        System.out.println("文件添加成功");
    }

    @Override
    public void remove(AbstractFile file) {
        filelist.remove(file);
        System.out.println("文件删除成功");
    }

    @Override
    public AbstractFile getChild(int i) {
        return (AbstractFile) filelist.get(i);
        //return null;
    }

    @Override
    public void killVirus() {
    //    依次递归遍历杀毒
        System.out.println("****对文件夹进行"+name+"杀毒");
        for (AbstractFile abstractFile : filelist) {
           abstractFile.killVirus();
        }
    }
}
