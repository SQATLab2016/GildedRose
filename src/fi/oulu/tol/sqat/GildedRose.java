package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;

	public GildedRose() {
		items = new ArrayList<Item>();
	}

	public static List<Item> getItems() {
		return items;
	}

	public void addItem(Item it){
		items.add(it);
	}
	public void updateEndOfDay(){
		updateQuality();
	}

	public static void updateQuality()
	{
		for (Item item: items)
		{
			if ((item.sameObject("Aged Brie")) || (item.sameObject("Backstage passes to a TAFKAL80ETC concert"))) 
			{
				if (item.hasNotReachedMaximumQuality())
				{
					item.increaseQuality();

					if (item.sameObject("Backstage passes to a TAFKAL80ETC concert"))
					{
						if (item.getSellIn() < 11)
						{
							if (item.hasNotReachedMaximumQuality())
							{
								item.increaseQuality();
							}
						}

						if (item.getSellIn() < 6)
						{
							if (item.hasNotReachedMaximumQuality())
							{
								item.increaseQuality();
							}
						}
					}
				}
			}
			else
			{
				if (item.hasQualityBiggerThanZero())
				{
					if (!item.sameObject("Sulfuras, Hand of Ragnaros"))
					{
						item.decreaseQuality();
					}
				}
			}

			if (!item.sameObject("Sulfuras, Hand of Ragnaros"))
			{
				item.decreaseSellIn();
			}

			if (item.isExpired())
			{
				if (item.sameObject("Aged Brie"))
				{
					if (item.hasNotReachedMaximumQuality())
					{
						item.increaseQuality();
					}
				}
				else
				{
					if (item.sameObject("Backstage passes to a TAFKAL80ETC concert"))
					{
						item.setQuality(item.getQuality() - item.getQuality());
					}
					else
					{
						if (item.hasQualityBiggerThanZero())
						{
							if (!item.sameObject("Sulfuras, Hand of Ragnaros"))
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
