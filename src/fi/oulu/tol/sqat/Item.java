package fi.oulu.tol.sqat;

/**
 * Class for storing the data of various items in CildedRose class
 * <p>
 * 
 * @author (refactoring) Juha E.E. Pätsi ID 20750
 *
 */
public class Item
{
	String name;
	int sellIn;
	int quality;

	public Item(String name, int sellIn, int quality)
	{
		this.setName(name);
		this.setSellIn(sellIn);
		this.setQuality(quality);
	}

	/* Generated getter and setter code */
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getSellIn()
	{
		return sellIn;
	}

	public void setSellIn(int sellIn)
	{
		this.sellIn = sellIn;
	}

	public int getQuality()
	{
		return quality;
	}

	public void setQuality(int quality)
	{
		this.quality = quality;
	}

	// Creating helper methods such as decreaseQuality(), increaseQuality(),
	// decreaseSellIn() in Item class
	public void decreaseQuality()
	{
		quality--;
	}

	public void increaseQuality()
	{
		quality++;
	}

	public void decreaseSellIn()
	{
		sellIn--;
	}

	// Create methods for checking certain conditions such as isExpired(),
	// hasReachedMaximumQuality(), hasZeroQuality().

	public boolean isExpired()
	{
		return sellIn < 0;
	}

	public boolean hasReachedMaximumQuality()
	{
		return quality >= 50;
	}

	public boolean hasZeroQuality()
	{
		return quality == 0;
	}

}
