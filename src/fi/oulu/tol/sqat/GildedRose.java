package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
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
	
    public static void updateEndOfDay() {
    	
       for(Item item:items)
       {            
			String itemName = item.getName();
			
			if ((isAgedBrie(itemName)) || isTAFKAL80ETC_BackStagePass(itemName)) 
            {
				if (!item.reachedMaxiumQuality())
                {
                	item.increaseQuality();

                    if (isTAFKAL80ETC_BackStagePass(itemName))                    
                        handleBackStagePass(item);                    
                }

            }
            else
            {
            	if (!item.hasZeroQuality())
                {
                    if (!isSulfurasHandOfRagnaros(itemName))                    
                        item.decreaseQuality();                    
                }
            }

            if (!isSulfurasHandOfRagnaros(itemName))           
                item.decreaseSellIn();           

            handleItemExpired(item);
        }
    }

	
	private static void handleBackStagePass(Item item) {	
	
		if (item.getSellIn() < 11 && !item.reachedMaxiumQuality())
			item.increaseQuality();
		

		if (item.getSellIn() < 6 && !item.reachedMaxiumQuality())		
			item.increaseQuality();  
	}  
    
	private static void handleItemExpired(Item item) {
		
		String itemName = item.getName();
		if (item.isExpired())
		{
		    if (isAgedBrie(itemName))
		    {
		    	 if (!item.reachedMaxiumQuality())		         
		             item.increaseQuality();		         
		    }
		    else
		    {
		    	   if (isTAFKAL80ETC_BackStagePass(itemName))
		           {
		    		   item.setQuality(0);
		           }
		           else
		           {   
		               if (!item.hasZeroQuality() && !isSulfurasHandOfRagnaros(itemName))		                   
		            	   item.decreaseQuality();
		                
		           }
		    }
		}
	}
	
	private static boolean isSulfurasHandOfRagnaros(String itemName) {    	
	    	return SULFURAS_HAND_OF_RAGNAROS.equals(itemName);
	}
	    
	private static boolean isAgedBrie(String itemName) {
			return AGED_BRIE.equals(itemName);
	}

	private static boolean isTAFKAL80ETC_BackStagePass(String itemName) {
			return BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(itemName);
	}

}
