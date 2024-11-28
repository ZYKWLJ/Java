/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-27 09:58
 **/
//屏幕类
class Screen {
    //枚举所有的状态，currentState表示当前状态
    private State1 currentState, normalState, largerState, largestState;

    public Screen() {
        this.normalState = new NormalState1(); //创建正常状态对象
        this.largerState = new LargerState(); //创建二倍放大状态对象
        this.largestState = new LargestState(); //创建四倍放大状态对象
        this.currentState = normalState; //设置初始状态
        this.currentState.display();
    }

    public void setState(State1 state) {
        this.currentState = state;
    }

    //单击事件处理方法，封转了对状态类中业务方法的调用和状态的转换(很自然的环环相扣！)
    public void onClick() {
        if (this.currentState == normalState) {
            this.setState(largerState);
            this.currentState.display();
        } else if (this.currentState == largerState) {
            this.setState(largestState);
            this.currentState.display();
        } else if (this.currentState == largestState) {
            this.setState(normalState);
            this.currentState.display();
        }
    }
}


//抽象状态类
abstract class State1 {
    public abstract void display();
}


//正常状态类
class NormalState1 extends State1 {
    public void display() {
        System.out.println("正常大小！");
    }
}


//二倍状态类
class LargerState extends State1 {
    public void display() {
        System.out.println("二倍大小！");
    }
}


//四倍状态类
class LargestState extends State1 {
    public void display() {
        System.out.println("四倍大小！");
    }
}