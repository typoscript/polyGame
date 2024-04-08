package item;

public abstract class Item {
	public final String NAME;
	public final int PRICE;
	public final int STAT;
	
	public Item(String name, int price, int stat) {
		this.NAME = name;
		this.PRICE = price;
		this.STAT = stat;
	}
}
