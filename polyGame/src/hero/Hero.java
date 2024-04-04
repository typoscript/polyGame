package hero;

import java.util.List;

import item.Armor;
import item.ItemUsable;
import item.Weapon;
import main.Unit;

public abstract class Hero extends Unit {
	protected int level = 1;
	protected int exp = 0;
	protected int expMax = 100;
	protected int expExtraGainPercentage = 10;

	protected boolean hasParty;
	protected Weapon weapon;
	protected Armor armor;
	protected List<ItemUsable> usableItems;
	
	public void increaseExpGain() {
		expExtraGainPercentage *= 1.1;
	}
	
	public boolean hasWeapon() {
		return weapon != null;
	}

	public boolean hasArmor() {
		return armor != null;
	}
	
	public void equipItem(Weapon weapon) {
		this.weapon = weapon;
	}

	public void equipItem(Armor armor) {
		this.armor = armor;
	}
	
	public String getStatusOfWearables() {
		String statusWeapon = weapon == null ? "없음" : "있음";
		String statusArmor = armor == null ? "없음" : "있음";

		return String.format("무기: %s | 방어구: %s\n", statusWeapon, statusArmor);
	}

	abstract public void attack(Unit target);
}
