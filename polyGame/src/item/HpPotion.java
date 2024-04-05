package item;

import main.Unit;

public class HealPotion extends Item implements Usable {
	public final int HEAL_AMOUNT = 30;

	public HealPotion() {
		super("회복약", 1000);
	}

	@Override
	public void use(Unit target) {
		target.increaseHp(HEAL_AMOUNT);
	}
	
	@Override
	public String toString() {
		return String.format("이름: %s | 가격: %d | 회복력: %d", NAME, PRICE, HEAL_AMOUNT);
	}
}
