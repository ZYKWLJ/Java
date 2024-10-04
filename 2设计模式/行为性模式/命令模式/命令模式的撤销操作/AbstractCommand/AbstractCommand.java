package com.EthanYankang.行为性模式.命令模式.命令模式的撤销操作.AbstractCommand;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-23 16:16
 **/
public //抽象命令类
abstract class AbstractCommand {
    public abstract int execute(int value); //声明命令执行方法execute()
    public abstract int undo(); //声明撤销方法undo()
}