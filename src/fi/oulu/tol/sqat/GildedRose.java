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
	public static void decreaseQuality(Item i){
		i.setQuality(i.getQuality()-1);
	}
	public static void increaseQuality(Item i){
		i.setQuality(i.getQuality()+1);
	}
	public static void decreaseSellIn(Item i){
		i.setSellIn(i.getSellIn()-1);
	}
	public static boolean sellInLessThan11(Item i){

		if(i.getSellIn() < 11){
			return true;
		}
		return false;
	}
	public static boolean sellInLessThan6(Item i){
		if(i.getSellIn() < 6){
			return true;
		}
		return false;
	}
	public static boolean hasReachedMaximumQuality(Item i){
		if(i.getQuality() < 50){
			return true;
		}
		return false;
	}
	public static boolean hasZeroQuality(Item i){

		if(i.getQuality() == 0){
			return false;
		}
		return true;
	}
	public static boolean hasLessZeroSellIn(Item i){

		if(i.getSellIn() < 0){
			return true;
		}
		return false;
	}
	public static boolean isNotEqual(String name, Item i){
		if(!name.equals(i.getName())){
			return true;
		}
		return false;

	}
	public static boolean isEqual(String name, Item i){
		if(name.equals(i.getName())){
			return true;
		}
		return false;

	}
	public static void setQuality(Item i){
		i.setQuality(i.getQuality() - i.getQuality());
	}
	public static void updateEndOfDay()
	{
		for (Item item:items)
		{
			if (isNotEqual("Aged Brie", item) && isNotEqual("Backstage passes to a TAFKAL80ETC concert", item)) 
			{
				if (hasZeroQuality(item))
				{
					if (isNotEqual("Sulfuras, Hand of Ragnaros", item))
					{
						decreaseQuality(item);
					}
				}
			}
			else
			{
				if (hasReachedMaximumQuality(item))
				{
					increaseQuality(item);
					if (isEqual("Backstage passes to a TAFKAL80ETC concert", item))
					{
						if (sellInLessThan11(item))
						{
							if (hasReachedMaximumQuality(item))
							{
								increaseQuality(item);
							}
						}

						if (sellInLessThan6(item))
						{
							if (hasReachedMaximumQuality(item))
							{
								increaseQuality(item);
							}
						}
					}
				}
			}

			if (isNotEqual("Sulfuras, Hand of Ragnaros", item))
			{
				decreaseSellIn(item);
			}

			if (hasLessZeroSellIn(item))
			{
				if (isNotEqual("Aged Brie", item))
				{
					if (isNotEqual("Backstage passes to a TAFKAL80ETC concert", item))
					{
						if (hasZeroQuality(item))
						{
							if (isNotEqual("Sulfuras, Hand of Ragnaros", item))
							{
								decreaseQuality(item);
							}
						}
					}
					else
					{
						setQuality(item);

					}
				}
				else
				{
					if (hasReachedMaximumQuality(item)){
						increaseQuality(item);
					}
				}
			}
		}
	}

}
