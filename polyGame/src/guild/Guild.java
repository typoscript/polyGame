package guild;

import java.util.ArrayList;
import java.util.List;

import hero.Hero;
import item.Item;

public class Guild {
	private int money = 1000;
	private List<Hero> members = new ArrayList<Hero>();
	public Inventory inventory = new Inventory();
	
	public List<Hero> getMemberAll() {
		return members;
	}
	
	public List<Item> getItemAll() {
		return inventory.getItemAll();
	}

	public int getMoney() {
		return money;
	}
	
	public void addMoney(int money) {
		if (money > 0)
			this.money += money;
	}
	
	public boolean spendMoney(int money) {
		if (money > this.money)
			return false;
		
		this.money -= money;
		return true;
	}
	
	public void printMenu() {
		System.out.println("=== 길드 관리 ===");
		System.out.println("1) 길드원 목록 2) 증원 3) 감원 4) 파티원 교체 0) 뒤로가기");
		System.out.println("==============");
	}
}
