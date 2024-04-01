package monsters;

import main.Unit;

public class Orc extends Unit {
	private final int INIT_ATTACK_POWER = 30;
	private final int INIT_MAX_HP = 300;

	public Orc() {
		this.name = "오크";
		this.hp = INIT_MAX_HP;
		this.maxHp = INIT_MAX_HP;
		this.attackPower = INIT_ATTACK_POWER;
	}
	
	@Override
	public void attack(Unit target) {
		attackWithDoubleOrZeroAttackPower(target);
	}
	
	public void attackWithDoubleOrZeroAttackPower(Unit target) {
		boolean shouldDouble = (int)(Math.random() * 2) == 1;
	
		int attackPower = shouldDouble ? this.attackPower * 2 : 0;
		
		target.decreaseHp(attackPower);

		System.out.printf("철퇴 공격 ([%d] 데미지)\n", attackPower);
	}

}
