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
	public void testUpdateEndOfDay() {		
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBackstagePasses = items.get(0);
		assertEquals("Result of updateEndOfDay for SellIn is incorrect", 1, itemBackstagePasses.getSellIn());			
	}
	
	@Test
	public void testQualityOfSulfurasNeverDecreases() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemBackstagePasses = items.get(0);
		assertEquals("Sulfuras quality decreases incorrectly", 10, itemBackstagePasses.getQuality());
	}
}
