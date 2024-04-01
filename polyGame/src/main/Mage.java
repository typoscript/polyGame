package main;

public class Mage extends Unit {
	private final int INIT_ATTACK_POWER = 20;
	private final int INIT_MAX_HP = 100;

	public Mage() {
		this.name = "마법사";
		this.hp = INIT_MAX_HP;
		this.maxHp = INIT_MAX_HP;
		this.attackPower = INIT_ATTACK_POWER;
	}
	
	public void attack(Unit target) {
		target.decreaseHp(attackPower);

		System.out.printf("지팡이 공격 ([%d] 데미지)\n", attackPower);
	}
	
	public void increaseAttackPower() {
		int attackPower = (int)(Math.random() * 30);

		this.attackPower += attackPower;
		
		System.out.printf("공격력 추가 상승 (+%d)", attackPower);
	}
}
