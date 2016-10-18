package fi.oulu.tol.sqat;

public class Item {
	private static final int INCREMENT_VALUE = 1;
	private static final int DECREMENT_VALUE = 1;
	private static final int MINIMUM_SELL_IN = 0;
	private static final int MINIMUM_QUALITY = 0;
	private static final int MAXIMUM_QUALITY = 50;
	String name;
	int sellIn;
	int quality;

	public Item(String name, int sellIn, int quality) {
		this.setName(name);
		this.setSellIn(sellIn);
		this.setQuality(quality);
	}

	/* Generated getter and setter code */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSellIn() {
		return sellIn;
	}

	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public void increaseQuality() {
		if (!hasReachedMaximumQuality()) {
			this.quality = this.quality + INCREMENT_VALUE;
		}
	}

	public void decreaseQuality() {
		if (!hasZeroQuality()) {
			this.quality = this.quality - DECREMENT_VALUE;
		}
	}

	public void decreaseSellIn() {
		this.sellIn = this.sellIn - DECREMENT_VALUE;
	}

	public boolean hasZeroQuality() {
		if (this.quality == MINIMUM_QUALITY)
			return true;
		return false;
	}

	public boolean hasReachedMaximumQuality() {
		if (this.quality == MAXIMUM_QUALITY)
			return true;
		return false;
	}

	public boolean isExpired() {
		if (this.sellIn < MINIMUM_SELL_IN)
			return true;
		return false;
	}
}
