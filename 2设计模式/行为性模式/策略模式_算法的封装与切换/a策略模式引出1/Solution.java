/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-11-12 11:02
 **/
//电影票类
class MovieTicket {
    private double price; //电影票价格
    private String type; //电影票类型

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return this.calculate();//计算
    }

    //计算打折之后的票价
    public double calculate() {//这不就是最原始的模式吗哈哈，像简单工厂模式传参的
        //学生票折后票价计算
        if(this.type.equalsIgnoreCase("student")) {
            System.out.println("学生票：");
            return this.price * 0.8;
        }
        //儿童票折后票价计算
        else if(this.type.equalsIgnoreCase("children") && this.price >= 20 ) {
            System.out.println("儿童票：");
            return this.price - 10;
        }
        //VIP票折后票价计算
        else if(this.type.equalsIgnoreCase("vip")) {
            System.out.println("VIP票：");
            System.out.println("增加积分！");
            return this.price * 0.5;
        }
        else {
            return this.price; //如果不满足任何打折要求，则返回原始票价
        }
    }
}

class Solution {
    public static void main(String args[]) {
        MovieTicket mt = new MovieTicket();
        double originalPrice = 60.0; //原始票价
        double currentPrice; //折后价

        mt.setPrice(originalPrice);
        System.out.println("原始价为：" + originalPrice);
        System.out.println("---------------------------------");

        mt.setType("student"); //学生票
        currentPrice = mt.getPrice();
        System.out.println("折后价为：" + currentPrice);
        System.out.println("---------------------------------");

        mt.setType("children"); //儿童票
        currentPrice = mt.getPrice();
        System.out.println("折后价为：" + currentPrice);
    }
}