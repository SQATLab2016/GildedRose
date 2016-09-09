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
	public void testUpdateEndOfDay_BackstagePassQualityIncby2() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20));
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBackstagepass = items.get(0);
		assertEquals("backstage passes quality increase by 2", 22, itemBackstagepass.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_BackstagePassQualityIncby3() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20));
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBackstagepass = items.get(0);
		assertEquals("backstage passes quality increase by 2", 23, itemBackstagepass.getQuality());
	}

	
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
	public void testUpDateEndOfDay_ElixirOfTheMongoose_5_7() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 5, 7));
		
		// Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemMongoose = items.get(0);
		assertEquals("Mongoose quality incorrect", 6, itemMongoose.getQuality());
	}
	
	@Test
	public void testUpDateEndOfDay_HandOfRagnaros_0_80() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		// Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemHandOfRagnaros = items.get(0);
		assertEquals("hand of ragnaros quality incorrect", 80, itemHandOfRagnaros.getQuality());
	}
	
	@Test
	public void testUpDateEndOfDay_DexterityvestQualityIs0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 0));
		
		// Act
		store.updateEndOfDay();
		
		//assert
		List<Item> items = store.getItems();
		Item itemDexterityVest = items.get(0);
		assertEquals("dexterity vest quality incorrect", 0, itemDexterityVest.getQuality());
	}
	
	
	@Test
	public void testUpdateEndOfDay() {
		fail("Test not implemented");
	}
}
