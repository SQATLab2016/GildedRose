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
	public void testUpdateEndOfDay_AgedBrie_SellIn_2_10() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(1, itemBrie.getSellIn());
	}
    
    
	@Test
	public void testUpdateEndOfDay() {
		fail("Test not implemented");
	}
	
	@Test
	public void testUpdateEndOfDay_Conjured_mana_cake_Quality_3_6() {
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
	public void testUpdateEndOfDay_Dexterity_vest_10_20_selling_after_6_days() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Dexterity vest", 10, 20));
		
		//Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		
		//Assert
		List<Item> items = store.getItems();
		Item itemDexVest = items.get(0);
		assertEquals(14, itemDexVest.getQuality());
		assertEquals(4, itemDexVest.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras_Hand_of_Ragnaros_0_80() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals(80, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_quality_double_degrade() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(16, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_quality_over_50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 50) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();

		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_Conjured_mana_cake_Quality_negative() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 3, 1));
		
		//Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemCake = items.get(0);
		assertEquals(0, itemCake.getQuality());
	}
	
	
	@Test
	public void testUpdateEndOfDay_Backstage_passes_quality_5_11() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 11));
		
		//Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(17, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_passes_quality_12_11() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 11));
		
		//Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(13, itemPass.getQuality());
	}

	
	
	
	
}
