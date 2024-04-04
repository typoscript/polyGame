package guild;

import java.util.ArrayList;
import java.util.List;

import hero.Hero;
import item.Armor;
import item.Item;
import item.Weapon;
import main.Input;
import main.Player;
import main.Print;

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
					runItemEquip();
					break;
				case MENU_ITEM_UNEQUIP:
					break;
				case MENU_GO_BACK:
					return;
			}
		}
	}
	
	private void runItemEquip() {
		Print.printListWithListNumber(items);
		int itemIndex = Input.getInputNumber("아이템 숫자") - 1;
		
		if (items.size() == 0) {
			System.out.println("아이템이 없습니다");
			return;
		}
		
		if (itemIndex < 0 || itemIndex >= items.size()) {
			System.out.println("잘못된 숫자입니다");
			return;
		}
		
		List<Hero> members = Player.guild.getMemberAll();

		System.out.println("=== 리스트 ===");
		for (int i = 0; i < members.size(); i++)
			System.out.printf("%d. %s\n", i + 1, members.get(i).getStatusOfWearables());
		System.out.println("============");
		
		int memberIndex = Input.getInputNumber("아이템 숫자") - 1;
		
		if (memberIndex < 0 || memberIndex >= members.size()) {
			System.out.println("잘못된 숫자입니다");
			return;
		}
		
		Item item = items.get(itemIndex);
		Hero member = members.get(memberIndex);
		
		if (item instanceof Weapon) {
			member.equipItem((Weapon)item);
		} else if (item instanceof Armor) {
			member.equipItem((Armor)item);
		}
		
		System.out.println("착용 성공");
	}
	
	private void printMenu() {
		System.out.println("=== 인벤토리 ===");
		System.out.println("1) 착용");
		System.out.println("2) 벗기");
		System.out.println("0) 뒤로가기");
	}
}
