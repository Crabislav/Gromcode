package gromcode.main.lesson10.homework;

import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFormCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFormCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    void validateOrder() {
        if (validateCity(getShipFromCity()) && getBasePrice() >= 500 && getCustomerOwned().getName() != "Тест") {
            setDateConfirmed(new Date());
        }
    }

    private boolean validateCity(String cityToValidate) {
        String[] validCitiesForOrderFrom = {"Киев", "Львов"};
        for (String city : validCitiesForOrderFrom) {
            if (city == cityToValidate) {
                return true;
            }
        }
        return false;
    }

    @Override
    void calculatePrice() {
        double totalPrice = getBasePrice() + calculateShippingPrice();
        setTotalPrice(totalPrice);
    }

    private double calculateShippingPrice() {
        if (getBasePrice() < 5000) {
            return getBasePrice() * 0.05d;
        } else {
            return getBasePrice() * 0.02d;
        }

        // return getBasePrice() < 5000 ? getBasePrice() * 0.05d : getBasePrice() * 0.02d;

    }

}
