package com.EthanYankang.结构型模式.组合模式.Component;

import java.lang.reflect.AnnotatedArrayType;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-16 09:45
 **/
public abstract class AbstractFile {
    public abstract void add(AbstractFile file);
    public abstract void remove(AbstractFile file);
    public abstract AbstractFile getChild(int i);
    public abstract void killVirus();
}
