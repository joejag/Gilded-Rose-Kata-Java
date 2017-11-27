package com.gildedrose.rules.quality;

import com.gildedrose.Item;
import com.gildedrose.rules.Rule;

import java.util.function.Predicate;

public class IncreasesWithinBoundsRule implements Rule {

    public static final int LOWEST_POSSIBLE_QUALITY = 0;
    public static final int HIGHEST_POSSIBLE_QUALITY = 50;

    private final int amountBy;
    private final Predicate<Item> given;

    public IncreasesWithinBoundsRule(int amountBy, Predicate<Item> given) {
        this.amountBy = amountBy;
        this.given = given.and(hasNotGoneBeyondLimits(amountBy));
    }

    private Predicate<Item> hasNotGoneBeyondLimits(int amountBy) {
        return item -> {
            int potentialQuality = item.quality + amountBy;
            return potentialQuality <= HIGHEST_POSSIBLE_QUALITY && potentialQuality >= LOWEST_POSSIBLE_QUALITY;
        };
    }

    public int by() {
        return amountBy;
    }

    public Predicate<Item> condition() {
        return given;
    }
}
