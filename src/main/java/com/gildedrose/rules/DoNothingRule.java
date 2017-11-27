package com.gildedrose.rules;

import com.gildedrose.Item;

import java.util.function.Predicate;

public class DoNothingRule implements Rule {

    public int by() {
        return 0;
    }

    public Predicate<Item> condition() {
        return (item) -> true;
    }
}
