package hero;

import main.Unit;

public abstract class Hero extends Unit {
	protected int level = 1;
	protected int exp = 0;
	protected int expMax = 100;
	protected int armor = 0;
	
	abstract public void attack(Unit target);
}
