package com.EthanYankang.结构型模式.组合模式.Leaf;

import com.EthanYankang.结构型模式.组合模式.Component.AbstractFile;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-16 09:54
 **/
public class TextFile extends AbstractFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("当前文件不可操作此类型");
    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("当前文件不可操作此类型");
    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("当前文件不可操作此类型");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("----对文本文件"+name+"杀毒");
    }

    public void setName(String name) {
        this.name = name;
    }
}

