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
    
	// my tests ...
	// item params: name, sellIn, quality
	
	@Test
	public void testUpdateEndOfDay_dex_vest_quality_10_20() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(19, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_dex_vest_sellin_10_20() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(9, item.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_dex_vest_quality_degrade_twice_as_fast_0_20() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 0, 20));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(18, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_dex_vest_quality_not_negative_0_1() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 0, 1));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		
		// if there were a bug this would go down by two to -1. But that's not allowed so the quality is zero.
		assertEquals(0, item.getQuality()); 
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_not_over_50() {
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
	public void testUpdateEndOfDay_sulfuras_quality_never_decreases() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(80, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_backstage_pass_quality_increase_two() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(22, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_backstage_pass_quality_increase_three() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(23, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_backstage_pass_quality_zero() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(0, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_elixir_mongoose_quality_5_10() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 5, 10));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(9, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_aged_brie_sellin_2_0() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 0));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(1, item.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_aged_brie_quality_increase_selling_zero() {
		
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 0, 0));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(0, item.getQuality());
		
		// When the aged brie's sellIn value is zero, it's value is increased by two.
		// Shouldn't it be zero just like the concert pass' quality?
		// Now the cheese's quality will increase indefinitely, even after it's sellIn date is gone by.
		// -> is this supposed to work like this?
	}
	
	
	// end of my tests.
	
}
