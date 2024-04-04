package guild;

import java.util.ArrayList;
import java.util.List;

import hero.Hero;
import item.Item;

public class Guild {
	private int money = 1000;
	private List<Hero> members = new ArrayList<Hero>();
	private List<Item> items = new ArrayList<Item>();
	
	public List<Item> getItemAll() {
		return items;
	}

	public int getMoney() {
		return money;
	}
	
	public boolean hasItem(Item item) {
		return items.contains(item);
	}

	public void addItem(Item item) {
		items.add(item);
	}
	
	public void deleteItem(Item item) {
		items.remove(item);
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
