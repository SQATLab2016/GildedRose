package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
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

	public static void updateEndOfDay()
	{
		for (Item item : items)
		{
			String itemName = item.getName();
			
			if (AGED_BRIE.equals(itemName) || BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(itemName))
			{
				if (!item.hasReachedMaximumQuality())
				{
					item.increaseQuality();

					if (BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(itemName))
					{
						int itemSellIn = item.getSellIn();
						
						if (itemSellIn < 11)
						{
							if (!item.hasReachedMaximumQuality())
							{
								item.increaseQuality();
							}
						}

						if (itemSellIn < 6)
						{
							if (!item.hasReachedMaximumQuality())
							{
								item.increaseQuality();
							}
						}
					}
				}
			}
			else
			{
				if (!item.hasReachedMaximumQuality())
				{
					if (!SULFURAS_HAND_OF_RAGNAROS.equals(itemName))
					{
						item.decreaseQuality();
					}
				}
			}

			if (!SULFURAS_HAND_OF_RAGNAROS.equals(itemName))
			{
				item.decreaseSellIn();
			}

			if (item.isExpired())
			{
				if (AGED_BRIE.equals(itemName))
				{
					if (!item.hasReachedMaximumQuality())
					{
						item.increaseQuality();
					}
				}
				else
				{
					if (BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(itemName))
					{
						item.setQuality(0);
					}
					else
					{
						if (!item.hasZeroQuality())
						{
							if (!SULFURAS_HAND_OF_RAGNAROS.equals(itemName))
							{
								item.decreaseQuality();
							}
						}
					}
				}
			}
		}
	}
}
