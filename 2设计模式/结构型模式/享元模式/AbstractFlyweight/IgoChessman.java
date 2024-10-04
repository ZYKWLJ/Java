package com.EthanYankang.结构型模式.享元模式.AbstractFlyweight;

import com.EthanYankang.结构型模式.享元模式.外部类.Coordinates;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-19 14:25
 **/

//围棋棋子类：抽象享元类
public abstract class IgoChessman {
    public abstract String getColor();

    public void display(Coordinates coord){
        System.out.println("棋子颜色：" + this.getColor() + "，棋子位置：" + coord.getX() + "，" + coord.getY() );
    }
}

