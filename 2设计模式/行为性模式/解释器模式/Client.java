package com.EthanYankang.行为性模式.解释器模式;

import com.EthanYankang.行为性模式.解释器模式.InstructionHandler.InstructionHandler;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-27 09:56
 **/
public class Client {
    public static void main(String args[]) {
        String instruction = "up move 5 and down run 10 and left move 5";
        InstructionHandler handler = new InstructionHandler();
        handler.handle(instruction);
        String outString;
        outString = handler.output();
        System.out.println(outString);
    }
}
