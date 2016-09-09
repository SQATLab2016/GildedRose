package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

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
	public void testUpdateEndOfDay_BackstagePasses_Quality_10_12() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBackstagePass = items.get(0);
		assertEquals(12, itemBackstagePass.getQuality());
	}
	
	
	@Test
	public void testUpdateEndOfDay_ElixirOfTheMongoose_Quality_7_6() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 5, 7) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemElixirOfTheMongoose = items.get(0);
		assertEquals("Wrong quality value!" , 6 , itemElixirOfTheMongoose.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_SulfurasHandOfRagnaros_Quality_80_80() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemElixirOfTheMongoose = items.get(0);
		assertEquals("Wrong quality value!" , 80 , itemElixirOfTheMongoose.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_SulfurasHandOfRagnaros_SellIn_0_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemElixirOfTheMongoose = items.get(0);
		assertEquals("Wrong SellIn value!" , 0 , itemElixirOfTheMongoose.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_DexterityVest_SellIn_10_9() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemDexterityVest = items.get(0);
		assertEquals("Wrong SellIn value!" , 9 , itemDexterityVest.getSellIn());
	}
	
    
	@Test
	public void testUpdateEndOfDay() {
		fail("Test not implemented");
	}
}
