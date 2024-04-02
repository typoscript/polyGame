package hero;

import main.GameManager;
import main.Unit;

public class Warrior extends Unit implements Actionable {
	private final int INIT_ATTACK_POWER = 30;
	private final int INIT_MAX_HP = 200;

	public Warrior() {
		this.name = "전사";
		this.hp = INIT_MAX_HP;
		this.maxHp = INIT_MAX_HP;
		this.attackPower = INIT_ATTACK_POWER;
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
		
		while (true) {
			System.out.printf("[%s] 1) 공격\n", name);
			System.out.print("메뉴: ");

			int action = GameManager.sc.nextInt();
			
			switch (action) {
				case ATTACK:
					attack(target);
					return;
			}
		}
		
	}

	@Override
	public void chooseAction(Unit firstTarget, Unit secondTarget) {
	}
}