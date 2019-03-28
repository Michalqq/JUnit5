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
        Map<String, Integer> map1 = new HashMap<>();
        map1.put(item1.getName(),1);
        Map<String, Double> map11 = new HashMap<>();
        map11.put(item1.getName(),item1.getPrice());
        Basket basket = new Basket(map1, map11);
        basket.addItem(item1);
        basket.addItem(item1);
        basket.addItem(item1);
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        System.out.println(basket);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        System.out.println(basket);
        System.out.println(basket.getTotalValue());
    }
}
