package com.EthanYankang.行为性模式.解释器模式.带环境类的解释器模式;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-27 10:15
 **/
public class Client{
    public static void main(String[] args){
        String text = "LOOP 2 PRINT 杨过 SPACE SPACE PRINT 小龙女 BREAK END PRINT 郭靖 SPACE SPACE PRINT 黄蓉";
        Context context = new Context(text);

        Node node = new ExpressionNode();
        node.interpret(context);
        node.execute();
    }
}
/*
编译并运行程序，输出结果如下：

杨过     小龙女

杨过     小龙女

郭靖     黄蓉

*/