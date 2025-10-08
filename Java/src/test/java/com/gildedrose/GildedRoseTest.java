package com.gildedrose;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQualityOnce() {
        Item[] items = new Item[] { new Item("Test", 10, 2),
            new Item("Aged Brie", 10, 30),
            new Item("Elixir of the Mongoose", 1, 15), new Item("Sulfuras, Hand of Ragnaros", 100, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1),
            // new Item("Conjured Mana Cake", 3, 6) 
        };
        
        // Expected:
        // Test, 9, 1
        // Aged Brie, 9, 31
        // Elixir of the Mongoose, 0, 14
        // Sulfuras, Hand of Ragnaros, 100, 80
        // Backstage passes to a TAFKAL80ETC concert, 14, 21
        // Backstage passes to a TAFKAL80ETC concert, 2, 23
        // Backstage passes to a TAFKAL80ETC concert, 3, 23
        // Backstage passes to a TAFKAL80ETC concert, 5, 22
        // Backstage passes to a TAFKAL80ETC concert, 0, 4
        // Conjured Mana Cake, 2, 4
        List<Integer> expectedSellIn = List.of(9, 9, 0, 100, 14, 2, 3, 5, 0, 2);
        List<Integer> expectedQuality = List.of(1, 31, 14, 80, 21, 23, 23, 22, 4, 4);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        int j = 0;
        for (Item item : app.items) {
            System.out.println(item.toString());
            assertEquals(item.name, items[j].name);
            assertEquals(item.sellIn, expectedSellIn.get(j));
            assertEquals(item.quality, expectedQuality.get(j));
            j++;
        }
    }
    @Test
    void updateQualityFiveTimes() {
        Item[] items = new Item[] { 
            new Item("Test", 10, 2),
            new Item("Aged Brie", 10, 30),
            new Item("Elixir of the Mongoose", 1, 15), new Item("Sulfuras, Hand of Ragnaros", 100, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1),
            new Item("Conjured Mana Cake", 3, 6) 
        };
        
        // Test, 5, 0
        // Aged Brie, 5, 35
        // Elixir of the Mongoose, -4, 6
        // Sulfuras, Hand of Ragnaros, 100, 80
        // Backstage passes to a TAFKAL80ETC concert, 10, 25
        // Backstage passes to a TAFKAL80ETC concert, -2, 0
        // Backstage passes to a TAFKAL80ETC concert, -1, 0
        // Backstage passes to a TAFKAL80ETC concert, 1, 34
        // Backstage passes to a TAFKAL80ETC concert, -4, 0
        // Conjured Mana Cake, -2, 0
        List<Integer> expectedSellIn = List.of(5, 5, -4, 100, 10, -2, -1, 1, -4, -2);
        List<Integer> expectedQuality = List.of(0, 35, 6, 80, 25, 0, 0, 34, 0, 0);
        GildedRose app = new GildedRose(items);
        for (int i=0; i<5; i++) {
            app.updateQuality();;
        }
        int j = 0;
        for (Item item : app.items) {
            System.out.println(item.toString());
            assertEquals(item.name, items[j].name);
            assertEquals(item.sellIn, expectedSellIn.get(j));
            assertEquals(item.quality, expectedQuality.get(j));
            j++;
        }
    }
    @Test
    void updateQualityTenTimes() {
        Item[] items = new Item[] { new Item("Test", 10, 2),
            new Item("Aged Brie", 10, 30),
            new Item("Elixir of the Mongoose", 1, 15), new Item("Sulfuras, Hand of Ragnaros", 100, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1),
            new Item("Conjured Mana Cake", 3, 6) };
        
        // Test, 0, 0
        // Aged Brie, 0, 40
        // Elixir of the Mongoose, -9, 0
        // Sulfuras, Hand of Ragnaros, 100, 80
        // Backstage passes to a TAFKAL80ETC concert, 5, 35
        // Backstage passes to a TAFKAL80ETC concert, -7, 0
        // Backstage passes to a TAFKAL80ETC concert, -6, 0
        // Backstage passes to a TAFKAL80ETC concert, -4, 0
        // Backstage passes to a TAFKAL80ETC concert, -9, 0
        // Conjured Mana Cake, -7, 0
        List<Integer> expectedSellIn = List.of(0, 0, -9, 100, 5, -7, -6, -4, -9, -7);
        List<Integer> expectedQuality = List.of(0, 40, 0, 80, 35, 0, 0, 0, 0, 0);
        GildedRose app = new GildedRose(items);
        for (int i=0; i<10; i++) {
            app.updateQuality();;
        }
        int j = 0;
        for (Item item : app.items) {
            System.out.println(item.toString());
            assertEquals(item.name, items[j].name);
            assertEquals(item.sellIn, expectedSellIn.get(j));
            assertEquals(item.quality, expectedQuality.get(j));
            j++;
        }
    }
    @Test
    void updateQualityThirtyTimes() {
        Item[] items = new Item[] { new Item("Test", 10, 2),
            new Item("Aged Brie", 10, 30),
            new Item("Elixir of the Mongoose", 1, 15), new Item("Sulfuras, Hand of Ragnaros", 100, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1),
            new Item("Conjured Mana Cake", 3, 6) };
        
        // Test, -20, 0
        // Aged Brie, -20, 50
        // Elixir of the Mongoose, -29, 0
        // Sulfuras, Hand of Ragnaros, 100, 80
        // Backstage passes to a TAFKAL80ETC concert, -15, 0
        // Backstage passes to a TAFKAL80ETC concert, -27, 0
        // Backstage passes to a TAFKAL80ETC concert, -26, 0
        // Backstage passes to a TAFKAL80ETC concert, -24, 0
        // Backstage passes to a TAFKAL80ETC concert, -29, 0
        // Conjured Mana Cake, -27, 0
        List<Integer> expectedSellIn = List.of(-20, -20, -29, 100, -15, -27, -26, -24, -29, -27);
        List<Integer> expectedQuality = List.of(0, 50, 0, 80, 0, 0, 0, 0, 0, 0);
        GildedRose app = new GildedRose(items);
        for (int i=0; i<30; i++) {
            app.updateQuality();;
        }
        int j = 0;
        for (Item item : app.items) {
            System.out.println(item.toString());
            assertEquals(item.name, items[j].name);
            assertEquals(item.sellIn, expectedSellIn.get(j));
            assertEquals(item.quality, expectedQuality.get(j));
            j++;
        }
    }
    @Test
    void updateQuality100Times() {
        Item[] items = new Item[] { new Item("Test", 10, 2),
            new Item("Aged Brie", 10, 30),
            new Item("Elixir of the Mongoose", 1, 15), new Item("Sulfuras, Hand of Ragnaros", 100, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1),
            new Item("Conjured Mana Cake", 3, 6) };
        // Test, -90, 0
        // Aged Brie, -90, 50
        // Elixir of the Mongoose, -99, 0
        // Sulfuras, Hand of Ragnaros, 100, 80
        // Backstage passes to a TAFKAL80ETC concert, -85, 0
        // Backstage passes to a TAFKAL80ETC concert, -97, 0
        // Backstage passes to a TAFKAL80ETC concert, -96, 0
        // Backstage passes to a TAFKAL80ETC concert, -94, 0
        // Backstage passes to a TAFKAL80ETC concert, -99, 0
        // Conjured Mana Cake, -97, 0
        List<Integer> expectedSellIn = List.of(-90, -90, -99, 100, -85, -97, -96, -94, -99, -97);
        List<Integer> expectedQuality = List.of(0, 50, 0, 80, 0, 0, 0, 0, 0, 0);
        GildedRose app = new GildedRose(items);
        for (int i=0; i<100; i++) {
            app.updateQuality();;
        }
        int j = 0;
        for (Item item : app.items) {
            System.out.println(item.toString());
            assertEquals(item.name, items[j].name);
            assertEquals(item.sellIn, expectedSellIn.get(j));
            assertEquals(item.quality, expectedQuality.get(j));
            j++;
        }
    }

}
