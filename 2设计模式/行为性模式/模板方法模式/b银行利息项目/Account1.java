/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-11-12 15:02
 **/
public class Account1 extends AbstractAccount {
    //覆盖父类的方法
    @Override
    public void CaluculateInterest() {
        System.out.println("按活期利率计算利息！");
    }
}
