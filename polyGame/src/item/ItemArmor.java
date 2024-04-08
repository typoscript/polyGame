package item;

public class ItemArmor extends Item { 
	public final int ARMOR_POWER;

	public ItemArmor(String name, int price, int armor) {
		super(name, price);
		this.ARMOR_POWER = armor;
	}

	@Override
	public ItemArmor clone() {
		return new ItemArmor(NAME, PRICE, ARMOR_POWER);
	}

	@Override
	public String toString() {
		return String.format("방어구: %s | 가격: %d | 방어력: %d", NAME, PRICE, ARMOR_POWER);
	}
}