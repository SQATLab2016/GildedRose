package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	GildedRose store = new GildedRose();

	// Test Aged Brie
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_2_10() {
		Item item1 = new Item("Aged Brie", 2, 10);
		// Arrange
		store.addItem(item1);
		// Act
		store.updateEndOfDay();
		// Assert
		Item item1AfterUpdate = store.getItem(item1);
		int quality = item1AfterUpdate.getQuality();
		String failMessage = "Quality of Aged Brie increases";
		assertEquals(failMessage, 11, quality);
	}

}
