package com.gildedrose.rules.factory;

import com.gildedrose.Item;
import com.gildedrose.rules.DoNothingRule;
import com.gildedrose.rules.Rule;
import com.gildedrose.rules.stepin.AlwaysDecreasesRule;

import java.util.Map;

import static java.util.Map.entry;

public class SellInRulesFactory {

    public static Rule ruleFor(Item item) {
        return Map.<String, Rule>ofEntries(
                entry("Sulfuras, Hand of Ragnaros", new DoNothingRule()))
                .getOrDefault(item.name, new AlwaysDecreasesRule());
    }
}
