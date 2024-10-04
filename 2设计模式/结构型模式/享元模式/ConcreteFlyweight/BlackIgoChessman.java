package com.EthanYankang.结构型模式.享元模式.ConcreteFlyweight;

import com.EthanYankang.结构型模式.享元模式.AbstractFlyweight.IgoChessman;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-19 14:26
 **/

//黑色棋子类：具体享元类
public class BlackIgoChessman extends IgoChessman {
    public String getColor() {
        return "黑色";
    }
}
