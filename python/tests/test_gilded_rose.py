# -*- coding: utf-8 -*-
import unittest

from gilded_rose import Item, GildedRose


class GildedRoseTest(unittest.TestCase):
    def test_once(self):
        items = [
            Item("Test", 10, 2),
            Item("Aged Brie", 10, 30),
            Item("Elixir of the Mongoose", 1, 15),
            Item("Sulfuras, Hand of Ragnaros", 100, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 3, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 4, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 6, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 1, 1),
            Item("Conjured Mana Cake", 3, 6)
        ]
        expected_sell_in = [9, 9, 0, 100, 14, 2, 3, 5, 0, 2]
        expected_quality = [1, 31, 14, 80, 21, 23, 23, 22, 4, 4]

        gilded_rose = GildedRose(items)
        gilded_rose.update_quality()
        for i, item in enumerate(items):
            print(item)
            self.assertEqual(item.sell_in, expected_sell_in[i])
            self.assertEqual(item.quality, expected_quality[i])
        
    def test_5_rounds(self):
        items = [
            Item("Test", 10, 2),
            Item("Aged Brie", 10, 30),
            Item("Elixir of the Mongoose", 1, 15),
            Item("Sulfuras, Hand of Ragnaros", 100, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 3, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 4, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 4, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 6, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 1, 1),
            Item("Conjured Mana Cake", 3, 6)
        ]
       
        expected_sell_in = [5, 5, -4, 100, 10, -2, -1, -1, 1, -4, -2]
        expected_quality = [0, 35, 6, 80, 25, 0, 0, 0, 34, 0, 0]

        gilded_rose = GildedRose(items)
        for _ in range(5):
            gilded_rose.update_quality()
        for i, item in enumerate(items):
            print(item)
            self.assertEqual(item.sell_in, expected_sell_in[i])
            self.assertEqual(item.quality, expected_quality[i])
        
    def test_10_rounds(self):
        items = [
            Item("Test", 10, 2),
            Item("Aged Brie", 10, 30),
            Item("Elixir of the Mongoose", 1, 15),
            Item("Sulfuras, Hand of Ragnaros", 100, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 3, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 4, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 6, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 1, 1),
            Item("Conjured Mana Cake", 3, 6)
        ]
        expected_sell_in = [0, 0, -9, 100, 5, -7, -6, -4, -9, -7]
        expected_quality = [0, 40, 0, 80, 35, 0, 0, 0, 0, 0]

        gilded_rose = GildedRose(items)
        for _ in range(10):
            gilded_rose.update_quality()
        for i, item in enumerate(items):
            print(item)
            self.assertEqual(item.sell_in, expected_sell_in[i])
            self.assertEqual(item.quality, expected_quality[i])
        
    def test_30_rounds(self):
        items = [
            Item("Test", 10, 2),
            Item("Aged Brie", 10, 30),
            Item("Elixir of the Mongoose", 1, 15),
            Item("Sulfuras, Hand of Ragnaros", 100, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 3, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 4, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 6, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 1, 1),
            Item("Conjured Mana Cake", 3, 6)
        ]
        expected_sell_in = [-20, -20, -29, 100, -15, -27, -26, -24, -29, -27]
        expected_quality = [0, 50, 0, 80, 0, 0, 0, 0, 0, 0]

        gilded_rose = GildedRose(items)
        for _ in range(30):
            gilded_rose.update_quality()
        for i, item in enumerate(items):
            print(item)
            self.assertEqual(item.sell_in, expected_sell_in[i])
            self.assertEqual(item.quality, expected_quality[i])
       
    def test_100_rounds(self):
        items = [
            Item("Test", 10, 2),
            Item("Aged Brie", 10, 30),
            Item("Elixir of the Mongoose", 1, 15),
            Item("Sulfuras, Hand of Ragnaros", 100, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 3, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 4, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 6, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 1, 1),
            Item("Conjured Mana Cake", 3, 6)
        ]
    
        expected_sell_in = [-90, -90, -99, 100, -85, -97, -96, -94, -99, -97]
        expected_quality = [0, 50, 0, 80, 0, 0, 0, 0, 0, 0]

        gilded_rose = GildedRose(items)
        for _ in range(100):
            gilded_rose.update_quality()
        for i, item in enumerate(items):
            print(item)
            self.assertEqual(item.sell_in, expected_sell_in[i])
            self.assertEqual(item.quality, expected_quality[i])

        
if __name__ == '__main__':
    unittest.main()
