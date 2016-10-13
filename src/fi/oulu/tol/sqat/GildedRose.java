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
	
	// sellin s
	static private boolean isExpired(int s) {
		if(s <= 0) return true;
		return false;
	}
	
	// quality q
	static private boolean hasReachedMaximumQuality(int q) {
		if(q >= 50) return true;
		return false;
	}
	
	// quality q
	static private boolean hasZeroQuality(int q) {
		if(q <= 0) return true;
		return false;
	}
	
    public static void updateEndOfDay()
    {
    	// loop through all items.
        for (Item item: items)
    	{
        	// if item is cheese or concert pass.
        	if (("Aged Brie".equals(item.name)) || "Backstage passes to a TAFKAL80ETC concert".equals(item.name)) 
            {
        		// if it hasn't reached max quality.
                if (hasReachedMaximumQuality(item.getQuality()) == false)
                {
                	item.increaseQuality();

                	// if the item is concert pass.
                    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name))
                    {
                        if (item.getSellIn() < 11)
                        {
                            if (hasReachedMaximumQuality(item.getQuality()) == false)
                            {
                            	item.increaseQuality();
                            }
                        }

                        if (item.getSellIn() < 6)
                        {
                            if (hasReachedMaximumQuality(item.getQuality()) == false)
                            {
                            	item.increaseQuality();
                            }
                        }
                    }
                }
            }
        	// item is something else.
            else
            {
            	// decrease item quality if
            	// 1. it has quality higher than zero
            	// 2. is not sulfuras.
            	if (hasZeroQuality(item.getQuality()) == false)
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(item.name))
                    {
                    	item.decreaseQuality();
                    }
                }
            }
        	
        	// decrease selling value of all items, except sulfuras'.
            if (!"Sulfuras, Hand of Ragnaros".equals(item.name))
            {
            	item.decreaseSellIn();
            }

            // if the item's selling is zero.
            if (isExpired(item.getSellIn()))
            {
            	// increase cheese's quality.
            	if ("Aged Brie".equals(item.name))
                {
                    if (hasReachedMaximumQuality(item.getQuality()) == false)
                    {
                    	item.increaseQuality();
                    }
                }
            	// item is other than cheese.
                else
                {
                	// if item is concert pass -> it's worthless.
	            	if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
	            		item.setQuality(0);
	                }
	            	
	            	// item is something else.
	                else 
	                {
	                	// decrease item's quality if 
	                	// 1. it has higher quality than zero
	                	// 2. is not sulfuras.
	                	if (hasZeroQuality(item.getQuality()) == false)
	                    {
	                		if (!"Sulfuras, Hand of Ragnaros".equals(item.name))
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
