package shop;

import java.util.ArrayList;
import java.util.List;

import item.Item;
import item.ItemArmor;
import item.ItemUsable;
import item.ItemWeapon;
import main.FileManager;
import main.GameManager;

public class Shop {
	private final int MENU_BUY_ITEM = 1;
	private final int MENU_SELL_ITEM = 2;
	private final int MENU_QUIT = 0;
	private List<ItemWeapon> itemWeapons = new ArrayList<>();
	private List<ItemArmor> itemArmors = new ArrayList<>();
	private List<ItemUsable> itemUsables = new ArrayList<>();
	
	private void run() {
		while (true) {
			printMenu();
			
			int menu = GameManager.sc.nextInt();
			
			switch (menu) {
				case MENU_BUY_ITEM:
					runBuyItem();
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

	private void printMenu() {
		System.out.println("=== 상점 ===");
		System.out.println("1. 구매하기");
		System.out.println("2. 판매하기");
		System.out.println("0. 뒤로가기");
	}
	
	private void loadItemsFromFile() {
		String fileData = FileManager.loadFile("src/item/items.txt"); // ok
		String[] items = fileData.split("\n");
		
		String WEAPON = "WEAPON";
		String ARMOR = "ARMOR";
		String HP_POTION = "HP_POTION";
		
		for (String item : items) {
			String[] data = item.split("/");
			
			String type = data[0];
			String name = data[1];
			int price = Integer.parseInt(data[2]);
			int stat = Integer.parseInt(data[3]);
			
			if (type.equals(WEAPON))
				itemWeapons.add(new ItemWeapon(name, price, stat));
			else if (type.equals(ARMOR))
				itemArmors.add(new ItemArmor(name, price, stat));
			else if (type.equals(HP_POTION))
				itemUsables.add(new ItemUsable(name, price, stat));
		}
	}
}
