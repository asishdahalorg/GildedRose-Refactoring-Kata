package com.gildedrose;

public class NormalItemUpdater extends BaseItemUpdater {

    @Override
    public void updateItem(Item item){
        if (item.sellIn > 0) {
          updateQuality(item, -1);
        } else {
          updateQuality(item, -2);
        }
        if (item.quality < 0) { item.quality = 0;}
        updateSellIn(item, -1);
    }

}