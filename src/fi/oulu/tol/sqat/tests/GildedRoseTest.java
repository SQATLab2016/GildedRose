package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {
	private int i = 3;
// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
    
	@Test
	public void testUpdateEndOfDay_SulfurasQuality() {

		//Sulfuras Quality decreases
				GildedRose store = new GildedRose();
				store.addItem(new Item("Sulfuras", 0, 80) );
				
				store.updateEndOfDay();

				List<Item> items = store.getItems();
				Item itemSulfuras = items.get(0);
				assertEquals(80, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_15_16() {

		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 4, 15) );
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(16, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Sellin() {

		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 9, 20) );
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(10, itemBrie.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras_Sellin() {

		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras", 0, 80) );
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals(0, itemSulfuras.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_Brie3days() {

		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 9, 20) );
		
		while(i >= 1){
		store.updateEndOfDay();
		i = i - 1;
		}
		
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(23, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePassesTest_QualityIncrease() {

		//4 days
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 9, 20) );
		
		while(i >= 0){
		store.updateEndOfDay();
		i = i - 1;
		}
		
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(28, itemBrie.getQuality());
	}
	
}
