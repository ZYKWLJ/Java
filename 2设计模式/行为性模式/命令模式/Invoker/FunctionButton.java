package com.EthanYankang.行为性模式.命令模式.Invoker;

import com.EthanYankang.行为性模式.命令模式.Command.Command;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-23 12:04
 **/

//功能键类：请求发送者Invoker的角色
public class FunctionButton {
    private String name; //功能键名称
    private Command command; //维持一个抽象命令对象的引用

    public FunctionButton(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    //为功能键注入命令
    public void setCommand(Command command) {
        this.command = command;
    }

    //发送请求的方法
    public void onClick() {
        System.out.print("点击功能键：");
        command.execute();
    }
}