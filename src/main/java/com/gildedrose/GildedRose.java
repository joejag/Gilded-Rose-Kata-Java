package com.gildedrose;

import com.gildedrose.rules.factory.QualityRulesFactory;
import com.gildedrose.rules.Rule;
import com.gildedrose.rules.factory.SellInRulesFactory;

public class GildedRose {

    private Item[] items;

    public GildedRose(Item... items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            Rule sellInRule = SellInRulesFactory.ruleFor(item);
            item.sellIn -= sellInRule.by();

            Rule qualityRule = QualityRulesFactory.ruleFor(item);
            item.quality += qualityRule.by();
        }
    }

    public Item[] getItems() {
        return items;
    }
}