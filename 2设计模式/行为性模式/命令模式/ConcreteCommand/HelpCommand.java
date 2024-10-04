package com.EthanYankang.行为性模式.命令模式.ConcreteCommand;

import com.EthanYankang.行为性模式.命令模式.Command.Command;
import com.EthanYankang.行为性模式.命令模式.Receiver.HelpHandler;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-23 12:06
 **/
public class HelpCommand extends Command {
    private HelpHandler hhObj; //维持对请求接收者的引用

    public HelpCommand() {
        hhObj = new HelpHandler();
    }

    //命令执行方法，将调用请求接收者的业务方法
    public void execute() {
        hhObj.display();
    }
}

