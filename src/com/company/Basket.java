package com.company;

import java.util.List;
import java.util.Map;

public class Basket {
    private Map<String, Integer> orderedItems;
    private Map<String, Double> orderedPrices;

    public Basket(Map<String, Integer> orderedItems,Map<String, Double> orderedPrices ) {
        this.orderedItems = orderedItems;
        this.orderedPrices = orderedPrices;
    }

    public Map<String, Double> getOrderedPrices() {
        return orderedPrices;
    }

    public void setOrderedPrices(Map<String, Double> orderedPrices) {
        this.orderedPrices = orderedPrices;
    }

    public Map<String, Integer> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(Map<String, Integer> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public void addItem(Item item) {
        if (orderedItems.containsKey(item.getName())) {
            orderedItems.put(item.getName(), orderedItems.get(item.getName()) + 1);
        } else {
            orderedItems.put(item.getName(), 1);
            orderedPrices.put(item.getName(), item.getPrice());
        }
    }

    public void addItem(Item item, int quantity) {
        if (quantity > 0) {
            if (orderedItems.containsKey(item.getName())) {
                orderedItems.put(item.getName(), orderedItems.get(item.getName()) + quantity);
            } else {
                orderedItems.put(item.getName(), quantity);
                orderedPrices.put(item.getName(), item.getPrice());
            }
        } else {
            System.out.println("Błędna ilość do dodania - " + quantity);
        }
    }

    public void removeItem(Item item) {
        if (orderedItems.containsKey(item.getName())) {
            orderedItems.put(item.getName(), orderedItems.get(item.getName()) - 1);
            checkQuantity();
        } else {
            System.out.println("Brak przedmiotu - " + item.getName() + " w koszyku");
        }
    }

    public void removeItem(Item item, int quantity) {
        if (quantity > 1) {
            if (orderedItems.containsKey(item.getName())) {
                orderedItems.put(item.getName(), orderedItems.get(item.getName()) - quantity);
                checkQuantity();
            } else {
                System.out.println("Brak przedmiotu - " + item.getName() + " w koszyku");
            }
        } else {
            System.out.println("Błędna ilość do usunięcia - " + quantity);
        }
    }

    public void removeAllItems(List<Item> items) {
        for (Item name : items) {
            if (orderedItems.containsKey(name.getName())) {
                orderedItems.remove(name.getName());
                orderedPrices.remove(name.getName());
            }
        }
    }

    public void checkQuantity() {
        for (Map.Entry<String, Integer> entry : orderedItems.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value < 1) {
                orderedItems.remove(key, value);
                orderedPrices.remove(key);
            }
        }
    }

    public int getTotalValue() {
        int total = 0;
        for (Map.Entry<String, Integer> entry : orderedItems.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            total += (orderedPrices.get(key) * value);
        }
        return total;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "orderedItems=" + orderedItems +
                '}';
    }
}
