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
            if (item.getName().equals("Aged Brie") || item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) 
            {
            	if (!item.hasReachedMaximumQuality())
                {
                    item.increaseQuality(1);

                    if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert"))
                    {
                    	if (!item.hasReachedMaximumQuality())
                    	{
                    		if (item.getSellIn() < 11) 
                    			item.increaseQuality(1);
                    		if (item.getSellIn() < 6)
                    			item.increaseQuality(1);
                    	}
                    }
                }
            }
            else
            {
            	if (!item.hasZeroQuality())
                {
                    if (!item.getName().equals("Sulfuras, Hand of Ragnaros"))
                    {
                    	item.decreaseQuality(1);
                    }
                }
                
            }

            if (!item.getName().equals("Sulfuras, Hand of Ragnaros"))
            {
            	item.decreaseSellIn(1);
            }

            if (item.isExpired())
            {
                if (item.getName().equals("Aged Brie"))
                {
                	if (!item.hasReachedMaximumQuality())
                    {
                    	item.increaseQuality(1);
                    }
                    
                }
                else
                {
                	if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert"))
                    {
                		item.decreaseQuality(item.getQuality());
                        
                    }
                }
            }
        }
    }

}
