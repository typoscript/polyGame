package monsters;

import main.Unit;

public class Mushroom extends Unit {
	private final int INIT_ATTACK_POWER = 10;
	private final int INIT_MAX_HP = 400;

	public Mushroom() {
		this.name = "버섯";
		this.hp = INIT_MAX_HP;
		this.maxHp = INIT_MAX_HP;
		this.attackPower = INIT_ATTACK_POWER;
	}
	
	@Override
	public void attack(Unit target) {
		target.decreaseHp(attackPower);

		System.out.printf("뭉개기 공격 ([%d] 데미지)\n", attackPower);
	}
}
