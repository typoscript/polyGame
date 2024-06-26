package hero;

import item.ItemArmor;
import item.ItemWeapon;
import main.Unit;
import main.UnitStatus;

public abstract class Hero extends Unit {
	protected int level = 1;
	protected int exp = 0;
	protected final int EXP_MAX = 100;

	protected boolean hasParty;
	protected ItemWeapon weapon;
	protected ItemArmor armor;
	
	public Hero() { }
	
	public Hero(String name, int level, int hp, int maxHp, int attackPower, int armorPower, int exp, UnitStatus status, boolean hasParty, ItemWeapon weapon, ItemArmor armor) {
		this.name = name;
		this.level = level;
		this.hp = hp;
		this.maxHp = maxHp;
		this.attackPower = attackPower;
		this.armorPower = armorPower;
		this.status = status;
		this.hasParty = hasParty;
		this.weapon = weapon;
		this.armor = armor;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getExp() {
		return exp;
	}
	
	public ItemWeapon getWeapon() {
		return weapon;
	}

	public ItemArmor getArmor() {
		return armor;
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
		exp = 0;
	}
	
	public void increaseExp(int exp) {
		this.exp += exp;
		
		if (this.exp >= EXP_MAX)
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
