package guild;

public class Guild {
	private int money = 1000;
	
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
