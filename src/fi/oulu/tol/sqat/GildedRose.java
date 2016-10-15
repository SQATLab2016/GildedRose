package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
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
        for (int i = 0; i < items.size(); i++)
        {
            Item item = items.get(i);
            
			if ((!AGED_BRIE.equals(item.getName())) && !BACKSTAGE_PASSES.equals(item.getName())) 
            {
                if (notReachedZeroQuality(item))
                {
                    if (!SULFURAS.equals(item.getName()))
                    {
                        item.setQuality(item.decreaseQuality());
                    }
                }
            }
            else
            {
                if (notReachedMaximumQuality(item))
                {
                    item.setQuality(item.increaseQuality());

                    if (BACKSTAGE_PASSES.equals(item.getName()))
                    {
                        if (item.getSellIn() < 11)
                        {
                            if (notReachedMaximumQuality(item))
                            {
                                item.setQuality(item.increaseQuality());
                            }
                        }

                        if (item.getSellIn() < 6)
                        {
                            if (notReachedMaximumQuality(item))
                            {
                                item.setQuality(item.increaseQuality());
                            }
                        }
                    }
                }
            }

            if (!SULFURAS.equals(item.getName()))
            {
                item.setSellIn(item. decreaseSellIn());
            }

            if (isExpired(item))
            {
                if (!AGED_BRIE.equals(item.getName()))
                {
                    if (!BACKSTAGE_PASSES.equals(item.getName()))
                    {
                        if (notReachedZeroQuality(item))
                        {
                            if (!SULFURAS.equals(item.getName()))
                            {
                                item.setQuality(item.decreaseQuality());
                            }
                        }
                    }
                    else
                    {
                        item.setQuality(item.getQuality() - item.getQuality());
                    }
                }
                else
                {
                    if (notReachedMaximumQuality(item))
                    {
                        item.setQuality(item.increaseQuality());
                    }
                }
            }
        }
    }

	private static boolean notReachedMaximumQuality(Item item) {
		return item.getQuality() < 50;
	}

	private static boolean notReachedZeroQuality(Item item) {
		return item.getQuality() > 0;
	}

	private static boolean isExpired(Item item) {
		return item.getSellIn() < 0;
	}

}
