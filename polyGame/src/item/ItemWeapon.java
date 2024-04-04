package item;

public class ItemWeapon extends Item implements Weapon {
	final int ATTACK_POWER;

	public ItemWeapon(String name, int price, int attackPower) {
		super(name, price);
		this.ATTACK_POWER = attackPower;
	}
	
	@Override
	public ItemWeapon clone() {
		return new ItemWeapon(NAME, PRICE, ATTACK_POWER);
	}
	
	@Override
	public String toString() {
		return String.format("무기: %s | 가격: %d | 공격력: %d", NAME, PRICE, ATTACK_POWER);
	}
}
