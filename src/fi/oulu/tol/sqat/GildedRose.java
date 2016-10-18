package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;

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
		for(Item item:items)		{
			if (!compareName("Aged Brie", item) && !compareName("Backstage passes to a TAFKAL80ETC concert", item)) 
			{
				if (hasMoreThanZeroQuality(item))
				{
					decrement1QualityIfSultaras(item);
				}
			}
			else
			{
				if (hasNotReachedMaximumQuality(item))
				{
					increment1Quality(item);			

					if (compareName("Backstage passes to a TAFKAL80ETC concert", item))
					{
						if (hasLessThanElevenSellIn(item))
						{
							if (hasNotReachedMaximumQuality(item))
							{
								increment1Quality(item);			
							}
						}

						if (hasLessThanSixSellIn(item))
						{
							if (hasNotReachedMaximumQuality(item))
							{
								increment1Quality(item);			
							}
						}
					}
				}
			}

			decrement1SellInIfSultaras(item);


			if (hasLessThanZeroSellIn(item))
			{
				if (!compareName("Aged Brie", item))
				{
					if (!compareName("Backstage passes to a TAFKAL80ETC concert", item))			{
						if (hasMoreThanZeroQuality(item))
						{
							decrement1QualityIfSultaras(item);

						}
					}
					else
					{
						hasZeroQuality(item);
					}
				}
				else
				{
					if (hasNotReachedMaximumQuality(item))
						increment1Quality(item);
				}
			}
		}
	}

	public static boolean compareName(String nameA,Item item){
		return nameA.equals(item.getName());
	}
	public static void decrement1QualityIfSultaras(Item item){

		if (!compareName("Sulfuras, Hand of Ragnaros", item))
		{
            item.setQuality(item.getQuality() - 1);

		}
	}
	public static void decrement1SellInIfSultaras(Item item){

		if (!compareName("Sulfuras, Hand of Ragnaros", item))
		{
			item.setSellIn(item.getSellIn() - 1);
		}
	}
	public static void increment1Quality(Item item){

		item.setQuality(item.getQuality() + 1);

	}
	public static boolean hasNotReachedMaximumQuality(Item item){
		return item.getQuality() < 50;

	}
	public static void hasZeroQuality(Item item){
		item.setQuality(item.getQuality() - item.getQuality());

	}
	public static boolean hasMoreThanZeroQuality(Item item){
		return item.getQuality() > 0;
	}
	public static boolean hasLessThanZeroSellIn(Item item){
		return item.getSellIn() < 0;
	}

	public static boolean hasLessThanElevenSellIn(Item item){
		return 	item.getSellIn() < 11;
	}
	public static boolean hasLessThanSixSellIn(Item item){
		return 	item.getSellIn() < 6;
	}
	public void addItem(Item item){
		items = new ArrayList<Item>();
		items.add(item);
	}
	public static List<Item> getItems() {
		return items;
	}

}
