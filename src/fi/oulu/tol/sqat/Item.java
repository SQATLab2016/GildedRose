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
  public boolean HasExpired (){
    	return true;
  }
  public boolean isMaximumQuality(){
	  return true;
  }
  public boolean hasZeroQuality(){
	  return true;
  }
  public boolean checkSpecial(){
	  return true;

  }
  public boolean isSpecial(){
	  return true;
  }

    
    public void decreaseQuality(int x){
    	quality = quality - x;
    }
    
    public void increaseQuality(int x){
    	quality = quality + x;
    }
    
    public void decreaseSellIn(){
    	sellIn = sellIn - 1;
    }
    
    public void setSulfuras(){
    	quality = 80;
    	sellIn = 0;
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

