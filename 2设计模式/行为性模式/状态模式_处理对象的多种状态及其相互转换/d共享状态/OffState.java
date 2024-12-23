/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-27 09:39
 **/
//关闭状态
class OffState extends State {
    public void on(Switch s) {
        System.out.println("打开！");
        s.setState(Switch.getState("on"));
    }

    public void off(Switch s) {
        System.out.println("已经关闭！");
    }
}