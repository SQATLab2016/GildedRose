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
	public void testUpdateEndOfDay() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 2, 6));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item manaCake = items.get(0);
		assertEquals("Quality not updated.", 5, manaCake.getQuality());
		assertEquals("Sellin not updated.", 1, manaCake.getSellIn());//two assertions needed to test the whole update
	}
	
	@Test
	public void testIfArbitraryItemIsNotSavedInItems() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sweet Roll", 4, 5));	
		
		assertEquals("Arbitrary Item is not saved", store.getItems().size(), 0);	
	}
	
	
	@Test
	public void testAddingArbitraryItem_shouldThrowException(){
		GildedRose store = new GildedRose();
		try{
			store.addItem(new Item("Sweet Roll", 4, 5));
		}catch(Exception e){
			//should throw exception
		}
		fail("Exception not thrown when arbitrary item is added.");
	}
	
	@Test
	public void testUpdateEndOfDay_qualityNeverGoesNegative_quality0() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 2, 0));	

		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item elixir = items.get(0);	
		
		assertEquals("Quality became negative", elixir.getQuality(),  0);
	}
	
	@Test
	public void testUpdateEndOfDay_qualityDecreaseTwiceAfterSellinDateis0() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 1, 15));	

		store.updateEndOfDay(); //sellin 0 quality 14
		store.updateEndOfDay(); //SellIn -1 quality 12
		
		List<Item> items = store.getItems();
		Item elixir = items.get(0);	
		
		assertEquals("Quality didn't go down twice after sell by date", elixir.getQuality(),  12);
	}
	
	@Test
	public void testUpdateEndOfDay_agedBrieQualityDoesntIncreaseThan50() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 5, 49));	

		store.updateEndOfDay(); //sellin 4 quality 50
		store.updateEndOfDay(); //SellIn 3 quality 50
		
		List<Item> items = store.getItems();
		Item brie = items.get(0);	
		
		assertEquals("Aged Brie Quality increased more than 50", brie.getQuality(),  50);
	}
	
	@Test
	public void testUpdateEndOfDay_backstagePassQualityDoesntIncreaseThan50() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));	

		store.updateEndOfDay(); //sellin 4 quality 50
		store.updateEndOfDay(); //SellIn 3 quality 50
		
		List<Item> items = store.getItems();
		Item tickets = items.get(0);	
		
		assertEquals("Ticket Quality increased more than 50", tickets.getQuality(),  50);
	}
	
	@Test
	public void testUpdateEndOfDay_sulfurasDoesntDecreaseInQuality() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));	

		store.updateEndOfDay(); //sellin 0 quality 80		
		
		List<Item> items = store.getItems();
		Item sulfuras = items.get(0);	
		
		assertEquals("Sulfuras quality changed", sulfuras.getQuality(),  80);
	}
	
	@Test(expected=Exception.class)
	public void testAddingItem_sulfurasWithSellindate_ShouldFail() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 2, 80));	

	}
	
	@Test(expected=Exception.class)
	public void testAddingItem_sulfurasWithDifferentQualityThan80_ShouldFail() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 50));	

	}
	
	@Test
	public void testUpdateEndOfDay_backstagePassIncreaseQuality() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 20, 30));	

		store.updateEndOfDay(); //sellin 19 quality 31		
		
		List<Item> items = store.getItems();
		Item ticket = items.get(0);	
		
		assertEquals("Backstage pass quality didnt increase", ticket.getQuality(),  31);
	}
	
}
