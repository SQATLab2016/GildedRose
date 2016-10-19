package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;
	
	private static final String DEXTERITY_VEST_NAME		= "+5 Dexterity Vest";
	private static final String AGED_BRIE_NAME			= "Aged Brie";
	private static final String MONGOOSE_ELIXIR_NAME	= "Elixir of the Mongoose";
	private static final String SULFURAS_NAME			= "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES_NAME	= "Backstage passes to a TAFKAL80ETC concert";
	private static final String MANA_CAKE_NAME			= "Conjured Mana Cake";

	private int currentItemQuality;
	private String currentItemName;
	private int currentItemSellIn;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GildedRose gildedRose = new GildedRose();
		
        System.out.println("OMGHAI!");
		
        items = new ArrayList<Item>();
        items.add(new Item(DEXTERITY_VEST_NAME,		10, 20));
        items.add(new Item(AGED_BRIE_NAME,			2, 0));
        items.add(new Item(MONGOOSE_ELIXIR_NAME,	5, 7));
        items.add(new Item(SULFURAS_NAME,			0, 80));
        items.add(new Item(BACKSTAGE_PASSES_NAME,	15, 20));
        items.add(new Item(MANA_CAKE_NAME,			3, 6));

        gildedRose.updateEndOfDay();
}

	public List<Item> getItems() {
		return items;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}

	public GildedRose() {
		items = new ArrayList<Item>();
	}
	
    public void updateEndOfDay()
    {
        for (int i = 0; i < items.size(); i++)
        {
        	currentItemQuality = items.get(i).getQuality();
        	currentItemSellIn = items.get(i).getSellIn(); 
        	currentItemName = items.get(i).getName();

        	updateSellIn();
        	updateItemQualities();
            
            items.get(i).setQuality(currentItemQuality);
            items.get(i).setSellIn(currentItemSellIn);
        }
    }

    private void updateSellIn() {
    	if (!SULFURAS_NAME.equals(currentItemName))
        	currentItemSellIn--;
    }
    
    private void updateItemQualities() {
    	switch (currentItemName) {
    	case AGED_BRIE_NAME:
    		updateAgedBrieQuality();
    		break;
    	case BACKSTAGE_PASSES_NAME:
    		updateBackstagePassesQuality();
    		break;
    	case SULFURAS_NAME:
    		break;
    	default:
    		updateNormalItemQuality();
    	};
    }
    
    private void updateAgedBrieQuality() {
    	incrementQuality();
    	
    	if (sellInPassed())
    		incrementQuality();
    }
    
    private void updateBackstagePassesQuality() {
    	if (sellInPassed()) {
    		setQuality(0);
    		return;
    	}
    	
    	incrementQuality();
    	
    	if (currentItemSellIn < 11)
    		incrementQuality();

        if (currentItemSellIn < 6)
        	incrementQuality();
    }
    
    private void updateNormalItemQuality() {
    	decrementQuality();
    }
    
    private void incrementQuality() {
    	if (currentItemQuality < 50)
        	currentItemQuality++;
    }
    
    private void decrementQuality() {
    	if (currentItemQuality > 0)
    		currentItemQuality--;
    }
    
    private void setQuality(int newQuality) {
    	currentItemQuality = newQuality;
    }
    
    private boolean sellInPassed() {
    	return currentItemSellIn < 0;
    }

}
