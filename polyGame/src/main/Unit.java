package main;

public abstract class Unit {
	protected int hp;
	protected int maxHp;
	protected int attackPower;
	protected String name;
	protected UnitStatus status = UnitStatus.NORMAL;
	
	public String getName() {
		return name;
	}

	public UnitStatus getStatus() {
		return status;
	}
	
	public void setStatus(UnitStatus status) {
		this.status = status;
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
	
	public String toSring() {
		return String.format("%s | HP: %d | 공격력: %d | 상태: %s", name, hp, attackPower, status);
	}
}
