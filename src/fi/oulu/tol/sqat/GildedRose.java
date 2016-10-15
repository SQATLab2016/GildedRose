package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private static final int MAX_QUALITY = 50;
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String CONCERT_TICKETS = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
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
			if (!SULFURAS.equals(item.getName()) && !item.hasZeroQuality()) {
				item.decreaseSellIn();

				if ((AGED_BRIE.equals(item.getName())) || CONCERT_TICKETS.equals(item.getName())) { //items increasing in quality after sell in

					if (!item.hasReachedMaxQuality()) {
						item.increaseQuality();
						if (CONCERT_TICKETS.equals(item.getName()) && !item.hasReachedMaxQuality()) {
							if (item.getSellIn() < 11) {
								item.increaseQuality();
							}
							if (item.getSellIn() < 6) {
								item.increaseQuality();
							}
						}
					}

				} else {
					item.decreaseQuality();
				}

				if (item.isExpired()) { //Check expiry
					if (CONCERT_TICKETS.equals(item.getName())) {
						item.setQuality(0);
					} else {
						item.decreaseQuality();
					}
				}
			}
		}

	}

}
