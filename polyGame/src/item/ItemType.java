package item;

public class ItemType {
	public static final String WEAPON = "WEAPON";
	public static final String ARMOR = "ARMOR";
	public static final String HP_POTION = "HP_POTION";
	
	public static String getType(Item item) {
		if (item instanceof ItemHpPotion)
			return HP_POTION;
		else if (item instanceof ItemWeapon)
			return WEAPON;
		else if (item instanceof ItemArmor)
			return ARMOR;
		
		return null;
	}
}
