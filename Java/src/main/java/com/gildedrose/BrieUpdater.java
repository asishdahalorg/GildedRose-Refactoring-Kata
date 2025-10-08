package com.gildedrose;

public class BrieUpdater extends BaseItemUpdater {

    @Override
    public void updateItem(Item item){
        if (item.sellIn > 0) {
          updateQuality(item, 1);
        } else {
          updateQuality(item, 2);
        }
        if (item.quality > 50) { item.quality = 50;}
        updateSellIn(item, -1);
    }
}