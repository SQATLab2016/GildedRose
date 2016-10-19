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
	
	/* Ari's implementations */
	public void increaseQuality(int quality) {
		this.setQuality(getQuality() + 1);
	}
	public void decreaseQuality(int quality) {
		this.setQuality(getQuality() - 1);
	}
	public void decreaseSellIn(int sellIn) {
		this.setSellIn(getSellIn() - 1);
	}
	public void isExpired() {
		// Not implemented yet
	}
	public void hasReachedMaximumQuality() {
		// Not implemented yet
	}
	public void hasZeroQuality(int quality) {
		// Not implemented yet
	}

}

