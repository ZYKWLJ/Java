package com.EthanYankang.行为性模式.解释器模式.NonterminalExpression;

import com.EthanYankang.行为性模式.解释器模式.AbstractExpression.AbstractNode; /**
 * @Author: Ethan Yankang
 * @Program: 设计模式
 * @Date: 2024-09-27 09:43
 **/
public
//And解释：非终结符表达式（这里会）
class AndNode extends AbstractNode {
    private AbstractNode left; //And的左表达式
    private AbstractNode right; //And的右表达式

    public AndNode(AbstractNode left, AbstractNode right) {
        this.left = left;
        this.right = right;
    }

    //And表达式解释操作
    public String interpret() {
        return left.interpret() + "再" + right.interpret();
    }
}

