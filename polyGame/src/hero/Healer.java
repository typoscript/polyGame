package hero;

import main.Input;
import main.Unit;

public class Healer extends Hero implements Actionable {
	private int healPower;

	public Healer() {
		name = "의사";
		maxHp = 150;
		hp = maxHp;
		attackPower = 10;
		healPower = 10;
	}

	public void heal(Unit target) {
		target.increaseHp(healPower);
		
		System.out.printf("%s에게 치료 ([%d]hp 회복)\n", target.getName(), healPower);
	}
	
	@Override
	public void attack(Unit target) {
		target.decreaseHp(attackPower);

		System.out.printf("%s에게 주사 공격 ([%d] 데미지)\n", target.getName(), attackPower);
		System.out.println(target);
	}
	
	@Override
	public void chooseAction(Unit target) { }

	@Override
	public void chooseAction(Unit attackTarget, Unit healTarget) {
		final int ATTACK = 1;
		final int HEAL = 2;
		
		if (isSilent()) {
			handleSilence();
			return;
		}
		
		while (true) {
			System.out.printf("[%s] 1) 공격 2) 힐\n", name);
			int action = Input.getInputNumber("메뉴");
			
			switch (action) {
				case ATTACK:
					attack(attackTarget);
					return;
				case HEAL:
					heal(healTarget);
					return;
			}
		}
	}
}
