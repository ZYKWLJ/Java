package com.EthanYankang.行为性模式.责任链模式.Handler;

import com.EthanYankang.行为性模式.责任链模式.PurchaseRequest; /**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-22 13:14
 **/
public abstract class Approver {
    protected Approver successor; //定义后继对象
    protected String name; //审批者姓名

    public Approver(String name) {
        this.name = name;
    }

    //设置后继者
    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }

    //抽象请求处理方法
    public abstract void processRequest(PurchaseRequest request);
}

