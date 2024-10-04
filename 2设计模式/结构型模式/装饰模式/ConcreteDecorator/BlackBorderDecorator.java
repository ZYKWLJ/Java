package com.EthanYankang.结构型模式.装饰模式.ConcreteDecorator;

import com.EthanYankang.结构型模式.装饰模式.Component.Component;
import com.EthanYankang.结构型模式.装饰模式.Decorator.Decorator;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-17 11:16
 **/
public class BlackBorderDecorator extends Decorator {
    public BlackBorderDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        this.setBlackBorder();
        super.display();
    }

    private void setBlackBorder() {
        System.out.println("为构件增加黑色边框!");
    }
}
