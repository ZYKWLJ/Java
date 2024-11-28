/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-13 17:37
 **/
public class Main {
    public static void main(String[] args) throws Exception {
        a通过继承Thread类创建 通过继承Thread类创建 = new a通过继承Thread类创建();
        通过继承Thread类创建.run();

        b通过实现runnable接口实现 b通过实现runnable接口实现 = new b通过实现runnable接口实现();
        b通过实现runnable接口实现.run();

        c通过实现callable接口实现 c通过实现callable接口实现 = new c通过实现callable接口实现();
        System.out.println(c通过实现callable接口实现.call());

        d通过线程池 d通过线程池 = new d通过线程池();
        d通过线程池.threadPool(5);
    }
}
