package com.EthanYankang.行为性模式.命令模式.命令模式的撤销操作;

import com.EthanYankang.行为性模式.命令模式.命令模式的撤销操作.AbstractCommand.AbstractCommand;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-23 16:15
 **/
public //加法类：请求接收者
class Adder {
    private int num=0; //定义初始值为0

    //加法操作，每次将传入的值与num作加法运算，再将结果返回
    public int add(int value) {
        num += value;
        return num;
    }
}



