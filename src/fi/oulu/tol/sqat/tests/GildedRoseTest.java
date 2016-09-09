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
	
	public GildedRose store;
	
	public GildedRoseTest() {
		store = new GildedRose();		
	}
	
	@Before 
	public void FillBasicGoods()	{
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));	
		store.addItem(new Item("Conjured Mana Cage", 3, 6));	
	}
	
	
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
	public void testUpdateEndOfDayRegularGoodsSellInUpdate()
	{		
		// Arrange
		List<Item> items = store.getItems();
		Item vest = items.get(0);

		// Act
		store.updateEndOfDay();

		// Assert
		assertEquals("SellIn value for regular goods not updated correctly at end of day", 9, vest.getSellIn());
	}
	
	@Test 
	public void testUpdateEndOfDayRegularGoodsQualityInUpdate()
	{			
		// Act
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item vest = items.get(0);
		assertEquals("Quality value for regular goods not updated correctly at end of day", 19, vest.getQuality());
	}
		
	@Test
	public void testUpdateQualityNotNegativeAfterUpdates() {
				
		for(int i = 7; i != 0; i--)
			store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item cake = items.get(0);
		assertTrue("Quality is negative after updates", cake.getQuality() > 0);
	}
	
	@Test
	public void testQualityDegradesTwiceFastAfterSellin()
	{
		// Arrange
		List<Item> items = store.getItems();
		Item log = items.get(1);
		
		// Act
		for(int i = 4; i != 0; i--)
			store.updateEndOfDay();
		
		// Assert
		// Starting from 6-1-1-1-2 =2 
		assertTrue("Quality is not degrading twice as fast", log.getQuality()  != 1);		
	}
	
	@Test
	public void testSulfuras() 
	{
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		// Act
		store.updateEndOfDay();	
		
		List<Item> items = store.getItems();
		Item sulf = items.get(0);
		
		// Assert
		assertEquals("Sulfuras quality decreases in update", 80, sulf.getQuality());
	}
	
	@Test
	public void testQualityNeverMoreThan50()
	{
		GildedRose store = new GildedRose();
		// Arrange
		store.addItem(new Item("+5 Dexterity Vest", 25, 100));
		
		store.updateEndOfDay();
		
		List<Item> items = store.getItems();
		Item vest = items.get(0);
		
		assertTrue("Quality is over 50 for non sulfuras product", vest.getQuality() <= 50 );
	}
	
	@Test 
	public void testBackStagePassQualityIncreases()
	{
		// Arrange
		GildedRose store = new GildedRose(); 
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		 
		// Act
		store.updateEndOfDay();			
		
		
		List<Item> items = store.getItems();
		Item pass = items.get(0);
		
		// Assert
		assertEquals("Backstage pass quality not updating correctly", 21, pass.getQuality());
	}
	
	@Test 
	public void testBackStagePassQualityIncreasesByTwo10DaysToConcert()
	{
		// Arrange
		GildedRose store = new GildedRose(); 
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20));	 
		
		// Act
		store.updateEndOfDay();
			
		List<Item> items = store.getItems();
		Item pass = items.get(0);
		
		// Assert
		assertEquals("Backstage pass quality not updating by 2 10 days to concert", 22, pass.getQuality());
	}
	
	@Test 
	public void testBackStagePassQualityIncreasesByThree5DaysToConcert()
	{
		// Arrange		
		GildedRose store = new GildedRose(); 
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20));
		 
		// Act
		store.updateEndOfDay();
			
		List<Item> items = store.getItems();
		Item pass = items.get(0);
		// Assert
		assertEquals("Backstage pass quality not updating by 3 5 days to concert", 23, pass.getQuality());
	}
	
	
	
}
