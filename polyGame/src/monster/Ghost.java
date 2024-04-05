package monsters;

import main.Unit;
import main.UnitStatus;

public class Ghost extends Unit {
	public Ghost() {
		name = "유령";
		maxHp = 50;
		hp = maxHp;
		attackPower = 0;
	}
	
	@Override
	public void attack(Unit target) {
		silenceTarget(target);
	}
	
	public void silenceTarget(Unit target) {
		target.setStatus(UnitStatus.SILENT);

		System.out.printf("%s 1턴 침묵\n", target.getName());
	}
}