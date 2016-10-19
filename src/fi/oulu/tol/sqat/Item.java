package fi.oulu.tol.sqat;

public class Item {
	String name;
	int sellIn;
	int quality;

	public Item(String name, int sellIn, int quality) {
		this.setName(name);
		this.setSellIn(sellIn);
		this.setQuality(quality);
	}

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

	public void decreaseQuality() {
		if (this.quality > 0) {
			this.quality -= 1;
		}
	}

	public void increaseQuality() {
		if (this.quality < 50) {
			this.quality += 1;
		}
	}

	public void decreaseSellIn() {
		this.sellIn -= 1;
	}

	public boolean isExpired() {
		return (this.sellIn < 0);
	}

	public boolean hasReachedMaximumQuality() {
		return (this.quality >= 50);
	}

	public boolean hasZeroQuality() {
		return (this.quality == 0);
	}
}
