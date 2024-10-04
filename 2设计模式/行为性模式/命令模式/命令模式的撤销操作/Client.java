package com.EthanYankang.行为性模式.命令模式.命令模式的撤销操作;

import com.EthanYankang.行为性模式.命令模式.命令模式的撤销操作.AbstractCommand.AbstractCommand;
import com.EthanYankang.行为性模式.命令模式.命令模式的撤销操作.ConcreteCommand.ConcreteCommand;
import com.EthanYankang.行为性模式.命令模式.命令模式的撤销操作.Invoker.CalculatorForm;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-23 16:19
 **/
public class Client {
    public static void main(String args[]) {
        CalculatorForm form = new CalculatorForm();
        AbstractCommand command;
        command = new ConcreteCommand();
        form.setCommand(command); //向发送者注入命令对象

        form.compute(10);
        form.compute(5);
        form.compute(10);
        form.undo();
    }
}