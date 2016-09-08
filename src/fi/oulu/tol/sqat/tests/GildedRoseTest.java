package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	// Example scenarios for testing
	//   Item("+5 Dexterity Vest", 10, 20)); x 
	//   Item("Aged Brie", 2, 0)); x 
	//   Item("Elixir of the Mongoose", 5, 7)); x 
	//   Item("Sulfuras, Hand of Ragnaros", 0, 80)); x
	//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)); x 
	//   Item("Conjured Mana Cake", 3, 6)); x 

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
	public void testUpdateEndOfDay_BackstagePasses_Quality_20_21() {
		// Arrange
		GildedRose store = new GildedRose();

		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		
		store.updateEndOfDay();
	
		
		List<Item> items = store.getItems();
		Item itemBackstagePasses = items.get(0);
		assertEquals(21, itemBackstagePasses.getQuality());
		
	}
	@Test
	public void testUpdateEndOfDay_ConjuredManaCake_Quality_6_5() {
		// Arrange
		GildedRose store = new GildedRose();

		store.addItem(new Item("Conjured Mana Cake", 3, 6));
		
		store.updateEndOfDay();
	
		
		List<Item> items = store.getItems();
		Item itemMana = items.get(0);
		assertEquals(5, itemMana.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_DexterityVest_Quality_20_19() {
		// Arrange
		GildedRose store = new GildedRose();

		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
		
		store.updateEndOfDay();
	
		
		List<Item> items = store.getItems();
		Item itemDexterityVest = items.get(0);
		assertEquals(19, itemDexterityVest.getQuality());
		
	}
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_0_1() {
		// Arrange
		GildedRose store = new GildedRose();

		store.addItem(new Item("Aged Brie", 2, 0));
		
		store.updateEndOfDay();
	
		
		List<Item> items = store.getItems();
		Item itemAgedBrie = items.get(0);
		assertEquals(1, itemAgedBrie.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_Elixir_Quality_7_6() {
		// Arrange
		GildedRose store = new GildedRose();

		store.addItem(new Item("Elixir of the Mongoose", 5, 7));
		
		store.updateEndOfDay();
	
		
		List<Item> items = store.getItems();
		Item itemElixir = items.get(0);
		assertEquals(6, itemElixir.getQuality());
		
	}
	

	@Test
	public void testUpdateEndOfDay_Sulfuras_Quality_80_80() {
		// Arrange
		GildedRose store = new GildedRose();

		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		store.updateEndOfDay();
	
		
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals(80, itemSulfuras.getQuality());
		
	}
}
