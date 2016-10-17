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
    
    public boolean reachedMaxiumQuality() {
    	return quality >= 50;    	
    }
    
    public boolean hasZeroQuality() {
    	return quality == 0;
    }
    
    // Past date of sellIn
    public boolean isExpired() {
    	return sellIn < 0;    	
    }
    
    public void decreaseQuality() {    	
    	quality--;
    	if(quality < 0)
    		quality = 0;
    } 
        
    public void increaseQuality() {
    	quality++;
    }
    
    public void decreaseSellIn() {
    	sellIn--;
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
}

