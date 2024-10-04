package com.EthanYankang.行为性模式.责任链模式;

import com.EthanYankang.行为性模式.责任链模式.ConcreteHandler.*;
import com.EthanYankang.行为性模式.责任链模式.Handler.Approver;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-22 13:25
 **/
public class Client {
    public static void main(String[] args) {
        Approver wujizhang,guoyang,ronghuang,jiguo,meeting;
        wujizhang=new Director("张无忌");
        guoyang=new VicePresident("杨过");
        ronghuang=new Manager("黄蓉");
        jiguo=new President("郭靖");
        meeting=new Congress("董事会");


    //    创建责任链
        wujizhang.setSuccessor(ronghuang);//这一行是增加的，将“黄蓉“作为"杨过"的下家。
        ronghuang.setSuccessor(guoyang);//这一行是增加的：将“杨过”作为“黄蓉"的下家。
        guoyang.setSuccessor(jiguo);
        jiguo.setSuccessor(meeting);

    //    创建采购单,都是从责任链最上面张无忌的往下传
        PurchaseRequest pr1=new PurchaseRequest(4500,10001,"购买倚天剑");
        wujizhang.processRequest(pr1);

        PurchaseRequest pr2 = new PurchaseRequest(60000,10002,"购买《葵花宝典》");
        wujizhang.processRequest(pr2);

        PurchaseRequest pr3 = new PurchaseRequest(160000,10003,"购买《金刚经》");
        wujizhang.processRequest(pr3);

        PurchaseRequest pr4 = new PurchaseRequest(800000,10004,"购买桃花岛");
        wujizhang.processRequest(pr4);

    }
}

//如果需要新增一个具体处理者，客户端完全不需要改变，只需要在具体处理者类中增加 一个即可。符合开闭原则。
