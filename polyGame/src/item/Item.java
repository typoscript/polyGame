package item;

public abstract class Item {
	public final String NAME;
	public final int PRICE;
	
	public Item(String name, int price) {
		this.NAME = name;
		this.PRICE = price;
	}
}
