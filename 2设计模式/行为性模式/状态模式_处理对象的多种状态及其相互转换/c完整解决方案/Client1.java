/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-10-27 09:22
 **/
class Client1 {
    public static void main(String args[]) {
        Account acc = new Account("段誉",0.0);
        acc.deposit(1000);
        acc.withdraw(2000);
        acc.deposit(3000);
        acc.withdraw(4000);
        acc.withdraw(1000);
        acc.computeInterest();
    }
}
