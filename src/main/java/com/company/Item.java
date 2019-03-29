package com.company;

public class Item {
    private String name;
    private double price;

    public Item(String name, double price){
        this.name = name;
        if (price < 0 ) throw new IllegalArgumentException(String.format(("Wrong price :  " + price)));
        this.price = price;
    }
    public void setName(String name){
        this.price = price;
    }
    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
