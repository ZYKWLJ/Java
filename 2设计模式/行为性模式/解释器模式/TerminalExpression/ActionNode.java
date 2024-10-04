package com.EthanYankang.行为性模式.解释器模式.TerminalExpression;

import com.EthanYankang.行为性模式.解释器模式.AbstractExpression.AbstractNode; /**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-27 09:46
 **/
public
//动作解释：终结符表达式
class ActionNode extends AbstractNode {
    private String action;

    public ActionNode(String action) {
        this.action = action;
    }

    //动作（移动方式）表达式的解释操作
    public String interpret() {
        if (action.equalsIgnoreCase("move")) {
            return "移动";
        }
        else if (action.equalsIgnoreCase("run")) {
            return "快速移动";
        }
        else {
            return "无效指令";
        }
    }
}
