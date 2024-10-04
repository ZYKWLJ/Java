package com.EthanYankang.行为性模式.命令模式.命令模式的撤销操作.Invoker;

import com.EthanYankang.行为性模式.命令模式.命令模式的撤销操作.AbstractCommand.AbstractCommand;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-23 16:18
 **/ //计算器界面类：请求发送者
public class CalculatorForm {
    private AbstractCommand command;

    public void setCommand(AbstractCommand command) {
        this.command = command;
    }

    //调用命令对象的execute()方法执行运算
    public void compute(int value) {
        int i = command.execute(value);
        System.out.println("执行运算，运算结果为：" + i);
    }

    //调用命令对象的undo()方法执行撤销
    public void undo() {
        int i = command.undo();
        System.out.println("执行撤销，运算结果为：" + i);
    }
}
