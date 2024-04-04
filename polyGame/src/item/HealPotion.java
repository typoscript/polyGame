package item;

import main.Unit;

public class HealPotion extends Item implements ItemUsable {
	public final int healAmount = 30;

	public HealPotion() {
		super("회복약", 1000);
	}

	@Override
	public void use(Unit target) {
		target.increaseHp(healAmount);
	}
}
