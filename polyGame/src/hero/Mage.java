package hero;

import main.Input;
import main.Unit;

public class Mage extends Unit implements Actionable {
	public Mage() {
		name = "마법사";
		maxHp = 100;
		hp = maxHp;
		attackPower = 20;
	}
	
	public void increaseAttackPower() {
		this.attackPower += getRandomAttackPower();
		
		System.out.printf("공격력 추가 상승 (+%d)\n", attackPower);
	}
	
	public int getRandomAttackPower() {
		return (int)(Math.random() * 30);
	}

	@Override
	public void attack(Unit target) {
		target.decreaseHp(attackPower);

		System.out.printf("%s에게 지팡이 공격 ([%d] 데미지)\n", target.getName(), attackPower);
		System.out.println(target);
	}
	

	@Override
	public void chooseAction(Unit target) {
		final int ATTACK = 1;
		final int SKILL = 2;

		if (isSilent()) {
			handleSilence();
			return;
		}
		
		while (true) {
			System.out.printf("[%s] 1) 공격 2) 공격력 증가 스킬\n", name);
			int action = Input.getInputNumber("메뉴");
			
			switch (action) {
				case ATTACK:
					attack(target);
					return;
				case SKILL:
					increaseAttackPower();
					return;
			}
		}
		
	}

	@Override
	public void chooseAction(Unit firstTarget, Unit secondTarget) { }
}
