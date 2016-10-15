package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	// Example scenarios for testing
	// Item("+5 Dexterity Vest", 10, 20));
	// Item("Aged Brie", 2, 0));
	// Item("Elixir of the Mongoose", 5, 7));
	// Item("Sulfuras, Hand of Ragnaros", 0, 80));
	// Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
	// Item("Conjured Mana Cake", 3, 6));
	GildedRose store = new GildedRose();

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {

		store.addItem(new Item("Aged Brie", 2, 10));

		// Act
		store.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay() {

		store.addItem(new Item("Conjured Mana Cake", 2, 6));

		store.updateEndOfDay();

		List<Item> items = store.getItems();
		Item manaCake = items.get(0);
		assertEquals("Quality not updated.", 5, manaCake.getQuality());
		assertEquals("Sellin not updated.", 1, manaCake.getSellIn());// two
																		// assertions
																		// needed
																		// to
																		// test
																		// the
																		// whole
																		// update
	}

	@Test
	public void testUpdateEndOfDay_qualityNeverGoesNegative_quality0() {

		store.addItem(new Item("Elixir of the Mongoose", 2, 0));

		store.updateEndOfDay();

		List<Item> items = store.getItems();
		Item elixir = items.get(0);

		assertEquals("Quality became negative", elixir.getQuality(), 0);
	}

	@Test
	public void testUpdateEndOfDay_qualityDecreaseTwiceAfterSellinDateis0() {

		store.addItem(new Item("Elixir of the Mongoose", 1, 15));

		store.updateEndOfDay(); // sellin 0 quality 14
		store.updateEndOfDay(); // SellIn -1 quality 12

		List<Item> items = store.getItems();
		Item elixir = items.get(0);

		assertEquals("Quality didn't go down twice after sell by date", elixir.getQuality(), 12);
	}

	@Test
	public void testUpdateEndOfDay_agedBrieQualityDoesntIncreaseThan50() {

		store.addItem(new Item("Aged Brie", 5, 49));

		store.updateEndOfDay(); // sellin 4 quality 50
		store.updateEndOfDay(); // SellIn 3 quality 50

		List<Item> items = store.getItems();
		Item brie = items.get(0);

		assertEquals("Aged Brie Quality increased more than 50", brie.getQuality(), 50);
	}

	@Test
	public void testUpdateEndOfDay_backstagePassQualityDoesntIncreaseThan50() {

		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));

		store.updateEndOfDay(); // sellin 4 quality 50
		store.updateEndOfDay(); // SellIn 3 quality 50

		List<Item> items = store.getItems();
		Item tickets = items.get(0);

		assertEquals("Ticket Quality increased more than 50", tickets.getQuality(), 50);
	}

	@Test
	public void testUpdateEndOfDay_sulfurasDoesntDecreaseInQuality() {

		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));

		store.updateEndOfDay(); // sellin 0 quality 80

		List<Item> items = store.getItems();
		Item sulfuras = items.get(0);

		assertEquals("Sulfuras quality changed", sulfuras.getQuality(), 80);
	}

	@Test
	public void testUpdateEndOfDay_backstagePassIncreaseQuality() {

		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 20, 30));

		store.updateEndOfDay(); // sellin 19 quality 31

		List<Item> items = store.getItems();
		Item ticket = items.get(0);

		assertEquals("Backstage pass quality didnt increase", ticket.getQuality(), 31);
	}

	@Test
	public void testUpdateEndOfDay_AgedBrie_SellIn_2_10() {
		// Arrange
		store.addItem(new Item("Aged Brie", 2, 10));
		// Act
		store.updateEndOfDay();
		// Assert
		int sellIn = store.getItems().get(0).getSellIn();
		String failMessage = "SellIn date decreases";
		assertEquals(failMessage, 1, sellIn);
	}

	@Test
	public void testUpdateEndOfDay_AgedBrie_SellIn_1_10() {
		// Arrange
		store.addItem(new Item("Aged Brie", 1, 10));
		// Act
		store.updateEndOfDay();
		// Assert
		int sellIn = store.getItems().get(0).getSellIn();
		String failMessage = "SellIn date decreases";
		assertEquals(failMessage, 0, sellIn);
	}

	public void testUpdateEndOfDay_AgedBrie_SellIn_0_10() {
		// Arrange
		store.addItem(new Item("Aged Brie", 0, 10));
		// Act
		store.updateEndOfDay();
		// Assert
		int sellIn = store.getItems().get(0).getSellIn();
		String failMessage = "SellIn date decreases";
		assertEquals(failMessage, -1, sellIn);
	}

	// Test Sulfuras
	@Test
	public void testUpdateEndOfDay_Sulfuras_Quality_0_80() {
		// Arrange
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "Quality of Sulfuras is 80 and never alters";
		assertEquals(failMessage, 80, quality);
	}

	@Test
	public void testUpdateEndOfDay_Sulfuras_SellIn_5_80() {
		// Arrange
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 5, 80));
		// Act
		store.updateEndOfDay();
		// Assert
		int sellIn = store.getItems().get(0).getSellIn();
		String failMessage = "Sulfuras, being a legendary item, never has to be sold";
		assertEquals(failMessage, 5, sellIn);
	}

	@Test
	public void testUpdateEndOfDay_Backstage_Quality_10_20() {
		// Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "Quality of Backstage pass increases by 2 when	there are 10 or less days";
		assertEquals(failMessage, 22, quality);
	}

	@Test
	public void testUpdateEndOfDay_Backstage_Quality_8_20() {
		// Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 8, 20));
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "Quality of Backstage pass increases by 2 when	there are 10 or less days";
		assertEquals(failMessage, 22, quality);
	}

	@Test
	public void testUpdateEndOfDay_Backstage_Quality_5_20() {
		// Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "Quality of Backstage pass increases by 3 when	there are 5 or less days";
		assertEquals(failMessage, 23, quality);
	}

	@Test
	public void testUpdateEndOfDay_Backstage_Quality_3_20() {
		// Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20));
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "Quality of Backstage pass increases by 3 when	there are 5 or less days";
		assertEquals(failMessage, 23, quality);
	}

	@Test
	public void testUpdateEndOfDay_Backstage_Quality_0_20() {
		// Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "Quality of Backstage drops to 0 after the	concert";
		assertEquals(failMessage, 0, quality);
	}

	@Test
	public void testUpdateEndOfDay_Backstage_Quality_15_50() {
		// Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50));
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "The Quality of an item is never more than 50";
		assertEquals(failMessage, 50, quality);
	}

	@Test
	public void testUpdateEndOfDay_Backstage_SellIn_5_10() {
		// Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10));
		// Act
		store.updateEndOfDay();
		// Assert
		int sellIn = store.getItems().get(0).getSellIn();
		String failMessage = "The SellIn value should decrease by 1";
		assertEquals(failMessage, 4, sellIn);
	}

	// Test Elixir
	@Test
	public void testUpdateEndOfDay_Elixir_Quality_2_7() {
		// Arrange
		store.addItem(new Item("Elixir of the Mongoose", 2, 7));
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "Quality decreases by 1";
		assertEquals(failMessage, 6, quality);
	}

	@Test
	public void testUpdateEndOfDay_SellIn_Quality_2_7() {
		// Arrange
		store.addItem(new Item("Elixir of the Mongoose", 2, 7));
		// Act
		store.updateEndOfDay();
		// Assert
		int sellIn = store.getItems().get(0).getSellIn();
		String failMessage = "SelIn decreases by 1";
		assertEquals(failMessage, 1, sellIn);
	}
}
