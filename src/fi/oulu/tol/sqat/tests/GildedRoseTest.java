package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	// Example scenarios for testing


	@Test
	public void testTheTruth() {
		assertTrue(true);
	}

	GildedRose store = new GildedRose();

	@Test
	public void testUpdateQuality_AgedBrie_3_10() {
		//Arrange
		store.addItem(new Item("Aged Brie", 3, 10));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Quality of Aged Brie increases"	;
		assertEquals(failMessage, 11, quality);

	}
	@Test
	public void testUpdateQuality_AgedBrie_sellIn_2_20() {
		//Arrange
		store.addItem(new Item("Aged Brie", 2, 20));
		//Act
		store.updateEndOfDay();
		//Assert
		int	sellIn	= store.getItems().get(0).getSellIn();
		String 	failMessage	="AgedBrie sellIn decreases";
		assertEquals(failMessage, 1, sellIn);
	}

	@Test
	public void testUpdateQuality_AgedBrie_3_50() {
		//Arrange
		store.addItem(new Item("Aged Brie", 3, 50));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Quality of Aged is in its max"	;
		assertEquals(failMessage, 50, quality);
	}
	
	@Test
	public void testUpdateQuality_AgedBrie_49() {
		//Arrange
		store.addItem(new Item("Aged Brie", -5, 49));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Quality of Aged increases to the maximum"	;
		assertEquals(failMessage, 50, quality);
	}
	
	@Test
	public void testUpdateQuality_AgedBrie_negativeone_0() {
		//Arrange
		store.addItem(new Item("Aged Brie", -1, 0));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Quality of Aged Brie increases twice after SellIn date"	;
		assertEquals(failMessage, 2, quality);
	}
	
	@Test
	public void testUpdateQuality_AgedBrie_aftersellin_50() {
		//Arrange
		store.addItem(new Item("Aged Brie", -20, 50));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Quality of Aged Brie is in max"	;
		assertEquals(failMessage, 50, quality);
	}

	@Test
	public void testUpdateQuality_Sulfuras_5_80() {
		//Arrange
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 5, 80));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Sulfuras, Hand of Ragnaros quality stays always the same"	;
		assertEquals(failMessage, 80, quality);
	}

	@Test
	public void testUpdateQuality_Sulfuras_SellIn() {
		//Arrange
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 1, 80));
		//Act
		store.updateEndOfDay();
		//Assert
		int	sellIn	= store.getItems().get(0).getSellIn();
		String 	failMessage	="Sulfuras, Hand of Ragnaros never has to be sold"	;
		assertEquals(failMessage, 1, sellIn);
	}
	
	@Test
	public void testUpdateQuality_Sulfuras_SellIn_negative() {
		//Arrange
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
		//Act
		store.updateEndOfDay();
		//Assert
		int	sellIn	= store.getItems().get(0).getSellIn();
		String 	failMessage	="Sulfuras, Hand of Ragnaros never has to be sold"	;
		assertEquals(failMessage, -1, sellIn);
	}
	
	@Test
	public void testUpdateQuality_Sulfuras_SellIn_zero() {
		//Arrange
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		//Act
		store.updateEndOfDay();
		//Assert
		int	sellIn	= store.getItems().get(0).getSellIn();
		String 	failMessage	="Sulfuras, Hand of Ragnaros never has to be sold"	;
		assertEquals(failMessage, 0, sellIn);
	}
	
	@Test
	public void testUpdateQuality_Backstage_49_quality_to_zero() {
		//Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Backstage passes drops to zero when SellIn"	;
		assertEquals(failMessage, 0, quality);
	}
	
	@Test
	public void testUpdateQuality_Backstage_20_49() {
		//Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 20, 49));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Backstage passes increasess to the maximum"	;
		assertEquals(failMessage, 50, quality);
	}

	@Test
	public void testUpdateQuality_Backstage_3_0() {
		//Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 3, 0));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Backstage passes quality increasess three times"	;
		assertEquals(failMessage, 3, quality);
	}
	
	@Test
	public void testUpdateQuality_Backstage_quality_increase_twice_6_0() {
		//Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 0));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Backstage passes quality increasess twice"	;
		assertEquals(failMessage, 2, quality);
	}
	
	@Test
	public void testUpdateQuality_Backstage_quality_increase_twice_conditional_11_0() {
		//Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 2));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Backstage passes quality increasess twice"	;
		assertEquals(failMessage, 3, quality);
	}
	
	@Test
	public void testUpdateQuality_Backstage_quality_increase_twice_conditional_11_50() {
		//Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Backstage passes quality increasess twice"	;
		assertEquals(failMessage, 50, quality);
	}
	@Test
	public void testUpdateQuality_Backstage_quality_max() {
		//Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 50));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Backstage passes quality max"	;
		assertEquals(failMessage, 50, quality);
	}

	@Test
	public void testUpdateQuality_Bacckstage_quality_max_sellin() {
		//Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Backstage passes quality max"	;
		assertEquals(failMessage, 50, quality);
	}
	
	@Test
	public void testUpdateQuality_Bacckstags_sellIn_3_0() {
		//Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 3, 0));
		//Act
		store.updateEndOfDay();
		//Assert
		int	sellIn	= store.getItems().get(0).getSellIn();
		String 	failMessage	="Backstage passes sellIn date decreases"	;
		assertEquals(failMessage, 2, sellIn);
	}
	
	@Test
	public void testUpdateQuality_Bacckstags_sellIn_minus3_0() {
		//Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", -3, 0));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Backstage passes quality is zero"	;
		assertEquals(failMessage, 0, quality);
	}
	
	@Test
	public void testUpdateQuality_Elixir_1_23() {
		//Arrange
		store.addItem(new Item("Elixir of the Mongoose", 1, 23));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Elixir quality decreases"	;
		assertEquals(failMessage, 22, quality);
	}
	
	@Test
	public void testUpdateQuality_Elixir_quality_after_sellIn() {
		//Arrange
		store.addItem(new Item("Elixir of the Mongoose", -5, 5));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Elixir quality decreases twice"	;
		assertEquals(failMessage, 3, quality);
	}
	
	@Test
	public void testUpdateQuality_Elixir_quality_zero() {
		//Arrange
		store.addItem(new Item("Elixir of the Mongoose", -5, 0));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Elixir quality stays zero"	;
		assertEquals(failMessage, 0, quality);
	}
	
	@Test
	public void testUpdateQuality_Elixir_sellIn() {
		//Arrange
		store.addItem(new Item("Elixir of the Mongoose", -5, 0));
		//Act
		store.updateEndOfDay();
		//Assert
		int	sellIn	= store.getItems().get(0).getSellIn();
		String 	failMessage	="Elixir sellIn decreases"	;
		assertEquals(failMessage, -6, sellIn);
	}
	
	@Test
	public void testUpdateQuality_Elixir_quality_decreases() {
		//Arrange
		store.addItem(new Item("Elixir of the Mongoose", 5, 10));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Elixir quality decreases once"	;
		assertEquals(failMessage, 9, quality);
	}
	
	@Test
	public void testUpdateQuality_Elixir_quality_max_sellinnegative() {
		//Arrange
		store.addItem(new Item("Elixir of the Mongoose", -1, 50));
		//Act
		store.updateEndOfDay();
		//Assert
		int	quality	= store.getItems().get(0).getQuality();
		String 	failMessage	="Elixir quality decreases twice"	;
		assertEquals(failMessage, 48, quality);
	}

	

}
