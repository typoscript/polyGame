package item;

import hero.Hero;
import main.Unit;

public class ExpBooster extends Item implements Usable {
	public ExpBooster() {
		super("경험치 부스터", 5000);
	}

	@Override
	public void use(Unit target) {
		Hero hero = (Hero)target;
		hero.increaseExpGain();
	}
}