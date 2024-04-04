package guild;

import java.util.ArrayList;
import java.util.List;

import hero.Hero;
import item.Item;

public class Guild {
	private int money = 1000;
	private List<Hero> members = new ArrayList<Hero>();
	private static Inventory inventory = new Inventory();
	
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
}
