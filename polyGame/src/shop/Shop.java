package shop;

import java.util.ArrayList;
import java.util.List;

import item.Item;
import item.ItemArmor;
import item.ItemType;
import item.ItemUsable;
import item.ItemWeapon;
import main.FileManager;
import main.Input;
import main.Player;
import main.Print;

public class Shop {
	private final int MENU_BUY_ITEM = 1;
	private final int MENU_SELL_ITEM = 2;
	private final int MENU_QUIT = 0;
	private final int MENU_GO_BACK = 0;
	
	private final int MENU_BUY_WEAPON = 1;
	private final int MENU_BUY_ARMOR = 2;
	private final int MENU_BUY_POTION = 3;
	
	private List<ItemWeapon> itemWeapons = new ArrayList<>();
	private List<ItemArmor> itemArmors = new ArrayList<>();
	private List<ItemUsable> itemUsables = new ArrayList<>();
	
	public void run() {
		loadItemsFromFile();

		while (true) {
			printMenu();
			int menu = Input.getInputNumber("메뉴");
			
			switch (menu) {
				case MENU_BUY_ITEM:
					runMenuItemBuy();
					break;
				case MENU_SELL_ITEM:
					runSellItem();
					break;
				case MENU_QUIT:
					System.out.println("상점 종료");
					return;
			}
		}
	}
	
	private void runMenuItemBuy() {
		while (true) {
			printMenuItemBuy();
			int menu = Input.getInputNumber("메뉴");
			
			switch (menu) {
				case MENU_BUY_WEAPON:
					runBuyItem(ItemType.WEAPON);
					break;
				case MENU_BUY_ARMOR:
					runBuyItem(ItemType.ARMOR);
					break;
				case MENU_BUY_POTION:
					runBuyItem(ItemType.POTION);
					break;
				case MENU_GO_BACK:
					return;
			}
		}
	}
	
	private void runBuyItem(String type) {
		List<Item> items = null;

		switch (type) {
			case ItemType.WEAPON:
				items = (List)itemWeapons;
				break;
			case ItemType.ARMOR:
				items = (List)itemArmors;
				break;
			case ItemType.POTION:
				items = (List)itemUsables;
				break;
			default:
		}
		
		if (items == null || items.size() == 0) {
			System.out.println("구매할 아이템이 없습니다");
			return;
		}
		
		Print.printListWithListNumber(items);
		
		int itemIndex = Input.getInputNumber("아이템 숫자") - 1;

		if (itemIndex < 0 || itemIndex >= items.size()) {
			System.out.println("잘못된 아이템입니다");
			return;
		}
		
		Item item = items.get(itemIndex);
		
		if (item.PRICE > Player.guild.getMoney())
			System.out.println("돈 부족으로 구매 불가");
		
		Player.guild.inventory.addItem(item);
	}

	private void runSellItem() {
		List<Item> items = Player.guild.getItemAll();
		
		if (items.isEmpty()) {
			System.out.println("길드 인벤토리에 아이템이 없습니다");
			return;
		}
		
		Print.printListWithListNumber(items);
		
		int itemIndex = Input.getInputNumber("아이템 숫자") - 1;

		if (itemIndex < 0 || itemIndex >= items.size()) {
			System.out.println("잘못된 아이템입니다");
			return;
		}
		
		Item item = items.get(itemIndex);
		int tax = Calculator.getSellingTax(item.PRICE);
		int sellingPrice = Calculator.getSellingPrice(item.PRICE);
		
		System.out.printf("%s의 구매가: %d\n양도소득세: %d\n판매가: %d\n",
				item.NAME, item.PRICE, tax, sellingPrice);
		
		while (true) {
			int menu = Input.getInputNumber("판매? 1) 예 2) 아니요");
			final int MENU_SELL_YES = 1;
			final int MENU_SELL_NO = 2;
			
			switch (menu) {
				case MENU_SELL_YES:
					Player.guild.inventory.removeItem(item);
					Player.guild.addMoney(sellingPrice);
					System.out.println("판매 완료");
					return;
				case MENU_SELL_NO:
					return;
			}
		}
	}

	private void printMenu() {
		System.out.println("=== 상점 ===");
		System.out.println("1. 구매하기");
		System.out.println("2. 판매하기");
		System.out.println("0. 뒤로가기");
	}
	
	private void printMenuItemBuy() {
		System.out.println("=== 구매 ===");
		System.out.println("1. 무기");
		System.out.println("2. 방어구");
		System.out.println("3. 물약");
		System.out.println("0. 뒤로가기");
		System.out.println("===========");
	}
	
	private void loadItemsFromFile() {
		String fileData = FileManager.loadFile("src/item/items.txt"); // ok
		String[] items = fileData.split("\n");
		
		for (String item : items) {
			String[] data = item.split("/");
			
			String type = data[0];
			String name = data[1];
			int price = Integer.parseInt(data[2]);
			int stat = Integer.parseInt(data[3]);
			
			switch (type) {
				case (ItemType.WEAPON):
					itemWeapons.add(new ItemWeapon(name, price, stat));
					break;
				case (ItemType.ARMOR):
					itemArmors.add(new ItemArmor(name, price, stat));
					break;
				case (ItemType.POTION):
					itemUsables.add(new ItemUsable(name, price, stat));
					break;
			}
		}
	}
}
