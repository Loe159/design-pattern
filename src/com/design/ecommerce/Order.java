package com.design.ecommerce;

public class Order {
    protected double totalPrice;
    protected int count;


    public void attach(OrderObserver observer) {}
    public void detach(OrderObserver observer) {}
    protected double getTotalPrice() {return 0;}
    protected int getCount() {return 0;}

    @Override
    public String toString() {
        return super.toString();
    }

    public void addItem(double price) {}
}
