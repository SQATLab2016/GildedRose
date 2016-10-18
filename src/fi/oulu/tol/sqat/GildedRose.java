package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;
	
	/**
	 * @param args
	 */
	
	public GildedRose() {
		items = new ArrayList<Item>();
	}

	public List<Item> getItems() {
		return items;
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        items = new ArrayList<Item>();
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
        for (Item item : items)
        {
            if ((!"Aged Brie".equals(item.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) 
            {
                if (item.zeroQuality())
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
                    {
                        item.reduceQuality();
                    }
                }
            }
            else
            {
                if (!item.maxQuality())
                {
                    item.increaseQuality();

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                    {
                        if (item.getSellIn() < 11)
                        {
                            if (item.maxQuality())
                            {
                                item.increaseQuality();
                            }
                        }

                        if (item.getSellIn() < 6)
                        {
                            if (item.maxQuality())
                            {
                                item.increaseQuality();
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
            {
                item.reduceSellIn();
            }

            if (item.zeroSellIn())
            {
                if (!"Aged Brie".equals(item.getName()))
                {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                    {
                        if (!item.zeroQuality())
                        {
                            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
                            {
                                item.reduceQuality();
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
                    if (item.maxQuality())
                    {
                        item.increaseQuality();
                    }
                }
            }
        }
    }



}
