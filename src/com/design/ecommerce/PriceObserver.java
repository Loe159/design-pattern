package com.design.ecommerce;

public class PriceObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        if (order.getTotalPrice() > 200 && !order.isDiscountApplied()) {
            double discount = 20.0;
            System.out.println(">> Applied $" + discount + " discount.");
            order.applyDiscount(discount);
        }
    }
}
