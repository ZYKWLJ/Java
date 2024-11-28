/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-27 09:38
 **/
abstract class State {
    public abstract void on(Switch s);
    public abstract void off(Switch s);
}