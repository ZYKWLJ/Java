/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-27 09:37
 **/
class Client2 {
    public static void main(String args[]) {
        Switch s1,s2;
        s1=new Switch("开关1");
        s2=new Switch("开关2");

        s1.on();
        s2.on();
        s1.off();
        s2.off();
        s2.on();
        s1.on();
    }
}