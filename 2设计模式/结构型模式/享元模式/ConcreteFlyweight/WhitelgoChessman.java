package com.EthanYankang.结构型模式.享元模式.ConcreteFlyweight;

import com.EthanYankang.结构型模式.享元模式.AbstractFlyweight.IgoChessman;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-19 14:28
 **/
public class WhitelgoChessman extends IgoChessman {
    public String getColor() {
        return "白色";
    }
}
