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
	public void testUpdateEndOfDay_Sulfuras() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
		
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("error in Sulfuras",80,itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_NegativeQuality() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 10, 20) );
		for(int i=0 ; i<10000; i++){
		store.updateEndOfDay();
		}
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertTrue("quality can´t be negative", 0 <= item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_QualityMoreThan50() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 10, 20) );
		for(int i=0 ; i<100000; i++){
		store.updateEndOfDay();
		}
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertTrue("error in Aged Brie quality can´t be more than 50", 50 >= item.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_DatePassed() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 0, 30) );
		for(int i=0 ; i<10; i++){
		store.updateEndOfDay();
		}
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals("quality should change twice when the date passed", 10, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_passes() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5) );
		for(int i=0 ; i<10; i++){
		store.updateEndOfDay();
		}
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals("error än backstage passes", 30, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_passes_to_zero_after_concert() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5) );
		for(int i=0 ; i<11; i++){
		store.updateEndOfDay();
		}
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals("error in backstage passes its quality cant be 0", 0, item.getQuality());
	}
	@Test
	public void testUpdateEndOfDay_Backstage_cant_be_more_than_50() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 35) );
		for(int i=0 ; i<10; i++){
		store.updateEndOfDay();
		}
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals("error in backstage passes its quality cant be more than 50", 50, item.getQuality());
	}
	@Test
	public void testUpdateEndOfDay_QualityDecreasesTwiceAfterDate() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 50) );
		for(int i=0 ; i<20; i++){
		store.updateEndOfDay();
		}
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals("quality should change twice", 20, item.getQuality());
	}
	@Test
	public void testUpdateEndOfDay_SellInDate() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 50) );
		for(int i=0 ; i<20; i++){
		store.updateEndOfDay();
		}
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals("error in decrasing SellIn", -10, item.getSellIn());
	}
	
	public void testUpdateEndOfDay_SellInDateOf_Backstage() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50) );
		for(int i=0 ; i<20; i++){
		store.updateEndOfDay();
		}
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals("error in decrasing SellIn of Backstage passes", -10, item.getSellIn());
	}
	
	public void testUpdateEndOfDay_SellInDateOf_Sulfuras() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 30, 50) );
		for(int i=0 ; i<20; i++){
		store.updateEndOfDay();
		}
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals("error in decrasing SellIn of Sulfuras", 10, item.getSellIn());
	}


	
}
