package com.gildedrose;

import java.util.HashMap;
import java.util.Map;


class UpdaterFactory {

    private static final Map<String, UpdaterInterface> UPDATERS = new HashMap<>();
    static {
        UPDATERS.put("Aged Brie", new BrieUpdater());
        UPDATERS.put("Backstage passes to a TAFKAL80ETC concert", new PassesUpdater());
        UPDATERS.put("Sulfuras, Hand of Ragnaros", new LegendaryItemUpdater());
        UPDATERS.put("Conjured Mana Cake", new ConjuredItemUpdater());
        // UPDATERS.put("Backstage passes to a TAFKAL80ETC concert", new NormalItemUpdater());
        // UPDATERS.put("Sulfuras, Hand of Ragnaros", new NormalItemUpdater());
        // UPDATERS.put("Conjured Mana Cake", new NormalItemUpdater());
    }

    public static UpdaterInterface getUpdaterFor(Item item) {
        return UPDATERS.getOrDefault(item.name, new NormalItemUpdater());
    }
}