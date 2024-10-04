package com.EthanYankang.行为性模式.解释器模式.TerminalExpression;

import com.EthanYankang.行为性模式.解释器模式.AbstractExpression.AbstractNode; /**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-27 09:46
 **/
public
//距离解释：终结符表达式
class DistanceNode extends AbstractNode {
    private String distance;

    public DistanceNode(String distance) {
        this.distance = distance;
    }

    //距离表达式的解释操作
    public String interpret() {
        return this.distance;
    }
}

