package guild;

import java.util.ArrayList;
import java.util.List;

import hero.Hero;
import item.Item;
import main.Input;
import main.Print;

public class Guild {
	private final int MAX_NUM_OF_PARTY_MEMBERS = 3;
	private int money = 1000;
	private List<Hero> members = new ArrayList<Hero>();
	private List<Hero> partyMembers = new ArrayList<Hero>();
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
	
	public void fireMember() {
		if (members.isEmpty()) {
			System.out.println("길드원이 없습니다");
			return;
		}

		Print.printListWithListNumber(members);
		int memberIndex = Input.getInputNumber("구조조정할 길드원의 숫지: ");
		
		if (memberIndex < 0 || memberIndex >= members.size()) {
			System.out.println("잘못된 숫자입니다");
			return;
		}
		
		members.remove(memberIndex);
		System.out.println("길드원 추방 성공");
	}
	
	public void printMenu() {
		System.out.println("=== 길드 관리 ===");
		System.out.println("1) 길드원 목록 2) 증원 3) 감원 4) 파티원 교체 0) 뒤로가기");
		System.out.println("==============");
	}
}
