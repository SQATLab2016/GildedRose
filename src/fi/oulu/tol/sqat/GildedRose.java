package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	private static final int SELL_IN_VALUE_6 = 6;
	private static final int SELL_IN_VALUE_11 = 11;
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
			if (!SULFURAS_HAND_OF_RAGNAROS.equals(item.getName())) {
				item = changeQuality(item);
				item.decreaseSellIn();
				if (item.isExpired()) {
					item = changeQuality(item);
				}
			}
		}
	}

	private static Item changeQuality(Item item) {
		if (AGED_BRIE.equals(item.getName())) {
			item.increaseQuality();
		} else if (BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(item
				.getName())) {
			if (item.isExpired()) {
				item.setQuality(item.getQuality() - item.getQuality());
			} else {
				item.increaseQuality();
				if (item.getSellIn() < SELL_IN_VALUE_11) {
					item.increaseQuality();
				}
				if (item.getSellIn() < SELL_IN_VALUE_6) {
					item.increaseQuality();
				}
			}
		} else {
			item.decreaseQuality();
		}
		return item;
	}

}
