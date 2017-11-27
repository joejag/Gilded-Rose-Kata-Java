package com.gildedrose.rules.factory;

import com.gildedrose.Item;
import com.gildedrose.rules.DoNothingRule;
import com.gildedrose.rules.quality.IncreasesWithinBoundsRule;
import com.gildedrose.rules.Rule;
import com.gildedrose.rules.quality.ZeroQualityRule;

import java.util.List;

import static java.util.Arrays.asList;

public class QualityRulesFactory {

    public static Rule ruleFor(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) return backstageTicketRules(item);
        if (item.name.equals("Aged Brie")) return agedBrieRules(item);
        if (item.name.equals("Conjured Mana Cake")) return conjuredRules(item);

        return itemThatDecreasesInQuality(item);
    }

    private static Rule conjuredRules(Item item) {
        return findApplicableRule(item, asList(
                new IncreasesWithinBoundsRule(-4, (i) -> i.sellIn < 0),
                new IncreasesWithinBoundsRule(-2, (i) -> true)));
    }

    private static Rule backstageTicketRules(Item item) {
        return findApplicableRule(item, asList(
                new ZeroQualityRule(item.quality, (i) -> i.sellIn < 0),
                new IncreasesWithinBoundsRule(3, (i) -> i.sellIn < 5),
                new IncreasesWithinBoundsRule(2, (i) -> i.sellIn < 10),
                new IncreasesWithinBoundsRule(1, (i) -> true)));
    }

    private static Rule agedBrieRules(Item item) {
        return findApplicableRule(item, asList(
                new IncreasesWithinBoundsRule(2, (i) -> i.sellIn < 0),
                new IncreasesWithinBoundsRule(1, (i) -> true)));
    }

    private static Rule itemThatDecreasesInQuality(Item item) {
        return findApplicableRule(item, asList(
                new IncreasesWithinBoundsRule(-2, (i) -> i.sellIn < 0),
                new IncreasesWithinBoundsRule(-1, (i) -> true)));
    }

    private static Rule findApplicableRule(Item item, List<Rule> rules) {
        return rules.stream()
                .filter((r) -> r.appliesFor(item))
                .findFirst().orElse(new DoNothingRule());
    }
}
