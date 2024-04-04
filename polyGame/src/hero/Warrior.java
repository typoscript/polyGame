package hero;

import main.Input;
import main.Unit;

public class Warrior extends Unit implements Actionable {
	public Warrior() {
		name = "전사";
		maxHp = 200;
		hp = maxHp;
		attackPower = 30;
	}
	
	@Override
	public void attack(Unit target) {
		target.decreaseHp(attackPower);

		System.out.printf("%s에게 몸둥이 공격 ([%d] 데미지)\n", target.getName(), attackPower);
		System.out.println(target);
	}

	@Override
	public void chooseAction(Unit target) {
		final int ATTACK = 1;

		if (isSilent()) {
			handleSilence();
			return;
		}
		
		while (true) {
			System.out.printf("[%s] 1) 공격\n", name);
			int action = Input.getInputNumber("메뉴");
			
			switch (action) {
				case ATTACK:
					attack(target);
					return;
			}
		}
		
	}

	@Override
	public void chooseAction(Unit firstTarget, Unit secondTarget) { }
}