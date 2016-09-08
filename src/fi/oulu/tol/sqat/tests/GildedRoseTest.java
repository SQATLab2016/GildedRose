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
	public void testUpdateEndOfDay_Sulfuras_Quality() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 0, 48) );
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", -1, 48) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		Item itemSulfuras = items.get(1);
		
		assertEquals(50, itemBrie.getQuality());
		assertEquals(48, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackStage_Quality_Under3() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 2, 10) );
	
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBackstage = items.get(0);
		
		assertEquals(13, itemBackstage.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackStage_Quality_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) );
	
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBackstage = items.get(0);
		
		assertEquals(0, itemBackstage.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_More50() {
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
	
	@Test
	public void testUpdateEndOfDay_TestOne_Quality_10_9() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Test One", 12, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemTest = items.get(0);
		assertEquals(9, itemTest.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_TestOne_Quality_10_8() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Test One", 0, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemTest = items.get(0);
		assertEquals(8, itemTest.getQuality());
	}
}
