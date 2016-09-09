package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {
	private GildedRose store;
	
	public GildedRoseTest() {
		store = new GildedRose();
	}
	
	private void storeElixirAndCake() {
		store.addItem(new Item("Elixir of the Mongoose", 5, 7));
		store.addItem(new Item("Conjured Mana Cake", 3, 6));
	}

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
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_DexterityVest_Quality_20() {
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
		List<Item> items = store.getItems();
		Item itemVest = items.get(0);
		assertEquals(20, itemVest.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_DexterityVest_SellIn_10() {
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
		List<Item> items = store.getItems();
		Item itemVest = items.get(0);
		assertEquals(10, itemVest.getSellIn());
	}
    
	@Test
	public void testUpdateEndOfDay_2Items_Elixir_Cake_CheckNameItem0() {
		storeElixirAndCake();
		List<Item> items = store.getItems();
		Item itemElixir = items.get(0);
		assertEquals("Elixir of the Mongoose", itemElixir.getName());
	}
	
	@Test
	public void testUpdateEndOfDay_2Items_Elixir_Cake_CheckNameItem1() {
		storeElixirAndCake();
		List<Item> items = store.getItems();
		Item itemCake = items.get(1);
		assertEquals("Conjured Mana Cake", itemCake.getName());
	}
	
	@Test
	public void testUpdateEndOfDay_2Items_Elixir_Cake_QualityItem0_11() {
		storeElixirAndCake();
		List<Item> items = store.getItems();
		Item itemElixir = items.get(0);
		assertEquals(6, itemElixir.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_2Items_Elixir_Cake_QualityItem1_11() {
		storeElixirAndCake();
		List<Item> items = store.getItems();
		Item item = items.get(1);
		assertEquals(5, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AddUnchangedItem_Quality_80() {
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(80, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AddConcertPassWithSellInZero_QualityZero() {
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(0, item.getQuality());
		
		fail("Test not implemented");
	}
	
	@Test
	public void testUpdateEndOfDay_AddConcertPassWithSellInGreaterZeroAndLower5_Quality_23() {
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(23, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AddConcertPassWithSellInGreaterFiveAndLower10_Quality_22() {
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(22, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_addConcertPassSellIn1AndQuality50_QualityUnchanged() {
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50));
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(50, item.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_UndefinedItemName_QualityUnchanged() {
		store.addItem(new Item("Item0", 10, 10));
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(10, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_QualityZero_NonNegativeQuality() {
		store.addItem(new Item("Conjured Mana Cake", 3, 0));
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(0, item.getQuality());
	}
}
