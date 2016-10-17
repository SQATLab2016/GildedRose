package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private List<Item> items = new ArrayList<Item>();

	public List<Item> getItems() {
		return items;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}

	private boolean isExpired(int sellin) {
		if(sellin <= 0) 
			return true;
		else
			return false;
	}
		
	private boolean hasReachedMaximumQuality(int quality) {
		if(quality >= 50) 
			return true;
		else
			return false;
	}
		
	private boolean hasZeroQuality(int quality) {
		if(quality <= 0) 
			return true;
		else
			return false;
	}
	
    public void updateEndOfDay()
    {
        for (Item item:items)
        {
            if ("Aged Brie".equals(item.getName()) || "Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) 
            {
            	if (hasReachedMaximumQuality(item.getQuality()) == false)
                {
                	item.increaseQuality();

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
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
            else
            {
            	if (hasZeroQuality(item.getQuality()) == false)
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
                    {
                        item.decreaseQuality();
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
            {
                item.decreaseSellIn();
            }

            if (isExpired(item.getSellIn()) == true)
            {
            	if("Aged Brie".equals(item.getName()))
            	{
            		if (hasReachedMaximumQuality(item.getQuality()) == false)
                    {
                    	item.increaseQuality();
                    }
            	}
            	else
            	{
            		if("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
            		{
            			item.setQuality(item.getQuality() - item.getQuality());
            		}
            		else
            		{
            			if (hasZeroQuality(item.getQuality()) == false)
                        {
                            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
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
