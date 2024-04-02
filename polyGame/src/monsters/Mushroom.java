package monsters;

import main.Unit;

public class Mushroom extends Unit {
	public Mushroom() {
		name = "버섯";
		maxHp = 400;
		hp = maxHp;
		attackPower = 10;
	}
	
	@Override
	public void attack(Unit target) {
		target.decreaseHp(attackPower);

		System.out.printf("%s에게 뭉개기 공격 ([%d] 데미지)\n", target.getName(), attackPower);
		System.out.println(target);
	}
}
