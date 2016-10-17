package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
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
        for (Item item:items)
        {
			if ((AGED_BRIE.equals(item.getName())) || BACKSTAGE_PASS.equals(item.getName())) 
			{
                if (!item.hasReachedMaximumQuality())
                {
                    item.increaseQuality();

                    if (BACKSTAGE_PASS.equals(item.getName()))
                    {
                        if (item.getSellIn() < 11)
                        {
                            if (!item.hasReachedMaximumQuality())
                            {
                                item.increaseQuality();
                            }
                        }

                        if (item.getSellIn() < 6)
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
                    if (!SULFURAS.equals(item.getName()))
                    {
                        item.decreaseQuality();
                    }
                }
            }

            if (!SULFURAS.equals(item.getName()))
            {
                item.decreaseSellIn();
            }

            if (item.getSellIn() < 0)
            {
                if (AGED_BRIE.equals(item.getName()))
                {
                    if (!item.hasReachedMaximumQuality())
                    {
                        item.increaseQuality();
                    }
                }
                else
                {
                    if (BACKSTAGE_PASS.equals(item.getName()))
                    {
                        item.setQuality(0);
                    }
                    else
                    {
                        if (!item.hasZeroQuality())
                        {
                            if (!SULFURAS.equals(item.getName()))
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
