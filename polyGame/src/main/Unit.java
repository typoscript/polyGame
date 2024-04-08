package main;

public abstract class Unit {
	protected int hp;
	protected int maxHp;
	protected int attackPower;
	protected int armorPower;
	protected String name;
	protected UnitStatus status = UnitStatus.NORMAL;
	
	public int getHp() {
		return hp;
	}

	public int getMaxHp() {
		return maxHp;
	}
	
	public int getAttackPower() {
		return attackPower;
	}

	public int getArmorPower() {
		return armorPower;
	}
	
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
		hp -= armorPower;

		if (hp < 0)
			hp = 0;

		this.hp -= hp;
		
		if (this.hp < 0) {
			status = UnitStatus.DEAD;
			this.hp = 0;
		}
	}
	
	public void increaseHp(int hp) {
		this.hp += hp;
		
		if (this.hp > maxHp)
			this.hp = maxHp;
	}
	
	public boolean isDead() {
		return hp == 0;
	}
	
	public boolean isSilent() {
		return status == UnitStatus.SILENT;
	}
	
	public void handleSilence() {
		System.out.printf("%s는 침묵으로 이번 턴 실행 불가능\n", name);
		status = UnitStatus.NORMAL;
	}
	
	@Override
	public String toString() {
		return String.format("%s | HP: %d | 공격력: %d | 방어력: %d | 상태: %s", name, hp, attackPower, armorPower, status);
	}

	abstract public void attack(Unit target);
}
