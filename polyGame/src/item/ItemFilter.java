package item;

import java.util.ArrayList;
import java.util.List;

public class ItemFilter {
	public static final Class<ItemWeapon> WEAPON = ItemWeapon.class;
	public static final Class<ItemArmor> ARMOR = ItemArmor.class;
	public static final Class<ItemUse> USEABLE = ItemUse.class;
	
	public static List<Item> filter(Class<?> type, List<Item> items) {
		List<Item> filteredItems = new ArrayList<Item>();

		for (Item item : items) {
			if (type.isInstance(item))
				filteredItems.add(item);
		}

		return filteredItems;
	}
}
