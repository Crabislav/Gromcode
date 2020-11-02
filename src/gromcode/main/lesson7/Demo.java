package gromcode.main.lesson7;

import java.util.Date;

public class Demo {
    /*public static void main(String[] args) {
        Demo demo = new Demo();

        Deal deal = demo.createOrder();
        System.out.println(deal.city);

        Deal deal1 = demo.createOrderAndCallMethods();
        System.out.println(deal1.city);
    }*/

    public Deal createOrder() {
        return new Deal(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");
    }


    public Deal createOrderAndCallMethods() {
        Date todayDate = new Date();
        Deal deal = new Deal(100, todayDate, true, todayDate, "Kiev", "Ukraine", "SomeValue");

        if (deal.isValidType()) {
            deal.checkPrice();
            deal.confirmOrder();

        }
        return deal;
    }
}
