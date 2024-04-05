package guild;

import java.util.ArrayList;
import java.util.List;

import hero.Hero;
import item.Armor;
import item.Item;
import item.ItemArmor;
import item.ItemWeapon;
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
					runItemUnEquip();
					break;
				case MENU_GO_BACK:
					return;
			}
		}
	}
	
	private void runItemEquip() {
		if (items.isEmpty()) {
			System.out.println("인벤토리에 아이템이 없습니다");
			return;
		}

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
		
		int memberIndex = Input.getInputNumber("길드원의 숫자") - 1;
		
		if (memberIndex < 0 || memberIndex >= members.size()) {
			System.out.println("잘못된 숫자입니다");
			return;
		}
		
		Item item = items.get(itemIndex);
		Hero member = members.get(memberIndex);
		
		if (item instanceof Weapon) {
			if (member.hasWeapon()) {
				System.out.println("이미 무기를 착용하고있습니다");	
				return;
			}

			member.equipItem((Weapon)item);
		} else if (item instanceof Armor) {
			if (member.hasArmor()) {
				System.out.println("이미 방어구를 착용하고있습니다");	
				return;
			}

			member.equipItem((Armor)item);
		}
		
		items.remove(item);
		System.out.println("착용 성공");
	}
	
	private void runItemUnEquip() {
		List<Hero> members = Player.guild.getMemberAll();

		if (members.isEmpty()) {
			System.out.println("길드원이 없습니다");
			return;
		}

		System.out.println("=== 리스트 ===");
		for (int i = 0; i < members.size(); i++)
			System.out.printf("%d. %s\n", i + 1, members.get(i).getStatusOfWearables());
		System.out.println("============");

		int memberIndex = Input.getInputNumber("길드원의 숫자") - 1;
		
		if (memberIndex < 0 || memberIndex >= members.size()) {
			System.out.println("잘못된 숫자입니다");
			return;
		}
		
		Hero member = members.get(memberIndex);
		
		final int MENU_WEAPON = 1;
		final int MENU_ARMOR = 2;

		while (true) {
			int menu = Input.getInputNumber("벗기 1) 무기 2) 방어구");

			switch (menu) {
				case MENU_WEAPON:
					if (!member.hasWeapon()) {
						System.out.println("무기가 없습니다");
						return;
					}
					
					ItemWeapon item = member.unEquipWeapon();
					items.add(item);
					break;
				case MENU_ARMOR:
					if (!member.hasArmor())
						System.out.println("방어구가 없습니다");
						return;
					}

					ItemArmor item = member.unEquipArmor();
					items.add(item);
					break;
		}
	}
	
	private void printMenu() {
		System.out.println("=== 인벤토리 ===");
		System.out.println("1) 착용");
		System.out.println("2) 벗기");
		System.out.println("0) 뒤로가기");
	}
}
