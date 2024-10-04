package com.EthanYankang.结构型模式.代理模式.新增业务类;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-20 18:08
 **/
public class Logger {
    // 模拟实现日志记录
    public void Log(String userId) {
        System.out.println("更新数据库，用户'" + userId + "'查询次数加1！");
    }
}