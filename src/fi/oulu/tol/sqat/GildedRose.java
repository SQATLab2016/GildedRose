package fi.oulu.tol.sqat;

//Refactoring KLA 18.10.2016


import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;

	public void addItem(Item item) {
		// TODO Auto-generated method stub
		
		items.add(item);
	}

 public GildedRose(){
	 items = new ArrayList<Item>();
 }
	public List<Item> getItems() {
		
		return items;
	}

	public void updateEndOfDay() {
		 {
		        for (int i = 0; i < items.size(); i++)
		        {
		            eguals_Aged_or_TAFKAL80ETC_getItemAndQuality(i);

		            equals_Sulfuras_getItems_SetSell(i);
		        }
		 }
	}

	private static void eguals_Aged_or_TAFKAL80ETC_getItemAndQuality(int i) {
		if ((!"Aged Brie".equals(items.get(i).getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
			getItems_QualityMore0(i);
		else
		{
		    getQualityLess50(i);
		}
	}

	private static void equals_Sulfuras_getItems_SetSell(int i) {
		if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
			setSellminus1(i);

			getSellInLess0(i);
	}

	private static void getItems_QualityMore0(int i) {
		{
		    if (items.get(i).getQuality() > 0)
				sulfurasSetQualityminus1(i);
		}
	}

	private static void getQualityLess50(int i) {
		if (items.get(i).getQuality() < 50)
		{
		    setQualityPlus1(i);

		    egual_TAFKAL80ETC(i);
		}
	}

	private static void getSellInLess0(int i) {
		if (items.get(i).getSellIn() < 0)
		{
		    if (!"Aged Brie".equals(items.get(i).getName()))
		    {
		        equals_TAFKAL80ETC_setQualityOrDropQuality(i);
		    } else
				getQualityLess50setQualityplus1(i);
		}
	}

	private static void equals_TAFKAL80ETC_setQualityOrDropQuality(int i) {
		if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
			getItems_QualityMore0(i);
		else
				dropQualityZero(i);
	}

	private static void setSellminus1(int i) {
		{
		    items.get(i).setSellIn(items.get(i).getSellIn() - 1);
		}
	}

	private static void egual_TAFKAL80ETC(int i) {
		if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
		{
		    if (items.get(i).getSellIn() < 11)
				getQualityLess50setQualityplus1(i);

		    if (items.get(i).getSellIn() < 6)
				getQualityLess50setQualityplus1(i);
		}
	}	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
}


	
    public static void updateQuality()
    {
        for (int i = 0; i < items.size(); i++)
        {
            eguals_Aged_or_TAFKAL80ETC_getItemAndQuality(i);

            equals_Sulfuras_getItems_SetSell(i);
        }
    }

	private static void setQualityPlus1(int i) {
		items.get(i).setQuality(items.get(i).getQuality() + 1);
	}

	private static void dropQualityZero(int i) {
		{
		    items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
		}
	}

	private static void getQualityLess50setQualityplus1(int i) {
		{
		    if (items.get(i).getQuality() < 50)
				setQualityplus1(i);
		}
	}

	private static void sulfurasSetQualityminus1(int i) {
		{
		    if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
				setQualityminus1(i);
		}
	}

	private static void setQualityminus1(int i) {
		{
		    items.get(i).setQuality(items.get(i).getQuality() - 1);
		}
	}

	private static void setQualityplus1(int i) {
		{
		    setQualityPlus1(i);
		}
	}

  





}
