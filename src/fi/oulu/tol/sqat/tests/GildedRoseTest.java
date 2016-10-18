package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

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
	public void testGildedRose_SellDatePasedQualityDecreasedTwice() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(8, item.getQuality());
	}
    
	@Test
	public void testGildedRose_QualityLessThanEqualTo50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 50) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(50, item.getQuality());
	}
 
	@Test
	public void testGildedRose_SulfurasQuality() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(80, item.getQuality());
	}
	
	@Test
	public void testGildedRose_BackstageQuality10days() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) );
		
		// Act
		store.updateEndOfDay();
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(12, item.getQuality());
	}
	
	@Test
	public void testGildedRose_BackstageQuality5days() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) );
		
		// Act
		store.updateEndOfDay();
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(13, item.getQuality());
	}
	
	
	@Test
	public void testGildedRose_BackstageQualityAfterTheConcert() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(0, item.getQuality());
	}
}
