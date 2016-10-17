package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
	private static final int SELL_IN_TEN = 10, SELL_IN_FIVE = 5;
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
    	for(Item item:items){
    		
    		if (!SULFURAS.equals(item.getName()))
            {
                item.decreaseSellIn();
            }
    		
            if ((AGED_BRIE.equals(item.getName())) || BACKSTAGE_PASSES.equals(item.getName())) 
            {
                if (BACKSTAGE_PASSES.equals(item.getName()) && item.getSellIn() <= SELL_IN_TEN)
                {
                    item.increaseQuality();
                    
                    if (item.getSellIn() <= SELL_IN_FIVE)
                    {
                        item.increaseQuality();
                    }
                }
                item.increaseQuality();
            }
            else if (!SULFURAS.equals(item.getName()))
            {
            	item.decreaseQuality();
            }


            if (item.isExpired())
            {
                if (AGED_BRIE.equals(item.getName()))
                {
                    item.increaseQuality();
                }
                else if (BACKSTAGE_PASSES.equals(item.getName()))
                {
            		item.setQuality(0);
                }
                else if(!SULFURAS.equals(item.getName()))
	            {
	                item.decreaseQuality();
	            }
            }
        }
    }
    
}
