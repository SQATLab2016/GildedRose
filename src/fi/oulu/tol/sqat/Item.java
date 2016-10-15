package fi.oulu.tol.sqat;


public class Item {
    private static final int MAX_QUALITY = 50;
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
	public void decreaseQuality() {
		setQuality(getQuality() - 1);
	}
	public void increaseQuality() {
		setQuality(getQuality() + 1);
	}
	public void decreaseSellIn() {
		setSellIn(getSellIn() - 1);
	}
	public boolean isExpired() {
		return getSellIn() < 0;
	}
	public boolean hasZeroQuality() {
		return getQuality() == 0;///
	}
	boolean hasReachedMaximumQuality() {
		return getQuality() == MAX_QUALITY;
	}
}

