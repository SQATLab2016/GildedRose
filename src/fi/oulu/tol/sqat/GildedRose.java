package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;
	
	private static String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
	private static String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static String AGED_BRIE = "Aged Brie";
	
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
            if (item.getName().equals(AGED_BRIE) || item.getName().equals(BACKSTAGE_PASS)) 
            {
            	if (!item.hasReachedMaximumQuality())
                {
                    item.increaseQuality(1);

                    if (item.getName().equals(BACKSTAGE_PASS))
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
                    if (!item.getName().equals(SULFURAS))
                    {
                    	item.decreaseQuality(1);
                    }
                }
                
            }

            if (!item.getName().equals(SULFURAS))
            {
            	item.decreaseSellIn(1);
            }

            if (item.isExpired())
            {
                if (item.getName().equals(AGED_BRIE))
                {
                	if (!item.hasReachedMaximumQuality())
                    {
                    	item.increaseQuality(1);
                    }
                    
                }
                else
                {
                	if (item.getName().equals(BACKSTAGE_PASS))
                    {
                		item.decreaseQuality(item.getQuality());
                        
                    }
                }
            }
        }
    }

}
