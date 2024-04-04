package guild;

import java.util.ArrayList;
import java.util.List;

import item.Item;
import main.Input;

public class Inventory {
	private final int MENU_ITEM_EQUIP = 1;
	private final int MENU_ITEM_UNEQUIP = 2;
	private final int MENU_GO_BACK = 0;
	List<Item> items = new ArrayList<Item>();
	
	public List<Item> getItemAll() {
		return items;
	}

	public boolean hasItem(Item item) {
		return items.contains(item);
	}

	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeItem(Item item) {
		items.remove(item);
	}
	
	public void run() {
		while (true) {
			printMenu();
			
			int menu = Input.getInputNumber("메뉴");
			
			switch (menu) {
				case MENU_ITEM_EQUIP:
					break;
				case MENU_ITEM_UNEQUIP:
					break;
				case MENU_GO_BACK:
					return;
			}
		}
	}
	
	private void printMenu() {
		System.out.println("=== 인벤토리 ===");
		System.out.println("1) 착용");
		System.out.println("2) 벗기");
		System.out.println("0) 뒤로가기");
	}
}
