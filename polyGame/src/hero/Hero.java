package hero;

import item.ItemArmor;
import item.ItemWeapon;
import main.Unit;

public abstract class Hero extends Unit {
	protected int level = 1;
	protected int exp = 0;
	protected int expMax = 100;

	protected boolean hasParty;
	protected ItemWeapon weapon;
	protected ItemArmor armor;
	
	public int getLevel() {
		return level;
	}
	
	public boolean hasParty() {
		return hasParty;
	}
	
	public boolean hasWeapon() {
		return weapon != null;
	}

	public boolean hasArmor() {
		return armor != null;
	}
	
	public void equipItem(ItemWeapon weapon) {
		this.weapon = weapon;
		attackPower += weapon.ATTACK_POWER;
	}

	public void equipItem(ItemArmor armor) {
		this.armor = armor;
		armorPower += armor.ARMOR_POWER;
	}
	
	public ItemWeapon unEquipWeapon() {
		ItemWeapon weapon = ((ItemWeapon)this.weapon).clone();
		
		this.weapon = null;
		attackPower -= weapon.ATTACK_POWER;
		
		return weapon;
	}

	public ItemArmor unEquipArmor() {
		ItemArmor armor = ((ItemArmor)this.armor).clone();

		this.armor = null;
		armorPower -= armor.ARMOR_POWER;

		return armor;
	}
	
	public void levelUp() {
		level++;
		expMax *= 1.1;
		exp = 0;
	}
	
	public void increaseExp(int exp) {
		this.exp += exp;
		
		if (this.exp >= expMax)
			levelUp();
	}
	
	public String getStatusOfWearables() {
		String statusWeapon = hasWeapon() ? "있음" : "없음";
		String statusArmor = hasArmor() ? "있음" : "없음";

		return String.format("무기: %s | 방어구: %s", statusWeapon, statusArmor);
	}
	
	public void joinParty() {
		hasParty = true;
	}

	public void quitParty() {
		hasParty = false;
	}
	
	public String printBattleStatus() {
		return String.format("%s | 체력: %d | 공격력: %d | 상태: %s", name, hp, attackPower, status);
	}

	abstract public void attack(Unit target);
}
