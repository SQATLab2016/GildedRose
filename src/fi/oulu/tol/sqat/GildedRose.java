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
			if ((!"Aged Brie".equals(item.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) 
            {
                if (item.getQuality() > 0)
                {
                    item.decreaseQuality(1);
                }
            }
            else
            {
                if (item.getQuality() < 50)
                {
                    item.setQuality(item.getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                    {
                        if (item.getSellIn() < 11)
                        {
                            if (item.getQuality() < 50)
                            {
                            	item.increaseQuality(1);
                            }
                        }

                        if (item.getSellIn() < 6)
                        {
                            if (item.getQuality() < 50)
                            {
                            	item.increaseQuality(1);
                            }
                        }
                    }
                }
            }

                item.decreaseSellIn();

            if (item.getSellIn() < 0)
            {
                if (!"Aged Brie".equals(item.getName()))
                {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                    {
                        if (item.getQuality() > 0)
                        {
                        	item.decreaseQuality(1);
                        }
                    }
                    else
                    {
                        item.setQuality(item.getQuality() - item.getQuality());
                    }
                }
                else
                {
                    if (item.getQuality() < 50)
                    {
                    	item.increaseQuality(1);
                    }
                }
            }
            if ("Sulfuras, Hand of Ragnaros".equals(item.getName()))
            {
                item.setSulfuras();/*if Sulfuras, ignore everything above, set Sulfuras stats*/
            }
        }
    }
    

}
