package com.EthanYankang.行为性模式.解释器模式.TerminalExpression;

import com.EthanYankang.行为性模式.解释器模式.AbstractExpression.AbstractNode; /**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-27 09:45
 **/
public //方向解释：终结符表达式
class DirectionNode extends AbstractNode {
    private String direction;

    public DirectionNode(String direction) {
        this.direction = direction;
    }

    //方向表达式的解释操作
    public String interpret() {
        if (direction.equalsIgnoreCase("up")) {
            return "向上";
        }
        else if (direction.equalsIgnoreCase("down")) {
            return "向下";
        }
        else if (direction.equalsIgnoreCase("left")) {
            return "向左";
        }
        else if (direction.equalsIgnoreCase("right")) {
            return "向右";
        }
        else {
            return "无效指令";
        }
    }
}
