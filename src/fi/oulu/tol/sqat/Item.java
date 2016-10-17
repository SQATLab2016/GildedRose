package fi.oulu.tol.sqat;


public class Item {
    public String name;
	public int sellIn; 
    public int quality; 
    
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
		this.quality--;
		
	} 
	public void increaseQuality(){
		this.quality++;
		
	}
	public void decreaseSellIn(){
		this.sellIn--;
	
	}
	public boolean isExpired(){
		return (this.sellIn==0);
	} 
	
	public boolean hasReachedMaximumQuality(){
		return (this.quality==50);
	}
	
	public boolean hasZeroQuality(){
	   return (this.quality==0);	
	}
}