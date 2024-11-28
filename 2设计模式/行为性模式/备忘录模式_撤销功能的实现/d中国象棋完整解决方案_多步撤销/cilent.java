package d中国象棋完整解决方案_多步撤销;

import c中国象棋完整解决方案_单步撤销.Chessman;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-23 10:27
 **/
class Client {
    private static int INDEX = -1; //定义一个索引来记录当前状态所在位置
    private static MementoCaretaker mc = new MementoCaretaker();

    public static void main(String args[]) {
        Chessman chess = new Chessman("车",1,1);
        play(chess);
        chess.setY(4);
        play(chess);
        chess.setX(5);
        play(chess);
        undo(chess, INDEX);
        undo(chess, INDEX);
        redo(chess, INDEX);
        redo(chess, INDEX);
    }

    //下棋
    public static void play(Chessman chess) {
        mc.setMemento(chess.save()); //保存备忘录
        INDEX++;
        System.out.println("棋子" + chess.getLabel() + "当前位置为：" + "第" + chess.getX() + "行" + "第" + chess.getY() + "列。");
    }

    //悔棋
    public static void undo(Chessman chess, int index) {//这里就是传入的Index,记录索引的！
        System.out.println("******悔棋******");
        INDEX--;
        chess.restore(mc.getMemento(index-1)); //撤销到上一个备忘录
        System.out.println("棋子" + chess.getLabel() + "当前位置为：" + "第" + chess.getX() + "行" + "第" + chess.getY() + "列。");
    }

    //撤销悔棋
    public static void redo(Chessman chess,int index) {//这里的i就是传入的Index
        System.out.println("******撤销悔棋******");
        INDEX++;
        chess.restore(mc.getMemento(index+1)); //恢复到下一个备忘录
        System.out.println("棋子" + chess.getLabel() + "当前位置为：" + "第" + chess.getX() + "行" + "第" + chess.getY() + "列。");
    }
}