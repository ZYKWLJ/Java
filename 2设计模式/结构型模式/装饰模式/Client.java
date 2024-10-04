package com.EthanYankang.结构型模式.装饰模式;

import com.EthanYankang.结构型模式.装饰模式.Component.Component;
import com.EthanYankang.结构型模式.装饰模式.ConcreteComponent.Windows;
import com.EthanYankang.结构型模式.装饰模式.ConcreteDecorator.BlackBorderDecorator;
import com.EthanYankang.结构型模式.装饰模式.ConcreteDecorator.ScrollBarDecorator;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-17 11:19
 **/
public class Client {
    public static void main(String[] args) {
        Component component,componentSB,componentBB;//依赖倒转原则，应该针对抽象编程
        component=new Windows();
        componentSB=new ScrollBarDecorator(component);//这里将具体构建注入！！将毛坯房注入@@//一次装修
        //componentSB.display();//展示一次装修的结果
        componentBB=new BlackBorderDecorator(componentSB);//二次装修，前面装修了窗口，现在再来装修黑色边框！！(注意传入的是前面装修过的结果)
        componentBB.display();//展示二次装修的结果
    }
}


