# -*- coding: utf-8 -*-

from registry import register_update_function

def decrease_sell_in(sell_in, amount=1):
    return sell_in - amount

def decrease_quality(quality, amount=1):
    return max(0, quality - amount)

def increase_quality(quality, amount=1):
    return min(50, quality + amount)

def update_default(item: object) -> None:
    if item.sell_in > 0:
        item.quality = decrease_quality(item.quality, 1)
    else:
        item.quality = decrease_quality(item.quality, 2)
    
    item.sell_in = decrease_sell_in(item.sell_in, 1)

@register_update_function(["Aged Brie"])
def update_brie(item: object) -> None:
    if item.sell_in > 0:
        item.quality = increase_quality(item.quality, 1)
    else:
        item.quality = increase_quality(item.quality, 2)
    
    item.sell_in = decrease_sell_in(item.sell_in, 1)

@register_update_function(["Backstage passes to a TAFKAL80ETC concert"])
def update_passes(item: object) -> None:
    if item.sell_in <= 0:
        item.quality = 0
    elif item.sell_in <= 5:
        item.quality = increase_quality(item.quality, 3)
    elif item.sell_in <= 10:
        item.quality = increase_quality(item.quality, 2)
    else:
        item.quality = increase_quality(item.quality, 1)
    
    item.sell_in = decrease_sell_in(item.sell_in, 1)

@register_update_function(["Sulfuras, Hand of Ragnaros"])
def update_legendary_items(item: object) -> None:
    item.quality = 80

@register_update_function(["Conjured Mana Cake"])
def update_conjured(item: object) -> None:
    if item.sell_in > 0:
        item.quality = decrease_quality(item.quality, 2)
    else:
        item.quality = decrease_quality(item.quality, 4)
    
    item.sell_in = decrease_sell_in(item.sell_in, 1)