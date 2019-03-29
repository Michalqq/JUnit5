import com.company.Basket;
import com.company.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasketTest {

    Basket basket = new Basket();

    @Test
    public void addAndRemoveItems() {
        Item item = new Item("computer", 150);
        assertEquals(0, basket.getTotalValue());
        basket.addItem(item,20);
        assertEquals(3000, basket.getTotalValue());
        List<Item> items = new ArrayList<Item>(Arrays.asList(item));
        basket.removeAllItems(items);
        assertEquals(0, basket.getTotalValue());
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldTrowExceptionWhenRemovingNegativeQuantity() {
        Item item = new Item("computer",20);
        basket.removeItem(item, -10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldTrowExceptionWhenAddingNegativeQuantity() {
        Item item = new Item("computer",20);
        basket.addItem(item, -1);
    }
}
