package com.EthanYankang.行为性模式.责任链模式;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-22 13:12
 **/
@Data
@AllArgsConstructor
public class PurchaseRequest {
    private double amount;
    private int number;
    private String purpose;
}
