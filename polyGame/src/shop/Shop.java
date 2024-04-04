package shop;

import java.util.ArrayList;
import java.util.List;

import item.Item;
import item.ItemArmor;
import item.ItemWeapon;
import main.FileManager;
import main.GameManager;

public class Shop {
	private final int MENU_BUY = 1;
	private final int MENU_SELL = 2;
	private final int MENU_QUIT = 0;
	private static List<Item> items = new ArrayList<Item>();
	
	private void run() {
		while (true) {
			printMenu();
			
			int menu = GameManager.sc.nextInt();
			
			switch (menu) {
				case MENU_BUY:
					runBuy();
					break;
				case MENU_SELL:
					runSell();
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
}
