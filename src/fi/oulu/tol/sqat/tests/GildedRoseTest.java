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
	public static GildedRose store;
	
	
	@Before
	public void SetUp(){
		store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
		store.addItem(new Item("Aged Brie", 2, 10));
		store.addItem(new Item("Elixir of the Mongoose", 5, 12));
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		store.addItem(new Item("Conjured Mana Cake", 3, 6));
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		//GildedRose store = new GildedRose();
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(1);
		assertEquals(11, itemBrie.getQuality());
	}
	@Test
	public void Test_manacake_quality_after_2_updates(){
		for (int i=0; i<2; i++){
			store.updateEndOfDay();
		}
		Item cake = store.getItems().get(5);
		assertEquals(4, cake.getQuality());
	}
	@Test
	public void Test_manacake_selling_after_2_updates(){
	for (int i=0; i<2; i++){
		store.updateEndOfDay();
	}
	Item cake = store.getItems().get(5);
	assertEquals(1, cake.getSellIn());
	}
    
	@Test
	public void testUpdateEndOfDay_sulfurs() {
		//GildedRose store = new GildedRose();
		
		
		store.updateEndOfDay();
		assertEquals(80, store.getItems().get(3).getQuality());
	}
	@Test
	public void Test_Dexterity_vest_quality_after_1_update(){
		store.updateEndOfDay();
		Item vest = store.getItems().get(0);
		assertEquals(19, vest.getQuality());
	}
	@Test
	public void Test_Dexterity_vest_Sellin_after_1_update(){
		store.updateEndOfDay();
		Item vest = store.getItems().get(0);
		assertEquals(9, vest.getSellIn());
	}
	@Test
	public void Test_aged_brie_quality_after_50_updates_should_be_50(){
		for (int i=0; i<50; i++){
			store.updateEndOfDay();
		}
		Item brie = store.getItems().get(1);
		assertEquals(50, brie.getQuality());
	}
	@Test
	public void Test_aged_brie_selling_after_50_updates_should_be_50(){
		for (int i=0; i<50; i++){
			store.updateEndOfDay();
		}
		Item brie = store.getItems().get(1);
		assertEquals(-48, brie.getSellIn());
	}
	@Test 
	public void Test_Mana_cake_quality_after_10_updates_should_be_zero(){
		for (int i=0; i<10; i++){
			store.updateEndOfDay();
		}
		Item cake = store.getItems().get(5);
		assertEquals(0, cake.getQuality());
	}
	@Test 
	public void Test_backstage_pass_value_when_time_is_droped_to_zero(){
		for (int i=0; i<16; i++){
			store.updateEndOfDay();
		}
		Item pass = store.getItems().get(4);
		assertEquals(0, pass.getQuality());
	}
	@Test 
	public void Test_backstage_pass_double_value_increase_when_time_is_lowered_bellow_10(){
		for (int i=0; i<6; i++){
			store.updateEndOfDay();
		}
		Item pass = store.getItems().get(4);
		assertEquals(27, pass.getQuality());
	}
	@Test 
	public void Test_if_quality_drops_by_2_when_time_has_passed(){
		for (int i=0; i<7; i++){
			store.updateEndOfDay();
		}
		Item elixir = store.getItems().get(2);
		
		assertEquals(3, elixir.getQuality());
	}
	@Test
	public void Test_if_backstage_pass_quality_increses_by_3_when_3_days_left(){
		for (int i=0; i<12; i++){
			store.updateEndOfDay();
		}
		Item pass = store.getItems().get(4);
		assertEquals(41, pass.getQuality());
	}
}
