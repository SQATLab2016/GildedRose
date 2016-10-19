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
	public void increaseQuality(){
		this.quality = this.quality +1;
	}
	public void decreaseQuality(){
		this.quality = this.quality -1;
	}
	public void increaseSellIn(){
		this.sellIn = this.sellIn +1;
	}
	public void decreaseSellIn(){
		this.sellIn = this.sellIn -1;
	}
}

