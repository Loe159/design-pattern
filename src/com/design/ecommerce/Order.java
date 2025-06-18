package com.design.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int uniqueId = 1;
    private int id;
    private Boolean discountApplied = false;
    private double totalPrice;
    private int count;
    private double shippingCost = 10.0;
    private List<OrderObserver> observers = new ArrayList<>();

    public Order() {
        this.id = uniqueId++;
    }

    public void attach(OrderObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getCount() {
        return count;
    }

    public void addItem(double price) {
        totalPrice += price;
        count++;
        notifyObservers();
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public void applyDiscount(double discount) {
        totalPrice -= discount;
        discountApplied = true;
    }

    public Boolean isDiscountApplied() {
        return discountApplied;
    }

    @Override
    public String toString() {
        return String.format(
                "(#%s) -> Number of items: %d, Order price: $%.2f, Shipping cost: $%.2f, Total : $%.2f",
                id, count, totalPrice, shippingCost, totalPrice + shippingCost
        );
    }
}
