package com.EthanYankang.结构型模式.代理模式.Proxy;

import com.EthanYankang.结构型模式.代理模式.RealSubject.RealSearcher;import com.EthanYankang.结构型模式.代理模式.Subject.Searcher;import com.EthanYankang.结构型模式.代理模式.新增业务类.AccessValidator;import com.EthanYankang.结构型模式.代理模式.新增业务类.Logger; /**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-20 18:12
 **/
public class ProxySearcher implements Searcher {
    private RealSearcher searcher = new RealSearcher();
    private AccessValidator validator;
    private Logger logger;

    @Override
    public String DoSearch(String userId, String keyword) {
        // 如果身份验证成功，则执行查询
        if (this.Validate(userId)) { //代理类的新增功能1——身份验证
            String result = searcher.DoSearch(userId, keyword);
            this.Log(userId);        //代理类的新增功能2——记录日志
            return result;
        } else {
            return null;
        }
    }

    // 创建访问验证对象并调用其Validate()方法实现身份验证
    public boolean Validate(String userId) {
        validator = new AccessValidator();
        return validator.Validate(userId);
    }

    // 创建日志记录对象并调用其Log()方法实现日志记录
    public void Log(String userId) {
        logger = new Logger();
        logger.Log(userId);
    }
}
