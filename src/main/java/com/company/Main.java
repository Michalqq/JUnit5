package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Item item1 = new Item("paluszki", 125);
        Item item2 = new Item("chrupki", 250);
        Item item3 = new Item("napój", 500);
        Basket basket = new Basket();
        //basket.addItem(item1,10);
        basket.addItem(item1);
        basket.addItem(item1);
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        System.out.println(basket.toString());
        List<Item> items = new ArrayList<Item>();
        items.add(item1);
        items.add(item2);
        System.out.println(basket.getTotalValue());
    }
}
