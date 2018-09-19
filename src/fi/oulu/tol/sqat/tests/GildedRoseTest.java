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
	public void testUpdateEndOfDay_AgedBrie_Quality_0_1() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 0) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(1, itemBrie.getQuality());		
	}
	
	@Test
	public void testUpdatedEndOfDay_AgedBrie_Quality_50_50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 50) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndOfDay_AgedBrie_Quality_80_wrong() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 80) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("wrong, out of scope", itemBrie.getQuality());
	}
	
	
	@Test
	public void testUpdatedEndOfDay_AgedBrie_SellIn_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 0, 49) );
						
		// Act
		store.updateEndOfDay();
						
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndedOfDay_AgedBrie_Quality_40_42(){
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", -1, 40) );
								
		// Act
		store.updateEndOfDay();
								
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(42, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndedOfDay_AgedBrie__Quality_49_50(){
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", -1, 49) );
								
		// Act
		store.updateEndOfDay();
								
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndedOfDay_AgedBrie_Quality_SmallerThan0(){
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, -1) );
								
		// Act
		store.updateEndOfDay();
								
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("wrong, never be negtive", itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndOfDay_Sulfuras_Quality_80_80() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 1, 80) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(80, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndOfDay_Backstage_Quality_80_wrong() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 80) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals("wrong", itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndOfDay_Backstage_Quality_20_21() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(21, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndOfDay_Backstage_Quality_20_22_SellIn_10() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(22, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndOfDay_Backstage_Quality_20_22_SellIn_6() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(22, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndOfDay_Backstage_Quality_20_23_SellIn_5() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(23, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndOfDay_Backstage_Quality_20_23_sellIn_3() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(23, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndOfDay_Backstage_Quality_20_23_sellIn_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(23, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndOfDay_Backstage_Quality_20_0_sellIn_smallerthan0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", -2, 20) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(0, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndOfDay_Others_Quality_20_19() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 2, 20) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(19, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndOfDay_Others_Quality_6_4() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", -2, 6) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(4, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndOfDay_Others_Quality_1_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", -2, 1) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(0, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndOfDay_AgedBrie_SellIn_12_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 12, 1) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getSellIn());
	}
	
	@Test
	public void testUpdatedEndOfDay_AgedBrie_SellIn_0_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 0, 1) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(-1, itemBrie.getSellIn());
	}
	
	@Test
	public void testUpdatedEndOfDay_Sulfuras_SellIn_80_80() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 80, 80) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(79, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndOfDay_Sulfuras_SellIn_0_80() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(-1, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdatedEndOfDay_Backstage_SellIn_5() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(4, itemBrie.getSellIn());
	}
	
	@Test
	public void testUpdatedEndOfDay_Backstage_sellIn_3() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(2, itemBrie.getSellIn());
	}
	
	@Test
	public void testUpdatedEndOfDay_Backstage_sellIn_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(-1, itemBrie.getSellIn());
	}
	
	@Test
	public void testUpdatedEndOfDay_Backstage_sellIn_smallerthan0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", -2, 20) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(-3, itemBrie.getSellIn());
	}
	
	@Test
	public void testUpdatedEndOfDay_Others_SellIn_smallerthan0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", -2, 6) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(-3, itemBrie.getSellIn());
	}
	
	@Test
	public void testUpdatedEndOfDay_Others_SellIn_2() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 2, 6) );
				
		// Act
		store.updateEndOfDay();
				
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(1, itemBrie.getSellIn());
	}
}
