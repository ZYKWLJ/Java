/**
 * @Author: Ethan Yankang
 * @Program: Java
 * @Date: 2024-11-12 11:36
 **/
class Client11 {
    public static void main(String args[]) {
        MovieTicket1 mt = new MovieTicket1();
        double originalPrice = 60.0;
        double currentPrice;

        mt.setPrice(originalPrice);
        System.out.println("原始价为：" + originalPrice);
        System.out.println("---------------------------------");

        Discount discount;
        discount = (Discount) XMLUtils111.getBean(); //读取配置文件并反射生成具体折扣对象
        mt.setDiscount(discount); //注入折扣对象

        currentPrice = mt.getPrice();
        System.out.println("折后价为：" + currentPrice);
    }
}