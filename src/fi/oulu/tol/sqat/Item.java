package fi.oulu.tol.sqat;


public class Item {
    String name;
    int sellIn; 
    int quality; 
    
    public Item(String name, int sellIn, int quality) {
		this.setName(name);
		this.setSellIn(sellIn);
		this.setQuality(quality);
	}
    
	/* Generated getter and setter code */
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSellIn() {
		return sellIn;
	}
	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	
	public void decreaseQuality(int amount)
	{
		this.quality = quality - amount;
	}
	
	public void increaseQuality(int amount)
	{
		this.quality = quality + amount;
	}
	
	public void decreaseSellIn(int amount)
	{
		this.sellIn = sellIn - amount;
	}
	
	public boolean hasReachedMaximumQuality() {
		if (this.quality == 50)
			return true;
		else
			return false;
	}
	
	public boolean hasZeroQuality()
	{
		if (this.quality == 0)
			return true;
		else
			return false;
	}
}

