package com.EthanYankang.行为性模式.责任链模式.ConcreteHandler;

import com.EthanYankang.行为性模式.责任链模式.Handler.Approver;
import com.EthanYankang.行为性模式.责任链模式.PurchaseRequest;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-22 13:23
 **/
//董事会类：具体处理者
public class Congress extends Approver {
    public Congress(String name) {
        super(name);
    }

    //具体请求处理方法
    public void processRequest(PurchaseRequest request) {
        System.out.println("召开董事会审批采购单：" + request.getNumber() + "，金额：" + request.getAmount() + "元，采购目的：" + request.getPurpose() + "。");        //处理请求
    }
}
