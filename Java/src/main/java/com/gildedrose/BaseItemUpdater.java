package com.gildedrose;

public abstract class BaseItemUpdater implements UpdaterInterface {

    public abstract void updateItem(Item item);

    protected void updateSellIn(Item item, int amt) {
        item.sellIn = item.sellIn + amt;
    }

    protected void updateQuality(Item item, int amt) {
        item.quality = item.quality + amt;
    }
}