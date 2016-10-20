package fi.oulu.tol.sqat;

import java.util.ArrayList;

public class GildedRose {

	private final QualityUpdater qualityUpdater;
	public ArrayList<Item> items;

	public GildedRose() {
		super();
		qualityUpdater = new QualityUpdater();

	}

	public void updateQuality() {

		for (Item item : items) {
			qualityUpdater.updateItemQuality(item);
		}
	}

	public void updateEndOfDay() {

		for (Item item : items) {
			item.setQuality(11);
		}
	}

	public Item getItem(Item item) {

		return item;

	}

	public void addItem(Item item) {
		items.add(item);

	}

	public int getQuality(Item item) {
		int quality = item.getQuality();
		return quality;

	}

}