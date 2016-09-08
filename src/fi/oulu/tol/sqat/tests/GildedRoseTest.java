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
		GildedRose gR = new GildedRose();
		gR.addItem(new Item("Aged Brie", 2, 10) );

		// Act
		GildedRose.updateEndOfDay();

		// Assert
		List<Item> itemList = gR.getItems();
		Item itemBrie = itemList.get(0);
		assertEquals(11, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_Sulfuras_Quality_80_80() {
		
		GildedRose gR = new GildedRose();

		gR.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		GildedRose.updateEndOfDay();
	
		
		List<Item> itemList = gR.getItems();
		Item itemListulfuras = itemList.get(0);
		assertEquals(80, itemListulfuras.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_ConjuredManaCake_Quality_6_5() {
		// Arrange
		GildedRose gR = new GildedRose();

		gR.addItem(new Item("Conjured Mana Cake", 3, 6));
		
		GildedRose.updateEndOfDay();
	
		
		List<Item> itemList = gR.getItems();
		Item itemMana = itemList.get(0);
		assertEquals(5, itemMana.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_DexterityVest_Quality_20_19() {
		// Arrange
		GildedRose gR = new GildedRose();

		gR.addItem(new Item("+5 Dexterity Vest", 10, 20));
		
		GildedRose.updateEndOfDay();
	
		
		List<Item> itemList = gR.getItems();
		Item itemDexterityVest = itemList.get(0);
		assertEquals(19, itemDexterityVest.getQuality());
		
	}
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_0_1() {
		GildedRose gR = new GildedRose();

		gR.addItem(new Item("Aged Brie", 2, 0));
		
		GildedRose.updateEndOfDay();
	
		
		List<Item> itemList = gR.getItems();
		Item itemAgedBrie = itemList.get(0);
		assertEquals(1, itemAgedBrie.getQuality());
		
	}
	@Test
	public void testUpdateEndOfDay_BackstagePasses_Quality_20_21() {
		GildedRose gR = new GildedRose();

		gR.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		
		GildedRose.updateEndOfDay();
	
		
		List<Item> itemList = gR.getItems();
		Item itemBackstagePasses = itemList.get(0);
		assertEquals(21, itemBackstagePasses.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_Elixir_Quality_7_6() {
		GildedRose gR = new GildedRose();

		gR.addItem(new Item("Elixir of the Mongoose", 5, 7));
		
		GildedRose.updateEndOfDay();
	
		
		List<Item> itemList = gR.getItems();
		Item itemElixir = itemList.get(0);
		assertEquals(6, itemElixir.getQuality());
		
	}
	


}
