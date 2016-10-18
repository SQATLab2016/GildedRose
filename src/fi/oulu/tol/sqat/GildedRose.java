package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private static List<Item> items = null;

	public List<Item> getItems() {
		return items;
	}
	public void addItem(Item item) {
		items.add(item);
	}
	public GildedRose() {
		items = new ArrayList<Item>();
	}

	public static void updateEndOfDay() {
		for (Item item : items) {
			if ((!"Aged Brie".equals(item.getName()))
					&& !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
				if (!item.hasZeroQuality()) {
					if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
						item.decreaseQuality();
					}
				}
			} else {
				if (!item.hasReachedMaximumQuality()) {
					item.increaseQuality();

					if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
						if (item.getSellIn() < 11) {
							if (!item.hasReachedMaximumQuality()) {
								item.increaseQuality();
							}
						}

						if (item.getSellIn() < 6) {
							if (!item.hasReachedMaximumQuality()) {
								item.increaseQuality();
							}
						}
					}
				}
			}

			if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
				item.decreaseSellIn();
			}

			if (item.isExpired()) {
				if ("Aged Brie".equals(item.getName())) {

					if (!item.hasReachedMaximumQuality()) {
						item.increaseQuality();
					}
				} else {

					if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
						item.setQuality(0);
					} else {
						if (!item.hasZeroQuality()) {
							if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
								item.decreaseQuality();
							}
						}

					}

				}
			}
		}
	}

}
