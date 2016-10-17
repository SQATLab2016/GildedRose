package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.Collections;


public class GildedRose {

	private static ArrayList<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
}


	
    public static void updateQuality()
    {
        //for (int i = 0; i < items.size(); i++)
    	
    	for(Item item:items)
        {
    		 if (("Aged Brie".equals(item.getName())) || "Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
            {
                 if (item.getQuality() < 50)
                 {
                     item.increaseQuality();

                     if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                     {
                         if (item.getSellIn() < 11)
                         {
                             if (item.getQuality() < 50)
                             {
                                 item.increaseQuality(); 
                             }
                         }

                         if (item.getSellIn() < 6)
                         {
                             if (item.getQuality() < 50)
                             {
                                 item.increaseQuality();
                             }
                         }
                     }
                 }
            }
            else
            {
                if (item.getQuality() > 0)
                	
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
                    {
                        item.decreaseQuality();
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
            {
                item.decreaseSellIn( );
            }

            if (item.getSellIn() < 0)
            {
                if ("Aged Brie".equals(item.getName()))
                {

                	if (item.getQuality() < 50)
                    {
                       item.increaseQuality();
                    }
                
                }
                else
                {
                	if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                    {
                        item.setQuality(item.getQuality() - item.getQuality());                    }
                    else
                    {
                        if (item.getQuality() > 0)
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



	public void addItem(Item item) {
		// TODO Auto-generated method stub
	 
		
		try {
			items.add(item);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			
			items = new ArrayList<Item>();
			items.add(item);
		}
		
	}



	public void updateEndOfDay() {
		// TODO Auto-generated method stub
		updateQuality();
		
	}



	public ArrayList<Item> getItems() {
		// TODO Auto-generated method stub
		ArrayList <Item> rItems =items;
		Collections.reverse(rItems);
		return rItems;
	}

}
