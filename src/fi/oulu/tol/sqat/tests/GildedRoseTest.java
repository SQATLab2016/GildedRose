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

	private final int MAX_QUALITY = 50;
	private GildedRose store;

	@Before
	public void setup() {
		store = new GildedRose();
	}

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

	//@Test
	//public void xUpdates(int x) {
	//}

	private Item nthItem(int n) {
		List<Item> items = store.getItems();
		return items.get(n);
	}

	@Test
	public void itemDegradeTest() {
		int updates = 200;
		store.addItem(new Item("Broadsword",updates,updates));

		for (int i = updates; i >= 0; i--) {
			Item sword = nthItem(0);
			assertEquals("Quality of normal item did not degrade correctly", i, sword.getQuality());
			store.updateEndOfDay();
		}
	}

	@Test
	public void qualityIncreasedAndStaysUnderFifty() {
		store.addItem(new Item("Aged Brie", 5, 45));

		for (int i = 50; i >= 0; i--) {
			Item brie = nthItem(0);
			assertTrue("Quality of aged brie was over " + MAX_QUALITY, brie.getQuality() <= MAX_QUALITY);
			store.updateEndOfDay();
		}
	}

	@Test
	public void qualityTooMuchInCreation() {
		store.addItem(new Item("Leather quiver", 22, 55));
		Item quiver = nthItem(0);
		assertTrue("Item quality is: " + quiver.getQuality() + ", over max quality: " + MAX_QUALITY,
				quiver.getQuality() <= MAX_QUALITY);
	}

	@Test
	public void agedBrieQualityRising() {
		store.addItem(new Item("Aged Brie", 5, 3));

		for (int i = 15; i >= 0; i--) {
			Item brie = nthItem(0);
			int earlier_brie_quality = brie.getQuality();
			store.updateEndOfDay();
			assertTrue("Brie quality did not rise after end of day", earlier_brie_quality < brie.getQuality());
		}
	}

	@Test
	public void sellInDecreasesByOne() {
		store.addItem(new Item("Oak staff", 100, 8));
		store.addItem(new Item("Bronze dagger", 500, 3));
		store.addItem(new Item("Spiked maul of divine retribution", 250, 44));
		store.addItem(new Item("Elven boots", 300, 15));

		int[] prevSellIn = new int[4];

		for (int i = 100; i >= 0; i--) {
			List<Item> allItems = store.getItems();
			for (int k = 0; k < allItems.size(); k++) {
				prevSellIn[k] = allItems.get(k).getSellIn();
			}
			store.updateEndOfDay();
			for (int k = 0; k < allItems.size(); k++) {
				assertEquals("Item number " + k + "sell in did not decrease by 1",
						prevSellIn[k] - 1,allItems.get(k).getSellIn()); 
			}
		}
	}
}
