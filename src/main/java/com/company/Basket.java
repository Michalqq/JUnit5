package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final Map<Item, Integer> order = new HashMap<Item, Integer>();

    public Map<Item, Integer> getOrderedItems() {
        return order;
    }


    public void addItem(Item item) {
        addItem(item, 1);
    }

    public void addItem(Item item, int quantity) {
        if (quantity > 0) {
            if (order.containsKey(item)) {
                quantity = order.get(item) + quantity;
            }
            order.put(item, quantity);
        } else {
            throw new IllegalArgumentException(String.format(("Błędna ilość do dodania - " + quantity)));
        }
    }

    public void removeItem(Item item) {
        removeItem(item, 1);
    }

    public void removeItem(Item item, int quantity) {
        if (quantity > 1) {
            quantity = order.get(item) - quantity;
            if (quantity == 0) {
                order.remove(item);
            } else if (quantity < 0) {
                throw new IllegalStateException(String.format("There is no that many items to remove~"));
            } else {
                order.put(item, quantity);
            }
        } else {
            throw new IllegalArgumentException(String.format("Błędna ilość do usunięcia - " + quantity));
        }
    }

    public void removeAllItems(List<Item> items) {
        for (Item item : items) {
            if (order.containsKey(item)) {
                order.remove(item);
            }
        }
    }


    public double getTotalValue() {
        double total = 0;
        for (Map.Entry<Item, Integer> entry : order.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "orderedItems=" + order +
                '}';
    }
}
