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
        	if("Sulfuras, Hand of Ragnaros".equals(item.getName()))
        	{
        		//do nothing about quality
        	}
        	
        	else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) 
            {
            	if (item.isExpired())
        		{
        			item.setQuality(0);
                }
            	else if(item.getSellIn() < 6)
        		{
        			item.increaseQuality(3);
        		}
            	else if(item.getSellIn() < 11)
        		{	
        			item.increaseQuality(2);
        		}
            	else 
            	{
            		item.increaseQuality(1);
            	}
            }
            
            else if("Aged Brie".equals(item.getName()))
            {
	            	
            	if (item.isExpired())
            	{
            		item.increaseQuality(2);
            	}
            	else 
            	{
            		item.increaseQuality(1);
            	}
            }
            	         
            else 
            	{
            		if(item.isExpired())
            		{
            			item.decreaseQuality(2);
            		}
            		else
            		{
            			item.decreaseQuality(1);
            		}
            	}

            item.decreaseSellIn(1);
        }
    }

}
