package com.gildedrose;

public class LegendaryItemUpdater extends BaseItemUpdater {
    @Override
    public void updateItem(Item item){
        item.quality = 80;
    }
}