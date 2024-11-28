package c中国象棋完整解决方案_单步撤销;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-23 10:02
 **/

//象棋棋子类：原发器
public class Chessman {
    private String label;
    private int x;
    private int y;

    public Chessman(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getLabel() {
        return (this.label);
    }

    public int getX() {
        return (this.x);
    }

    public int getY() {
        return (this.y);
    }

    //保存状态
    public ChessmanMemento save() {
        return new ChessmanMemento(this.label, this.x, this.y);//将状态保存在备忘录里面
    }

    //恢复状态
    public void restore(ChessmanMemento memento) {//从备忘录里面恢复状态
        this.label = memento.getLabel();
        this.x = memento.getX();
        this.y = memento.getY();
    }
}


//象棋棋子备忘录管理类：负责人
class MementoCaretaker {
    private ChessmanMemento memento;

    public ChessmanMemento getMemento() {
        return memento;
    }

    public void setMemento(ChessmanMemento memento) {
        this.memento = memento;
    }
}