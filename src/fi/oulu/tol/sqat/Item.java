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
	
	public void decreaseQuality(int decrease) {
		if(this.quality - decrease > 0) {
			this.quality -= decrease;
		}
		else {
			this.quality = 0;
		}
	}
	
	public void increaseQuality(int increase) {
		if(this.quality + increase <= 50) {
			this.quality += increase;
		}
		else {
			this.quality = 50;
		}
	}
	
	public void decreaseSellIn(int decrease) {
		if (!"Sulfuras, Hand of Ragnaros".equals(getName())) {
			this.sellIn -= decrease;
		}
	}
	
	public boolean isExpired() {
		if(getSellIn()<=0) {
			return true;
		}
		else {
			return false;
		}
	}
}

