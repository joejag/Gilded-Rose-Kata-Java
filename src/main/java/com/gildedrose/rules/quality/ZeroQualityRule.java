package com.gildedrose.rules.quality;

import com.gildedrose.Item;
import com.gildedrose.rules.Rule;

import java.util.function.Predicate;

public class ZeroQualityRule implements Rule {

    private final int currentQuality;
    private final Predicate<Item> given;

    public ZeroQualityRule(int currentQuality, Predicate<Item> given) {
        this.currentQuality = currentQuality;
        this.given = given;
    }

    public int by() {
        return currentQuality * -1;
    }

    public Predicate<Item> condition() {
        return given;
    }
}
