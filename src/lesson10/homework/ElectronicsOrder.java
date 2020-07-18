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
        String[] validCitiesForOrderFrom = {"Kiev", "Odessa", "Dnepr", "Kharkov"};

        for (String city : validCitiesForOrderFrom) {
            if (city.equals(getShipFromCity()) && getBasePrice() >= 100 && getCustomerOwned().getGender().toLowerCase().equals("female")) {
                setDateConfirmed(new Date());
            }
        }
    }

    @Override
    void calculatePrice() {
//        double totalPrice = getBasePrice() > 1000 ? getBasePrice() * 0.95d + calculateShippingPrice() : getBasePrice() + calculateShippingPrice();
//        setTotalPrice(totalPrice);

        if (getBasePrice() > 1000) {
            //5% discount
            setTotalPrice(getBasePrice() * 0.95d + calculateShippingPrice());
        } else {
            setTotalPrice(getBasePrice() + calculateShippingPrice());
        }
    }

    private double calculateShippingPrice() {
        String[] mediumShippingPriceCities = {"Kiev", "Odessa"};

        for (String city : mediumShippingPriceCities) {
            if (getShipToCity().toLowerCase().equals(city.toLowerCase())) {
                return getBasePrice() * 0.1;
            }
        }
        return getBasePrice() * 0.15;
    }

}

