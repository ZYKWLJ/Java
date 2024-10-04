package com.EthanYankang.行为性模式.命令模式.ConcreteCommand;

import com.EthanYankang.行为性模式.命令模式.Command.Command;
import com.EthanYankang.行为性模式.命令模式.Receiver.WindowHanlder;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-23 12:07
 **/
//最小化命令类：具体命令类
public class MinimizeCommand extends Command {
    private WindowHanlder whObj; //维持对请求接收者的引用

    public MinimizeCommand() {
        whObj = new WindowHanlder();
    }

    //命令执行方法，将调用请求接收者的业务方法
    public void execute() {
        whObj.minimize();
    }
}
