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
    public static void updateEndOfDay()
    {
        for (Item item : items)
        {
        	String itemName = item.getName();
        	int itemSellIn = item.getSellIn();
        	int itemQuality = item.getQuality();
        	
        	
            if ((!"Aged Brie".equals(itemName)) && !"Backstage passes to a TAFKAL80ETC concert".equals(itemName)) 
            {
                if (itemQuality > 0)
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(itemName))
                    {
                        item.decreaseQuality();
                    }
                }
            }
            else
            {
                if (itemQuality < 50)
                {
                    item.increaseQuality();

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(itemName))
                    {
                        if (itemSellIn < 11)
                        {
                            if (itemQuality < 50)
                            {
                            	item.increaseQuality();
                            }
                        }

                        if (itemSellIn < 6)
                        {
                            if (itemQuality < 50)
                            {
                            	item.increaseQuality();
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(itemName))
            {
                item.decreaseSellIn();
            }

            if (item.getSellIn() < 0)
            {
                if (!"Aged Brie".equals(itemName))
                {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(itemName))
                    {
                        if (itemQuality > 0)
                        {
                            if (!"Sulfuras, Hand of Ragnaros".equals(itemName))
                            {
                            	item.decreaseQuality();
                            }
                        }
                    }
                    else
                    {
                        item.setQuality(0);
                    }
                }
                else
                {
                    if (itemQuality < 50)
                    {
                        item.increaseQuality();
                    }
                }
            }
        }
    }
}
