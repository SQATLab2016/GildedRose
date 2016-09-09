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
	public void testUpdateEndofDay_DexVest_Q10_20(){
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest",10,20));
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemVest = items.get(0);
		assertEquals(19, itemVest.getQuality());
	}
	@Test
	public void testUpdateEndofDay_Mongooselixir_5_7(){
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose",5,7));
		//Act
		store.updateEndOfDay();
		//Assert
		List<Item> items = store.getItems();
		Item itemElixir = items.get(0);
		assertEquals(6, itemElixir.getQuality());
	}
	@Test
	public void testUpdateEndofDay_Sulfuras_0_80(){
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros",0,80));
		//Act
		store.updateEndOfDay();
		//Assert
		List<Item> items = store.getItems();
		Item itemHand = items.get(0);
		assertEquals(80, itemHand.getQuality());
	}
	
	@Test
	public void testUpdateEndofDay_Passes_10_20(){
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",10,20));
		//Act
		store.updateEndOfDay();
		//Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(22, itemPass.getQuality());
	}
	
	
	@Test
	public void testUpdateEndofDay_Passes_5_20(){
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",5,20));
		//Act
		store.updateEndOfDay();
		//Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(23, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndofDay_Passes_0_20(){
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",0,20));
		//Act
		store.updateEndOfDay();
		//Assert
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(0, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndofDay_ManaCake_3_6(){
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Mana Cake",5,6));
		//Act
		store.updateEndOfDay();
		//Assert
		List<Item> items = store.getItems();
		Item itemCake = items.get(0);
		assertEquals(5, itemCake.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay() {
		fail("Test not implemented");
	}
}
