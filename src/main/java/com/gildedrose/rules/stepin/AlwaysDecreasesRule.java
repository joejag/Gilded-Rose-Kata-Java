package com.gildedrose.rules.stepin;

import com.gildedrose.Item;
import com.gildedrose.rules.Rule;

import java.util.function.Predicate;

public class AlwaysDecreasesRule implements Rule {

    public int by() {
        return 1;
    }

    public Predicate<Item> condition() {
        return (item) -> true;
    }
}
