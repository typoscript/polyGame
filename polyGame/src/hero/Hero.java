package hero;

import item.Armor;
import item.ItemUsable;
import item.Weapon;
import main.Unit;

public abstract class Hero extends Unit {
	protected int level = 1;
	protected int exp = 0;
	protected int expMax = 100;

	protected boolean hasParty;
	protected Weapon weapon;
	protected Armor armor;
	protected ItemUsable[] usableItems;
	
	abstract public void attack(Unit target);
}
