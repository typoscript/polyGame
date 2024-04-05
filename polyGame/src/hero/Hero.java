package hero;

import java.util.List;

import item.ItemArmor;
import item.ItemUsable;
import item.ItemWeapon;
import main.Unit;

public abstract class Hero extends Unit {
	protected int level = 1;
	protected int exp = 0;
	protected int expMax = 100;

	protected boolean hasParty;
	protected ItemWeapon weapon;
	protected ItemArmor armor;
	protected List<ItemUsable> usableItems;
	
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
	}

	public void equipItem(ItemArmor armor) {
		this.armor = armor;
	}
	
	public ItemWeapon unEquipWeapon() {
		ItemWeapon weapon = ((ItemWeapon)this.weapon).clone();
		
		this.weapon = null;
		
		return weapon;
	}

	public ItemArmor unEquipArmor() {
		ItemArmor armor = ((ItemArmor)this.armor).clone();

		this.armor = null;

		return armor;
	}
	
	public String getStatusOfWearables() {
		String statusWeapon = hasWeapon() ? "있음" : "없음";
		String statusArmor = hasArmor() ? "있음" : "없음";

		return String.format("무기: %s | 방어구: %s\n", statusWeapon, statusArmor);
	}
	
	public void joinParty() {
		this.hasParty = true;
	}

	public void quitParty() {
		this.hasParty = false;
	}

	abstract public void attack(Unit target);
}
