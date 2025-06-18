package com.design.ecommerce;

public class TestObserverPattern {
    public static void main(String[] args) {
        Order order1 = new Order();

        OrderObserver priceObserver = new PriceObserver();
        OrderObserver quantityObserver = new QuantityObserver();

        order1.attach(priceObserver);
        order1.attach(quantityObserver);

        order1.addItem(50);
        System.out.println(order1);

        order1.addItem(50);
        System.out.println(order1);

        order1.addItem(50);
        System.out.println(order1);

        order1.addItem(50);
        System.out.println(order1);

        order1.addItem(50);
        System.out.println(order1);

        order1.addItem(50);
        System.out.println(order1);

        Order order2 = new Order();

        order2.attach(priceObserver);
        order2.attach(quantityObserver);

        order2.addItem(75);
        System.out.println(order2);

        order2.addItem(75);
        System.out.println(order2);

        order2.addItem(75);
        System.out.println(order2);

        System.out.println("\nTesting to detach quantity observer");
        order2.detach(quantityObserver);

        order2.addItem(1);
        order2.addItem(1);
        order2.addItem(1);
        System.out.println(order2);
        System.out.println("\nShipping cost is not $0 -> it worked.");
    }
}
