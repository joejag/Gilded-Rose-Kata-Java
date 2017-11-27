package com.gildedrose.items;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.Test;

import static com.gildedrose.ItemTestHelper.assertItemEquals;

public class ConjuredItemTestHelper {

    @Test
    public void item_conjured_decreasesInQuality_twiceTheSpeed() {
        GildedRose app = new GildedRose(new Item("Conjured Mana Cake", 3, 6));

        app.updateQuality();

        assertItemEquals(app.getItems()[0], new Item("Conjured Mana Cake", 2, 4));
    }

    @Test
    public void item_conjured_decreasesInQuality_twiceTheSpeed_alsoWhenSellInExpired() {
        GildedRose app = new GildedRose(new Item("Conjured Mana Cake", 0, 6));

        app.updateQuality();

        assertItemEquals(app.getItems()[0], new Item("Conjured Mana Cake", -1, 2));
    }
}
