package main;

public class Warrior extends Unit {
	private final int INIT_ATTACK_POWER = 5;
	private final int INIT_MAX_HP = 5;

	public Warrior() {
		this.name = "전사";
		this.attackPower = INIT_ATTACK_POWER;
		this.hp = INIT_MAX_HP;
		this.maxHp = INIT_MAX_HP;
	}
}
