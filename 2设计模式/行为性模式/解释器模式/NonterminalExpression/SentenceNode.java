package com.EthanYankang.行为性模式.解释器模式.NonterminalExpression;

import com.EthanYankang.行为性模式.解释器模式.AbstractExpression.AbstractNode; /**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-27 09:44
 **/
public //简单句子解释：非终结符表达式
class SentenceNode extends AbstractNode {
    private AbstractNode direction;
    private AbstractNode action;
    private AbstractNode distance;

    public SentenceNode(AbstractNode direction, AbstractNode action, AbstractNode distance) {
        this.direction = direction;
        this.action = action;
        this.distance = distance;
    }

    //简单句子的解释操作
    public String interpret() {
        return direction.interpret() + action.interpret() + distance.interpret();
    }
}
