package main;

public abstract class Unit {
	protected int hp;
	protected int maxHp;
	protected int attackPower;
	protected String name;
	
	public Unit(String name, int hp, int maxHp, int attackPower) {
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.attackPower = attackPower;
	}
	
	public void decreaseHp(int hp) {
		this.hp -= hp;
		
		if (hp < 0)
			hp = 0;
	}
	
	public void increaseHp(int hp) {
		this.hp += hp;
		
		if (hp > maxHp)
			hp = maxHp;
	}
	
	public boolean isDead() {
		return hp == 0;
	}
	
	abstract public void attack(Unit target);
}
