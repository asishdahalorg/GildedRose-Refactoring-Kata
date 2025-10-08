package com.gildedrose;

public class ConjuredItemUpdater extends BaseItemUpdater {

    @Override
    public void updateItem(Item item){
        if (item.sellIn > 0) {
          updateQuality(item, -2);
        } else {
          updateQuality(item, -4);
        }
        if (item.quality < 0) { item.quality = 0;}
        updateSellIn(item, -1);
    }
}