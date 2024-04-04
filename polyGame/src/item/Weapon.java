package item;

import main.Unit;

public class WeaponUpgrader extends Item implements ItemUsable {
	public WeaponUpgrader() {
		super("무기 업그레이드", 3000);
	}

	@Override
	public void use(Unit target) {
		target.upgradeWeapon(10);
	}
}
