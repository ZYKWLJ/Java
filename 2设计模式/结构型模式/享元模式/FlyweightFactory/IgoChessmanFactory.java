package com.EthanYankang.结构型模式.享元模式.FlyweightFactory;

import com.EthanYankang.结构型模式.享元模式.ConcreteFlyweight.BlackIgoChessman;
import com.EthanYankang.结构型模式.享元模式.ConcreteFlyweight.WhitelgoChessman;
import com.EthanYankang.结构型模式.享元模式.AbstractFlyweight.IgoChessman;

import java.util.Hashtable;

/**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-19 14:31
 **/

//围棋棋子工厂类，享元工厂类，使用单例模式进行设计
public class IgoChessmanFactory {
    private static IgoChessmanFactory instance=new IgoChessmanFactory();
    private static Hashtable hashtable;     //使用Hashtable来存储享元对象，充当享元池

    private IgoChessmanFactory(){
        hashtable=new Hashtable<>();
        IgoChessman black,white;
        black=new BlackIgoChessman();
        white=new WhitelgoChessman();
        hashtable.put("b",black);//这里就是简单工厂模式嘛！！！
        hashtable.put("w",white);
    }

//   返回享元工厂类的唯一实例
    public static IgoChessmanFactory getInstance(){//单例模式
        return instance;
    }

//    通过key来存储在hashtable中的享元对象
    public static IgoChessman getIgoChessman(String color){
        return (IgoChessman) hashtable.get(color);
    }
}
