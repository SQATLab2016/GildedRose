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
        for (int i = 0; i < items.size(); i++)
        {
            Item item = items.get(i);
            
            if (item.isSpecial())
            {
            	if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
            	{
            		if (item.getSellIn() > 10)
            		{
            			if (!item.isMaximumQuality())
            			{
            				item.increaseQuality(1);
            			}
            		}
            		else if (item.getSellIn() < 11 && item.getSellIn() > 5)
            		{
            			if (!item.isMaximumQuality())
            			{
            				item.increaseQuality(2);
            			}
            		}
            		else if (item.getSellIn() < 6 && item.getSellIn() > 0)
            		{
            			if (!item.isMaximumQuality())
            			{
            				item.increaseQuality(3);
            			}
            		}
            		else if (item.HasExpired())
            		{
            				item.setQuality(0);
            		}
            	}
            	else if ("Aged Brie".equals(item.getName()))
            	{
            		if(!item.isMaximumQuality() && item.getSellIn() > 0){
            			item.increaseQuality(1);
            		}else if (!item.isMaximumQuality() && item.getSellIn() <= 0){
                    	item.increaseQuality(2);
                    	}
            	}
            	
            	item.decreaseSellIn();
            	
            	if ("Sulfuras, Hand of Ragnaros".equals(item.getName()))/*if item is Sulfuras, ignore everything above, set Sulfuras stats*/
            	{
            		item.setSulfuras();

            	}
            }
            /*otherwise item is normal*/
            else{
            	if (item.getSellIn() > 0){
            	item.decreaseQuality(1);
            	item.decreaseSellIn();
            	}else if (item.getSellIn() <= 0){
                	item.decreaseQuality(2);
                	item.decreaseSellIn();
                	}
            }
        }
    }
    

}
