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
	  if (sellIn<=0){
    	return true;}
    	else return false;
  }
  public boolean isMaximumQuality(){
	  if (quality >= 50){
	  return true;}
	  else return false;
  }
  public boolean hasZeroQuality(){
	  return true;
  }
  public boolean isSpecial(){
	  if (name=="Backstage passes to a TAFKAL80ETC concert" 
		|| name == "Aged Brie"
		|| name == "Sulfuras, Hand of Ragnaros")
        {return true;}
	  	else return false;
}

    
    public void decreaseQuality(int x){
    	quality = quality - x;
    }
    
    public void increaseQuality(int x){
    	quality = quality + x;
    }
    
    public void decreaseSellIn(){
    	/*sellIn only ever decreases by 1*/
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

