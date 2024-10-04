package com.EthanYankang.结构型模式.装饰模式.ConcreteComponent;

import com.EthanYankang.结构型模式.装饰模式.Component.Component;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-17 11:07
 **/
public class ListBox extends Component {
    @Override
    public void display() {
        System.out.println("显示列表框");
    }
}
