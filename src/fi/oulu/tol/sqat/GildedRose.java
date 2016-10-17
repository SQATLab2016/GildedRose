package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = new ArrayList<Item>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateEndOfDay();
}


	
    public static void updateEndOfDay()
    {
        for (int i = 0; i < items.size(); i++)
        {
            Item item = items.get(i);
            
			if ((!"Aged Brie".equals(item.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) 
            {
                if (HasZeroQuality(i) == false)
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
                    {
                        DecreaseQuality(i);
                    }
                }
            }
            else
            {
                if (HasReachedMaximumQuality(i) == false)
                {
                	IncreaseQuality(i);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                    {
                        if (item.getSellIn() < 11)
                        {
                            if (HasReachedMaximumQuality(i) == false)
                            {
                            	IncreaseQuality(i);
                            }
                        }

                        if (item.getSellIn() < 6)
                        {
                            if (HasReachedMaximumQuality(i) == false)
                            {
                            	IncreaseQuality(i);
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
            {
            	DecreaseSellIn(i);
            }

            if (HasExpired(i) == false)
            {
                if (!"Aged Brie".equals(item.getName()))
                {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                    {
                        if (item.getQuality() > 0)
                        {
                            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
                            {
                            	DecreaseQuality(i);
                            }
                        }
                    }
                    else
                    {
                        item.setQuality(item.getQuality() - item.getQuality());
                    }
                }
                else
                {
                    if (HasReachedMaximumQuality(i) == false)
                    {
                    	IncreaseQuality(i);
                    }
                }
            }
        }
    }



	private static boolean HasExpired(int i) {
		if (items.get(i).getSellIn() < 0){
		return false;
		}else{
			return true;
		}
	}



	private static boolean HasZeroQuality(int i) {
		if(items.get(i).getQuality() > 0){
		return false;
		}else{
			return true;
		}
	}



	private static boolean HasReachedMaximumQuality(int i) {
		
		if(items.get(i).getQuality() < 50){
		return false;
		}else{
			return true;
		}
	}



	public void addItem(Item item) {
		
		items.add(item);
		
	}



	public List<Item> getItems() {
		
		return items;
	}
	
	public static void DecreaseQuality(int i){
		items.get(i).setQuality(items.get(i).getQuality() - 1);
	}
	
	public static void IncreaseQuality(int i){
		items.get(i).setQuality(items.get(i).getQuality() + 1);
	}
	
	public static void DecreaseSellIn(int i){
		items.get(i).setSellIn(items.get(i).getSellIn() - 1);
	}

}
