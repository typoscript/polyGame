package item;

public class ItemArmor extends Item implements Armor {
	final int ARMOR;

	public ItemArmor(String name, int price, int armor) {
		super(name, price);
		this.ARMOR = armor;
	}
}