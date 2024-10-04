package com.EthanYankang.结构型模式.代理模式.新增业务类;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-20 18:08
 **/
public class AccessValidator {
    // 模拟实现登录验证
    public boolean Validate(String userId) {
        System.out.println("在数据库中验证用户'" + userId + "'是否是合法用户？");
        if ("杨过".equals(userId)) {
            System.out.println("'" + userId + "'登录成功！");
            return true;
        } else {
            System.out.println("'" + userId + "'登录失败！");
            return false;
        }
    }
}
