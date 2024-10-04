package com.EthanYankang.行为性模式.责任链模式.ConcreteHandler;

import com.EthanYankang.行为性模式.责任链模式.Handler.Approver;
import com.EthanYankang.行为性模式.责任链模式.PurchaseRequest;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-22 13:36
 **///经理类：具体处理者
public
class Manager extends Approver {
    public Manager(String name) {
        super(name);
    }

    //具体请求处理方法
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 80000) {
            System.out.println("经理" + this.name + "审批采购单：" + request.getNumber() + "，金额：" + request.getAmount() + "元，采购目的：" + request.getPurpose() + "。");  //处理请求
        }
        else {
            this.successor.processRequest(request);  //转发请求
        }
    }
}