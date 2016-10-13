package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	/* make strings more readable. 
	*
	* Principle: a. All the letters of the first word are capitalized.
	*            b. All the first letter of the remaining words are capitalized and combined together.
	*            c. Plus "NAME"
	*            d. The three parts mentioned above are  by an underscore(_)
	*/
	private final String AGED_B_NAME = "Aged Brie";
	private final String BACKSTAGE_PTATC_NAME = "Backstage passes to a TAFKAL80ETC concert";
	private final String SULFURAS_HOR_NAME = "Sulfuras, Hand of Ragnaros";
	
	private List<Item> items = new ArrayList<Item>(); // Initialize
	
	public void addItem(Item item) {
		items.add(item);
	}

	public List<Item> getItems() {
		return items;
	}
	
    public void updateEndOfDay()
    {
        for (Item item:items)
        {
            if ( check_name_equal(AGED_B_NAME,item) || check_name_equal(BACKSTAGE_PTATC_NAME,item)) 
            {
            	 if (!item.hasReachedMaximumQuality())
                 {
                 	item.increaseQuality();
                 	
                     if (check_name_equal(BACKSTAGE_PTATC_NAME,item))
                     {
                         if (item.getSellIn() < 11)
                         {
                             if (!item.hasReachedMaximumQuality())
                             {
                                item.increaseQuality();
                             }
                         }

                         if (item.getSellIn() < 6)
                         {
                             if (!item.hasReachedMaximumQuality())
                             {
                                 item.increaseQuality();
                             }
                         }
                     }
                 }
            }
            else
            {
                if (!item.hasZeroQuality())
                {
                    if (!check_name_equal(SULFURAS_HOR_NAME,item))
                    {
                       item.decreaseQuality();
                    }
                }
               
            }
            if (!check_name_equal(SULFURAS_HOR_NAME,item))
            {
                item.decreaseSellIn();
            }

            if (item.isExpired())
            {
                if (check_name_equal(AGED_B_NAME,item))
                {
                    if (!item.hasReachedMaximumQuality())
                    {
                        item.increaseQuality();
                    }
                }
                else
                {
                    if (check_name_equal(BACKSTAGE_PTATC_NAME,item))
                    {
                    	item.setQuality(0);
                    } 
                    else
                    {
                    	 if (!item.hasZeroQuality())
                         {
                             if (!check_name_equal(SULFURAS_HOR_NAME,item))
                             {
                                 item.decreaseQuality();
                             }
                         }                       
                    }
                }
            }
        }
    }
    
    
    
    // private methods.
    
    private boolean check_name_equal(String name, Item it){
    	return name.equals(it.getName());
    }
}