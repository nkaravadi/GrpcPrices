package org.demo.cop.priceservice;

import java.util.Random;

public class PriceGenerator {
    private final Random r = new Random();
    public Double getPrice(String ticker) {
        double price = (Character.getNumericValue(ticker.charAt(0))) * 100 + r.nextDouble() * 10;
        price = Math.round(price *100)/100.0;
        return price;
    }
}
