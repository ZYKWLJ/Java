package d中国象棋完整解决方案_多步撤销;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-23 10:27
 **/
import c中国象棋完整解决方案_单步撤销.ChessmanMemento;

import java.util.*;

class MementoCaretaker {
    //定义一个集合来存储多个备忘录
    private ArrayList mementolist = new ArrayList();

    public ChessmanMemento getMemento(int i) {
        return (ChessmanMemento)mementolist.get(i);
    }

    public void setMemento(ChessmanMemento memento) {
        mementolist.add(memento);
    }
}