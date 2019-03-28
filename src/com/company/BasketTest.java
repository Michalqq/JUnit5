package com.company;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    @org.junit.jupiter.api.Test
    void addItem() {
        Item item = new Item("",0);
        Map<String, Integer> map1 = new HashMap<>();
        map1.put(item.getName(),1);
        Map<String, Double> map11 = new HashMap<>();
        map11.put(item.getName(),item.getPrice());
        Basket basket = new Basket(map1, map11);
        //assertTrue(basket);


    }
}