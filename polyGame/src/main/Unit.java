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
		
		if (this.hp < 0)
			this.hp = 0;
	}
	
	public void increaseHp(int hp) {
		this.hp += hp;
		
		if (this.hp > maxHp)
			this.hp = maxHp;
	}
	
	public boolean isDead() {
		return hp == 0;
	}
	
	public boolean canTakeAction() {
		return status == UnitStatus.NORMAL;
	}
	
	@Override
	public String toString() {
		return String.format("%s | HP: %d | 공격력: %d | 상태: %s", name, hp, attackPower, status);
	}

	abstract public void attack(Unit target);
}
