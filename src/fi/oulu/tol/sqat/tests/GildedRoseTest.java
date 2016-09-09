package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
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
    //my tests
	@Test
	public void testUpdateEndOfDay_AgedBrie_sellIn_0_Quality_10() {
		//fail("Test not implemented");
		// Arrange 
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 0, 10));
		//Act
		store.updateEndOfDay();
		//Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("quality should be 11", 11, itemBrie.getQuality());
		
	}
	@Test
	public void testUpdateEndofDay_GeneralItem_Quality_NeverLessThanZero(){
		GildedRose store = new GildedRose();
		store.addItem(new Item("General Item", 1, 0));
		//Act
		store.updateEndOfDay();
		//Assert
		List<Item> items = store.getItems();
		Item itemGeneral = items.get(0);
		assertEquals("quality should be 0", 0, itemGeneral.getQuality());
	}
	@Test
	public void testUpdateEndofDay_AgedBrie_Quality_50_50(){
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 1, 50));
		//Act
		store.updateEndOfDay();
		//Assert
		List<Item> items = store.getItems();
		Item agedBrie = items.get(0);
		assertEquals("quality should be 50", 50, agedBrie.getQuality());
	}
	@Test
	public void testUpdateEndofDay_GeneralItem_SellInLessThanZero_QualityDegradesTwiceAsFast(){
		GildedRose store = new GildedRose();
		store.addItem(new Item("General Item", -1, 10));
		//Act
		store.updateEndOfDay();
		//Assert
		List<Item> items = store.getItems();
		Item generalItem = items.get(0);
		assertEquals("quality should be 8", 8, generalItem.getQuality());
		
	}
}
