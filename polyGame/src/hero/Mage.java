package hero;

import main.GameManager;
import main.Unit;

public class Mage extends Unit implements Actionable {
	private final int INIT_ATTACK_POWER = 20;
	private final int INIT_MAX_HP = 100;

	public Mage() {
		this.name = "마법사";
		this.hp = INIT_MAX_HP;
		this.maxHp = INIT_MAX_HP;
		this.attackPower = INIT_ATTACK_POWER;
	}
	
	@Override
	public void attack(Unit target) {
		target.decreaseHp(attackPower);

		System.out.printf("%s에게 지팡이 공격 ([%d] 데미지)\n", target.getName(), attackPower);
		System.out.println(target);
	}
	
	public void increaseAttackPower() {
		this.attackPower += getRandomAttackPower();
		
		System.out.printf("공격력 추가 상승 (+%d)\n", attackPower);
	}
	
	public int getRandomAttackPower() {
		return (int)(Math.random() * 30);
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
			System.out.print("메뉴: ");
			
			int action = GameManager.sc.nextInt();
			
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
	public void chooseAction(Unit firstTarget, Unit secondTarget) {
	}
}
