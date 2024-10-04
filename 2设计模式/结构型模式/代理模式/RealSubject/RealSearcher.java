package com.EthanYankang.结构型模式.代理模式.RealSubject;

import com.EthanYankang.结构型模式.代理模式.Subject.Searcher; /**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-20 18:11
 **/
public class RealSearcher implements Searcher {
    // 模拟查询商务信息
    @Override
    public String DoSearch(String userId, String keyword) {
        System.out.println("用户'" + userId + "'使用关键词'" + keyword + "'查询商务信息！");
        return "返回具体内容";
    }
}