package fi.oulu.tol.sqat;


public class Item {
	
	final int MAX_QUALITY = 50, MIN_QUALITY = 0;
	
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
		if(this.quality > MIN_QUALITY){
			this.quality--;
		}
	}
	public void increaseQuality(){
		if(this.quality < MAX_QUALITY){
			this.quality++;
		}
	}
	public void decreaseSellIn(){
		this.sellIn--;
	}
	public boolean isExpired(){
    	if(this.sellIn < 0){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
}

