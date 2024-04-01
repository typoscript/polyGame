package hero;

import main.Unit;

public class Warrior extends Unit {
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

		System.out.printf("몸둥이 공격 ([%d] 데미지)\n", attackPower);
	}
}