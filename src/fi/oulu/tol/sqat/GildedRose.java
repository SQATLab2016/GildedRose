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
        for (int i = 0; i < items.size() ; i++)
        {
            if ((!check_name_equal(AGED_B_NAME,i)) && !check_name_equal(BACKSTAGE_PTATC_NAME,i)) 
            {
                if (item_quality(i) > 0)
                {
                    if (!check_name_equal(SULFURAS_HOR_NAME,i))
                    {
                       set_quality(i,-1);
                    }
                }
            }
            else
            {
                if (item_quality(i) < 50)
                {
                	set_quality(i, 1);
                	
                    if (check_name_equal(BACKSTAGE_PTATC_NAME,i))
                    {
                        if (item_sellin(i) < 11)
                        {
                            if (item_quality(i) < 50)
                            {
                               set_quality(i, 1);
                            }
                        }

                        if (item_sellin(i) < 6)
                        {
                            if (item_quality(i) < 50)
                            {
                                set_quality(i, 1);
                            }
                        }
                    }
                }
            }

            if (!check_name_equal(SULFURAS_HOR_NAME,i))
            {
                set_sellin(i, -1);
            }

            if (item_sellin(i) < 0)
            {
                if (!check_name_equal(AGED_B_NAME,i))
                {
                    if (!check_name_equal(BACKSTAGE_PTATC_NAME,i))
                    {
                        if (item_quality(i) > 0)
                        {
                            if (!check_name_equal(SULFURAS_HOR_NAME,i))
                            {
                                set_quality(i, -1);
                            }
                        }
                    } 
                    else
                    {
                       set_quality(i, -item_quality(i));
                    }
                }
                else
                {
                    if (item_quality(i) < 50)
                    {
                        set_quality(i, 1);
                    }
                }
            }
        }
    }
    
    
    // private methods.
	private int item_quality(int i){
		return items.get(i).getQuality();
	}

    private void set_quality(int i,int change){
    	items.get(i).setQuality(items.get(i).getQuality()+change);
    }
	
    private int item_sellin(int i){
    	return items.get(i).getSellIn();
    }
    
    private void set_sellin(int i, int change){
    	items.get(i).setSellIn(items.get(i).getSellIn()+change);
    }
    private boolean check_name_equal(String name, int i){
    	return name.equals(items.get(i).getName());
    }
}
