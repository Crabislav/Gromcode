package lesson10.homework;

import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFormCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFormCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    void validateOrder() {
        String[] validCitiesForOrderFrom = {"Киев", "Львов"};

        for (String city : validCitiesForOrderFrom) {
            if (city.equals(getShipFromCity()) && getBasePrice() >= 500 && !getCustomerOwned().getName().equals("Тест")) {
                setDateConfirmed(new Date());
            }
        }
    }

    @Override
    void calculatePrice() {
//        double totalPrice = getBasePrice() > 500 ? getBasePrice() + getBasePrice() * 0.05d : getBasePrice() + getBasePrice() * 0.02d;
//        setTotalPrice(totalPrice);

        if (getBasePrice() > 5000) {
            setTotalPrice(getBasePrice() + getBasePrice() * 0.05d);
        } else {
            setTotalPrice(getBasePrice() + getBasePrice() * 0.02d);
        }


    }

}
