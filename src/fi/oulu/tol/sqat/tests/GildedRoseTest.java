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
	public void testUpdateEndOfDay_BackStagePassesQualityIncreasesBy2() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();//10
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(29, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackStagePassesQualityIncreasesBy3() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();//10
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();//5
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(38, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackStagePassesDropTo0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();//10
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();//5
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();//0
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(0, itemPass.getQuality());
	}
    
	@Test
	public void testUpdateEndOfDay() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 3, 6));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemCake = items.get(0);
		assertEquals(5, itemCake.getQuality());
		assertEquals(2, itemCake.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_SulfurasQualityStaysAt80() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		//Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals(80, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrieQualityNotOver50() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 50));
		
		//Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemAgedBrie = items.get(0);
		assertEquals(50, itemAgedBrie.getQuality());	
	}
	
	@Test
	public void testUpdateEndOfDay_5DexterityVestQualityDecreases() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
		
		//Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item item5DexterityVest = items.get(0);
		assertEquals(17, item5DexterityVest.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_5DexterityVestSellInDecreases() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
		
		//Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item item5DexterityVest = items.get(0);
		assertEquals(7, item5DexterityVest.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_5DexterityVestQualityDecreasesTwiceAsFast() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 0, 10));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item item5DexterityVest = items.get(0);
		assertEquals(8, item5DexterityVest.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_ConjuredManaCakeQualityCantBeNegative() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 3, 6));
		
		//Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemConjuredManaCake = items.get(0);
		assertEquals(0, itemConjuredManaCake.getQuality());
	}
}
