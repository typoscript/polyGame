package item;

import main.Unit;

public class ExpBooster extends Item implements ItemUsable {
	public ExpBooster() {
		super("경험치 부스터", 5000);
	}

	@Override
	public void use(Unit target) {
		target.increaseExpGain();
	}
}
