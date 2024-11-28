/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-27 09:38
 **/
class OnState extends State {
    public void on(Switch s) {
        System.out.println("已经打开！");
    }

    public void off(Switch s) {
        System.out.println("关闭！");
        s.setState(Switch.getState("off"));
    }
}