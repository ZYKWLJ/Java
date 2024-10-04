package com.EthanYankang.结构型模式.装饰模式.ConcreteDecorator;

import com.EthanYankang.结构型模式.装饰模式.Component.Component;
import com.EthanYankang.结构型模式.装饰模式.Decorator.Decorator;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-17 11:11
 **/
public class ScrollBarDecorator extends Decorator {
    public ScrollBarDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {         //这就是定义中的operation()
        this.setScrollBar();
        super.display();            //注意看这里，原来的具体构建是只有展示功能的，但是现在在上面有了增加滚动条的功能。这不就实现了装饰的作用了吗？
    }

    private void setScrollBar() {   //新增行为是嵌入到上面的display()中的，不能够单独调用，因为Component里面灭有声明对应的方法
        System.out.println("为构件增加滚动条！");
    }
}
