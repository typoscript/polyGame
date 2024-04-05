package monster;

import main.Unit;

public class Orc extends Unit {
	public Orc() {
		name = "오크";
		maxHp = 300;
		hp = maxHp;
		attackPower = 30;
	}
	
	@Override
	public void attack(Unit target) {
		attackWithDoubleOrZeroAttackPower(target);
	}
	
	public void attackWithDoubleOrZeroAttackPower(Unit target) {
		boolean shouldDouble = (int)(Math.random() * 2) == 1;
	
		int attackPower = shouldDouble ? this.attackPower * 2 : 0;
		
		target.decreaseHp(attackPower);

		System.out.printf("%s에게 철퇴 공격 ([%d] 데미지)\n", target.getName(), attackPower);
		System.out.println(target);
	}

}
