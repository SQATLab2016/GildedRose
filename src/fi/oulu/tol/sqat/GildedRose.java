package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;

	public List<Item> getItems() {
		return items;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}

	public GildedRose() {
		items = new ArrayList<Item>();
	}
	private static boolean  updateQuality(int index, int quantity){
		if (items.size() > index){
			Item item = items.get(index);
			int quality = item.getQuality();
			item.setQuality(quality + quantity);
			return true;
		}
		return false;
		
	}
	private static boolean isNotBrie(int i){
		return !itemMatches(i, "Aged Brie");
		
	}
	private static boolean isNotBackstagePass(int i){
		return !isBackstagePass(i);	
	}
	private static boolean isBackstagePass(int i) {
		return itemMatches(i,"Backstage passes to a TAFKAL80ETC concert");
	}
	private static boolean isNotSulfuras(int i){
		return !itemMatches(i, "Sulfuras, Hand of Ragnaros");
		
	}
	private static boolean itemMatches(int i, String name){
		Item item = getItem(i);
		if (item.getName().contentEquals(name)) return true;
		return false;
	}
	private static int getQuality(int i){
		Item item = getItem(i);
		return item.getQuality();
	}
	private static void setQuality(int i, int quality){
		Item item = getItem(i);
		item.setQuality(quality);
	}
	private static Item getItem(int i){
		return items.get(i);
	}
	private static int getSellIn(int i){
		return getItem(i).getSellIn();
	}
	private static void updateSellIn(int i, int quantity){
		Item item = getItem(i);
		int current = item.getSellIn();
		item.setSellIn(current + quantity);
	}
    public static void updateEndOfDay()
    {
        for (int i = 0; i < items.size(); i++){
            if (isNotBrie(i) && isNotBackstagePass(i)){
                if (getQuality(i) > 0 && isNotSulfuras(i)){
                        updateQuality(i, -1);
                }
            }
            else{
                if (getQuality(i) < 50){
                    updateQuality(i, 1);
                    if (isBackstagePass(i)){
                        updateBackstagePass(i);
                    }
                }
            }
            if (isNotSulfuras(i)){
                updateSellIn(i, -1);
            }
            if (getSellIn(i) < 0){
                updateSellInLessThanZero(i);
            }
        }
    }
    private static void updateBackstagePass(int i) {
    	if (getSellIn(i) < 11)
        {                           
                updateQuality(i, 1);
        }
        if (getSellIn(i) < 6)
        {
                updateQuality(i, 1);
        }
	}

	private static void updateSellInLessThanZero(int i){
    	if (isNotBrie(i))
        {
            if (isNotBackstagePass(i))
            {
                if (getQuality(i) > 0 && isNotSulfuras(i))
                {
                        updateQuality(i, -1);
                }
            }
            else
            {
                setQuality(i, 0);
            }
        }
        else
        {
            if (getQuality(i) < 50)
            {
                updateQuality(i, 1);
            }
        }
    }

	

}
