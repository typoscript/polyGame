package hero;

import main.GameManager;
import main.Unit;
import main.UnitStatus;

public class Healer extends Unit implements Actionable {
	private final int INIT_ATTACK_POWER = 10;
	private final int INIT_HEAL_POWER = 10;
	private final int INIT_MAX_HP = 150;
	
	private int healPower;

	public Healer() {
		this.name = "의사";
		this.hp = INIT_MAX_HP;
		this.maxHp = INIT_MAX_HP;
		this.attackPower = INIT_ATTACK_POWER;
		this.healPower = INIT_HEAL_POWER;
	}
	
	@Override
	public void attack(Unit target) {
		target.decreaseHp(attackPower);

		System.out.printf("%s에게 주사 공격 ([%d] 데미지)\n", target.getName(), attackPower);
		System.out.println(target);
	}
	
	public void heal(Unit target) {
		target.increaseHp(healPower);
		
		System.out.printf("%s에게 치료 ([%d]hp 회복)\n", target.getName(), healPower);
	}

	@Override
	public void chooseAction(Unit target) {
	}

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
			System.out.print("메뉴: ");
			
			int action = GameManager.sc.nextInt();
			
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
