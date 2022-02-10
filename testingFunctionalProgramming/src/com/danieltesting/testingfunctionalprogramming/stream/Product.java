package com.danieltesting.testingfunctionalprogramming.stream;

public class Product {

    private int price;
    private String name;

    public Product(int amount, String name) {
        this.price =amount;
        this.name =name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    This class is used for an example of StreamReduction

}
