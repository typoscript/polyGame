package monsters;

import main.Unit;
import main.UnitStatus;

public class Ghost extends Unit {
	private final int INIT_ATTACK_POWER = 0;
	private final int INIT_MAX_HP = 50;

	public Ghost() {
		this.name = "유령";
		this.hp = INIT_MAX_HP;
		this.maxHp = INIT_MAX_HP;
		this.attackPower = INIT_ATTACK_POWER;
	}
	
	@Override
	public void attack(Unit target) {
		silentTarget(target);
	}
	
	public void silentTarget(Unit target) {
		target.setStatus(UnitStatus.SILENT);

		System.out.printf("%s 1턴 침묵\n", target.getName());
	}
}