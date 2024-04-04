package guild;

import java.util.ArrayList;
import java.util.List;

import item.Item;

public class Inventory {
	List<Item> items = new ArrayList<Item>();
	
	private void printMenu() {
		System.out.println("=== 인벤토리 ===");
		System.out.println("1) 착용");
		System.out.println("2) 벗기");
		System.out.println("0) 뒤로가기");
	}
}
