package lesson10.homework;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFormCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFormCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    void validateOrder() {
        String[] validCitiesForOrderFrom = {"Киев", "Одесса", "Днепр", "Харьков"};

        for (String city : validCitiesForOrderFrom) {
            if (city == getShipFromCity() && getBasePrice() >= 100 && getCustomerOwned().getGender() == "Женский") {
                setDateConfirmed(new Date());
            }
        }
    }

    @Override
    void calculatePrice() {
        double totalPrice = getBasePrice() + calculateShippingPrice();
        if (getBasePrice() > 1000) {
            setTotalPrice(totalPrice * 0.95d);
        } else {
            setTotalPrice(totalPrice);
        }
    }

    private double calculateShippingPrice() {
        String[] mediumShippingPriceCities = {"Киев", "Одесса"};

        for (String city : mediumShippingPriceCities) {
            if (getShipToCity() == city) {
                return getBasePrice() * 0.1;
            }
        }
        return getBasePrice() * 0.15;
    }

}

