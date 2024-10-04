package com.EthanYankang.结构型模式.享元模式.外部类;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-19 18:02
 **/

//坐标类：外部状态类
public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}