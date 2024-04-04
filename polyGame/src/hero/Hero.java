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
	
	abstract public void attack(Unit target);
}
