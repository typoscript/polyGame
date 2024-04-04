package item;

public class ItemWeapon extends Item implements Weapon {
	final int ATTACK_POWER;

	public ItemWeapon(String name, int price, int attackPower) {
		super(name, price);
		this.ATTACK_POWER = attackPower;
	}
}
