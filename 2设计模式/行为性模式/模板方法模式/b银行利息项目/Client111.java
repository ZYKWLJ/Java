/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-11-12 15:06
 **/
public class Client111 {
    public static void main(String[] args) {
        AbstractAccount abstractAccount;
        abstractAccount = (AbstractAccount) XMLUtil1.getBean();
        abstractAccount.Handle("EthanYankang","123456");
    }
}
