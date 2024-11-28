package c中国象棋完整解决方案_单步撤销;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-23 10:07
 **/
class Client {
    public static void main(String args[]) {
        MementoCaretaker mc = new MementoCaretaker();//仅仅用来保存备忘录
        Chessman chess = new Chessman("车",1,1);
        display(chess);
        mc.setMemento(chess .save()); //保存状态
        chess.setY(4);
        display(chess);
        mc.setMemento(chess.save()); //保存状态
        display(chess);
        chess.setX(5);
        display(chess);
        System.out.println("******悔棋******");
        chess.restore(mc.getMemento()); //恢复状态
        display(chess);
        //仅仅可以用来恢复一步，后面的就不行了！
        System.out.println("******悔棋******");
        chess.restore(mc.getMemento()); //恢复状态
        display(chess);

        System.out.println("******悔棋******");
        chess.restore(mc.getMemento()); //恢复状态
        display(chess);
    }

    public static void display(Chessman chess) {
        System.out.println("棋子" + chess.getLabel() + "当前位置为：" + "第" + chess.getX() + "行" + "第" + chess.getY() + "列。");
    }
}