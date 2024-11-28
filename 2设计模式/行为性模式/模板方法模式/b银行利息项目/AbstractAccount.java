import java.util.Scanner;

/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-11-12 14:50
 **/
public abstract class AbstractAccount {
    public boolean Validate(String account, String password) {
        return account.equals("EthanYankang") && password.equals("123456");
    }

//    基本方法——抽象方法
    public abstract void CaluculateInterest();
//    基本方法——具体方法
    public void Display(){
        System.out.println("显示利息！");
    }
//    模版方法
    public void Handle(String account,String password){
        if (!Validate(account, password)){
            System.out.println("账户或密码错误！");
            System.out.println("用户登录失败qwq");
            return;
        }else {
            System.out.println("用户验证成功!\n欢迎EthanYankang~~~");
            CaluculateInterest();
            Display();
        }
    }
}
