package com.design.ecommerce;

public class QuantityObserver implements OrderObserver{
    @Override
    public void update(Order order) {
        if (order.getCount() > 5) {
            order.setShippingCost(0.0);
            System.out.println(">> Free shipping");
        } else {
            order.setShippingCost(10.0);
        }
    }
}
