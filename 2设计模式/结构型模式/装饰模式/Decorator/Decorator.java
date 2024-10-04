package com.EthanYankang.结构型模式.装饰模式.Decorator;

import com.EthanYankang.结构型模式.装饰模式.Component.Component;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-17 11:08
 **/
public class Decorator extends Component{
    private Component component;  //维持对抽象构件类型对象的引用

    public Decorator(Component component){  //注入抽象构件类型的对象
        this.component = component;
    }

    public void display() {
        component.display();
    }
}
