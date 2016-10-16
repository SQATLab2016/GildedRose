package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;

/**
 * GildedRose Class Description
 * 
 * Here are the rules for updating quality and sellIn values:
 * <p>
 * All items have a SellIn value which denotes the number of days we have to
 * sell the item
 * <p>
 * All items have a Quality value which denotes how valuable the item is
 * <p>
 * At the end of each day our system lowers both values for every item
 * <p>
 * Pretty simple, right? Well this is where it gets interesting:
 * <p>
 * Once the sell by date has passed, Quality degrades twice as fast
 * <p>
 * The Quality of an item is never negative
 * <p>
 * "Aged Brie" actually increases in Quality the older it gets
 * <p>
 * The Quality of an item is never more than 50
 * <p>
 * "Sulfuras", being a legendary item, never has to be sold or decreases in
 * Quality
 * <p>
 * "Backstage passes", like aged brie, increases in Quality as it's SellIn value
 * approaches; Quality increases by 2 when there are 10 days or less and by 3
 * when there are 5 days or less but Quality drops to 0 after the concert.
 * <p>
 * Clarification: an item can never have its Quality increase above 50, however
 * "Sulfuras" is a legendary item and as such its Quality is 80 and it never
 * alters.
 * <p>
 * 
 * @author (refactoring) Juha E.E. Pätsi ID 20750
 * 
 *
 */
public class GildedRose
{

	private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
	private static List<Item> items = null;

	/**
	 * Returns the Item values stored in a List in a GiledRose class instance
	 * 
	 * @return a List of Items
	 */
	public List<Item> getItems()
	{
		return items;
	}

	/**
	 * Adds an Item to a GiledRose class instance
	 * 
	 * @param item
	 *            to be added
	 */
	public void addItem(Item item)
	{
		items.add(item);
	}

	/**
	 * Initeilalizes the List of Items in a GiledRose class instance
	 */
	public GildedRose()
	{
		items = new ArrayList<Item>();
	}

	/**
	 * Updates the items daily
	 */
	public static void updateEndOfDay()
	{
		// changing the loop to for(Item item:items) m
		// for (int i = 0; i < items.size(); i++)
		for (Item item : items)
		{
			updateQuality(item);

			upadateExpiringQuality(item);
		}
	}

	/**
	 * @param item
	 *            update the SellIn date and the quality if expired
	 */
	private static void upadateExpiringQuality(Item item)
	{
		if (!SULFURAS_HAND_OF_RAGNAROS.equals(item.getName()))
		{
			// item.setSellIn(item.getSellIn() - 1);
			item.decreaseSellIn();
		}

		// if (item.getSellIn() < 0)
		if (item.isExpired())
		{
			if (AGED_BRIE.equals(item.getName()))
			{
				// if (item.getQuality() < 50)
				if (!item.hasReachedMaximumQuality())
				{
					// item.setQuality(item.getQuality() + 1);
					item.increaseQuality();
				}
			}
			else
			{
				if (BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT
						.equals(item.getName()))

				{
					item.setQuality(item.getQuality() - item.getQuality());
				}
				else
				{
					// if (item.getQuality() > 0)
					if (!item.hasZeroQuality())
					{
						if (!SULFURAS_HAND_OF_RAGNAROS.equals(item.getName()))
						{
							// item.setQuality(item.getQuality() - 1);
							item.decreaseQuality();
						}
					}
				}

			}

		}
	}

	/**
	 * @param item
	 *            is the item to be updated
	 */
	private static void updateQuality(Item item)
	{
		// // Extracting a local variable for items.get(i)
		// Item item = items.get(i);
		if (isItemWithIncreasingValue(item))
		{
			// if (item.getQuality() < 50)
			if (!item.hasReachedMaximumQuality())
			{
				// item.setQuality(item.getQuality() + 1);
				item.increaseQuality();

				if (BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT
						.equals(item.getName()))
				{
					if (item.getSellIn() < 11)
					{
						// if (item.getQuality() < 50)
						if (!item.hasReachedMaximumQuality())
						{
							// item.setQuality(item.getQuality() + 1);
							item.increaseQuality();
						}
					}

					if (item.getSellIn() < 6)
					{
						// if (item.getQuality() < 50)
						if (!item.hasReachedMaximumQuality())
						{
							// item.setQuality(item.getQuality() + 1);
							item.increaseQuality();
						}
					}
				}
			}
		}
		else
		{
			// if (item.getQuality() > 0)
			if (!item.hasZeroQuality())
			{
				if (!SULFURAS_HAND_OF_RAGNAROS.equals(item.getName()))
				{
					// item.setQuality(item.getQuality() - 1);
					item.decreaseQuality();
				}
			}
		}
	}

	/**
	 * @param item
	 *            is the item to be updated
	 * @return true it items value can increase as the time passes
	 */
	private static boolean isItemWithIncreasingValue(Item item)
	{
		return AGED_BRIE.equals(item.getName())
				|| BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT
						.equals(item.getName());
	}

}
