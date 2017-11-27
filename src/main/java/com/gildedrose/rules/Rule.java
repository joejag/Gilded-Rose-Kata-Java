package com.gildedrose.rules;

import com.gildedrose.Item;

import java.util.function.Predicate;

public interface Rule {

    int by();

    Predicate<Item> condition();

    default boolean appliesFor(Item item) {
        return condition().test(item);
    }
}
