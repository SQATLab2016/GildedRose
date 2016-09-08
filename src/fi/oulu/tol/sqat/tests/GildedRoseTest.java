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
		assertEquals("Aged Brie quality increase incorrect", 11, itemBrie.getQuality());
	}
    
	@Test
	public void testUpdateEndOfDay_ConjuredManaCake_Quality_6_5() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 3, 6));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemCake = items.get(0);
		assertEquals("Quality reduction incorrect for regular item" , 5, itemCake.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_SellIn_2_1() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("SellIn reduction for Aged Brie incorrect", 1, itemBrie.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_SellIn_0_Neg1() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 0, 10));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("SellIn reduction to negative value incorrect", -1, itemBrie.getSellIn());
	}
	
	/*
	 * Not sure if this test is valid?
	 * */
	@Test
	public void testUpdateEndOfDay_Sulfuras_Quality_DifferentThan80() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 4, 60));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals("Sulfuras quality can be set to a different value than 80", 80, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras_SellIn_5_5() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 5, 80));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals("Sulfuras SellIn value decreases", 5, itemSulfuras.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras_Quality_80_80() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 5, 80));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals("Sulfuras quality decreases", 80, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_ConjuredManaCake_NegativeSellIn_Quality_8_6() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", -2, 8));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemCake = items.get(0);
		assertEquals("Quality decreases incorrectly with negative SellIn", 6, itemCake.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_ConjuredManaCake_NegativeSellIn_ZeroQuality_0_0() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", -2, 0));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemCake = items.get(0);
		assertEquals("Negative quality", 0, itemCake.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_SellInCloserThan10_Quality_10_12() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 8, 10));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("Quality not increasing correctly when SellIn less than 10", 12, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_QualityAt50_50_50() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 8, 50));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("Quality increased over 50", 50, itemBrie.getQuality());
	}
}
