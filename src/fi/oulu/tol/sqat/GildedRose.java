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
    	for(Item item:items)
        {
            if ((!"Aged Brie".equals(item.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) 
            {
                if (item.getQuality() > 0)
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
                    {
                    	item.decreaseQuality(1);
                    }
                }
            }
            else
            {
                if (!item.hasReachedMaximumQuality())
                {
                    item.setQuality(item.getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                    {
                        if (item.getSellIn() < 11)
                        {
                            if (!item.hasReachedMaximumQuality())
                            {
                            	item.increaseQuality(1);
                            }
                        }

                        if (item.getSellIn() < 6)
                        {
                            if (!item.hasReachedMaximumQuality())
                            {
                            	item.increaseQuality(1);
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
            {
            	item.decreaseSellIn(1);
            }

            if (item.getSellIn() < 0)
            {
                if ("Aged Brie".equals(item.getName()))
                {
                	if (!item.hasReachedMaximumQuality())
                    {
                    	item.increaseQuality(1);
                    }
                    
                }
                else
                {
                	if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                    {
                		item.decreaseQuality(item.getQuality());
                        
                    }
                    else
                    {
                    	if (item.getQuality() > 0)
                        {
                            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
                            {
                                item.decreaseQuality(1);
                            }
                        }
                    }
                }
            }
        }
    }

}
