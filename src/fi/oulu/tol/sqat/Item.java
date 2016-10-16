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
	public void decreaseQuality(){
		--quality;
	}
	public void increaseQuality(){
		quality++;
	}
	public void decreaseSellIn(){
		--sellIn;
	}
	public boolean isExpired(){
		if (sellIn <0) 
			return true;
		return false;
	}
	public boolean hasReachedMaximumQuality(){
		if(quality < 50)
			return false;
		return true;
	}
	public boolean hasZeroQuality(){
		if(quality >0)
			return false;
		return true;
		
	}
}

