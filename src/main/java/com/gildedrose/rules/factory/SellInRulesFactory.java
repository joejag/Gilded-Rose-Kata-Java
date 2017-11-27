package com.gildedrose.rules.factory;

import com.gildedrose.Item;
import com.gildedrose.rules.stepin.AlwaysDecreasesRule;
import com.gildedrose.rules.DoNothingRule;
import com.gildedrose.rules.Rule;

public class SellInRulesFactory {

    public static Rule ruleFor(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) return new DoNothingRule();

        return new AlwaysDecreasesRule();
    }
}
