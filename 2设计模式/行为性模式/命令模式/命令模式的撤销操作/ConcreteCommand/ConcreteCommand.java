package com.EthanYankang.行为性模式.命令模式.命令模式的撤销操作.ConcreteCommand;

import com.EthanYankang.行为性模式.命令模式.命令模式的撤销操作.AbstractCommand.AbstractCommand;
import com.EthanYankang.行为性模式.命令模式.命令模式的撤销操作.Adder;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-23 16:17
 **/
public //具体命令类
class ConcreteCommand extends AbstractCommand {
    private Adder adder = new Adder();
    private int value;

    //实现抽象命令类中声明的execute()方法，调用加法类的加法操作
    public int execute(int value) {
        this.value=value;
        return adder.add(value);
    }

    //实现抽象命令类中声明的undo()方法，通过加一个相反数来实现加法的逆向操作,这就是核心机理！！
    public int undo() {
        return adder.add(-value);
    }
}

