package com.gildedrose;

public class PassesUpdater extends BaseItemUpdater {

    @Override
    public void updateItem(Item item){
        if (item.sellIn <= 0) {
          item.quality = 0;
          updateSellIn(item, -1);
          return;
        }

        if (item.sellIn <=5) {
          updateQuality(item, 3);
        } else if (item.sellIn <= 10) {
          updateQuality(item, 2);
        } else {
          updateQuality(item, 1);
        }
        if (item.quality > 50) { item.quality = 50;}
        updateSellIn(item, -1);
    }
}