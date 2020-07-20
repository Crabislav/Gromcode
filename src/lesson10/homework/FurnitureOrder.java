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
            if (city == getShipFromCity() && getBasePrice() >= 500 && getCustomerOwned().getName() == "Тест") {
                setDateConfirmed(new Date());
            }
        }
    }

    @Override
    void calculatePrice() {
        if (getBasePrice() < 5000) {
            setTotalPrice(getBasePrice() + getBasePrice() * 0.05d);
        } else {
            setTotalPrice(getBasePrice() + getBasePrice() * 0.02d);
        }


    }

}
