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
//        String[] validCitiesForOrder = {"Киев", "Одесса", "Днепр", "Харьков"};
//
//        boolean isFromCityValid = false;
//        boolean isToCityValid = false;
//
//        for (String city : validCitiesForOrder) {
//            if (city == getShipFromCity()) {
//                isFromCityValid = true;
//            }
//            if (city == getShipToCity()) {
//                isToCityValid = true;
//            }
//        }
//
//        if (isFromCityValid && isToCityValid && getBasePrice() >= 100 && getCustomerOwned().getGender() == "Женский") {
//            setDateConfirmed(new Date());
//        }

        if (validateCity(getShipToCity()) && validateCity(getShipFromCity()) && getBasePrice() >= 100 && getCustomerOwned().getGender() == "Женский") {
            setDateConfirmed(new Date());
        }
    }

    private boolean validateCity(String cityToValidate) {
        String[] validCitiesForOrder = {"Киев", "Одесса", "Днепр", "Харьков"};
        for (String city : validCitiesForOrder) {
            if (city == cityToValidate) {
                return true;
            }
        }
        return false;
    }

    @Override
    void calculatePrice() {
        double totalPrice = getBasePrice() + calculateShippingPrice();

        if (getTotalPrice() > 1000) {
            //5% discount
            double discountedTotalPrice = totalPrice * 0.95d;
            setTotalPrice(discountedTotalPrice);
        } else {
            setTotalPrice(totalPrice);
        }
    }

    private double calculateShippingPrice() {
        String[] mediumShippingPriceCities = {"Киев", "Одесса"};

        for (String city : mediumShippingPriceCities) {
            if (getShipToCity() == city) {
                return getBasePrice() * 0.1d;
            }
        }
        return getBasePrice() * 0.15d;
    }

}

