package item;

import main.Unit;

public class ItemUsable extends Item implements Usable {
	final int STAT;

	public ItemUsable(String name, int price, int stat) {
		super(name, price);
		this.STAT = stat;
	}

	@Override
	public void use(Unit target) { }
}
