package item;

public class ItemArmor extends Item implements Armor {
	final int ARMOR;

	public ItemArmor(String name, int price, int armor) {
		super(name, price);
		this.ARMOR = armor;
	}

	@Override
	public String toString() {
		return String.format("방어구: %s | 가격: %d | 방어력: %d", NAME, PRICE, ARMOR);
	}
}