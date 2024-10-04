package com.EthanYankang.结构型模式.代理模式;

import com.EthanYankang.结构型模式.代理模式.Subject.Searcher;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-20 18:16
 **/
public class Client {
    public static void main(String[] args) {
        Searcher searcher;
        searcher= (Searcher) XMLUtil.getBean();
        String res= searcher.DoSearch("ZHEGNYANGKANG","123");
        System.out.println(res);
    }
}
