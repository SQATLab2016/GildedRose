package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

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
	
	public GildedRose store;
		
	public GildedRoseTest(){
		store = new GildedRose();
	}
	@Before
	public void addItemsToStore(){
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
	    store.addItem(new Item("Aged Brie", 2, 0));
	    store.addItem(new Item("Elixir of the Mongoose", 5, 7));
	    store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
	    store.addItem(new Item("Conjured Mana Cake", 3, 6));
	}

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		store = new GildedRose();
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
		//Arrange
		
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemDex = items.get(0);
		assertEquals(19, itemDex.getQuality());
	}
	@Test
	public void testUpdateEndOfDaysNegative(){
		//Arrange
		
		
		//Act
		for(int i = 30; i > 0; i--){
			store.updateEndOfDay();
		}
		List<Item> items = store.getItems();
		Item itemDex = items.get(0);
		assertEquals(0, itemDex.getQuality());
	}
	@Test
	public void testUpdateEndOfDaysSeveralItems(){
		//Arrange
		
		//Act
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item item = items.get(3);
		assertEquals(80, item.getQuality());
	}
	@Test
	public void testUpdateSellIn(){
		//Arrange
		
		//Act
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item item = items.get(2);
		assertEquals(4, item.getSellIn());
	}
	@Test
	public void testQualityDecreaseFast(){
		//Arrange
		
		//Act
		for(int i = 0; i < 12; i++){
			store.updateEndOfDay();
		}
		
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(6, item.getQuality());
	}
	@Test
	public void testBrieMaxQuality(){
		//Arrange
		
		//Act
		for(int i = 0; i < 60; i++){
			store.updateEndOfDay();
		}
		
		List<Item> items = store.getItems();
		Item item = items.get(1);
		assertEquals(50, item.getQuality());
	}
	@Test
	public void tesBrieThreeDays(){
		//Arrange
		
		//Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item item = items.get(1);
		assertEquals(0, item.getQuality());
	}
}
