package guild;

import java.util.ArrayList;
import java.util.List;

import item.Item;

public class Guild {
	private int money = 1000;
	private List<Item> items = new ArrayList<Item>();
	
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
