package item;

import main.Unit;

public abstract class ItemUse extends Item {
	public ItemUse(String name, int price, int stat) {
		super(name, price, stat);
	}

	public void use(Unit target) { }
	
	@Override
	abstract public String toString();
}