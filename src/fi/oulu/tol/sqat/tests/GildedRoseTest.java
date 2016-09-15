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
//	15.09.2016

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
	public void testUpdateEndOfDay() {
		fail("Test not implemented");
	}
	
	@Test
	public void testUpdateEndOfDay_5DexterityVest_Quality_1_2() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 1, 1));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemDex = items.get(0);
		assertEquals(0,itemDex.getQuality());		
	}
	
	@Test
	public void testUpdateEndOfDay_ElixirOfTheMongoose_5_2 () {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 1, 5));
		
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemElixir = items.get(0);
		assertEquals(2,itemElixir.getQuality());	
	}
	
	@Test
	public void testUpdateEndOfDay_SulfurasHandOfRagnaros_8_8 () {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 8));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals(8,itemSulfuras.getQuality());	
	}
	
	@Test
	public void testUpdateEndofDay_BackstagePasses_10_12 (){
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 9));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemBackstage = items.get(0);
		assertEquals(11,itemBackstage.getQuality());	
	}
	
	@Test
	public void testUpdateEndofDay_BackstagePasses_3_6 (){
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 3));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemBackstage = items.get(0);
		assertEquals(6,itemBackstage.getQuality());	
	}
	
	@Test
	public void testUpdateEndofDay_BackstagePasses_3_0 (){
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 3));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemBackstage = items.get(0);
		assertEquals(0,itemBackstage.getQuality());	
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_50_50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 50) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}

}
