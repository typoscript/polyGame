package guild;

import java.util.ArrayList;
import java.util.List;

import hero.Healer;
import hero.Hero;
import hero.Mage;
import hero.Warrior;

import item.Item;

import utils.Input;
import utils.Print;

public class Guild {
	private final int MENU_MEMBER_VIEW_ALL = 1;
	private final int MENU_MEMBER_HIRE = 2;
	private final int MENU_MEMBER_FIRE = 3;
	private final int MENU_PARTY_MEMBER_VIEW_ALL = 4;
	private final int MENU_PARTY_MEMBER_CHANGE = 5;
	private final int MENU_GO_BACK = 0;

	private final int MAX_NUM_OF_PARTY_MEMBERS = 3;
	private int money = 10000;
	private List<Hero> members = new ArrayList<Hero>();
	private List<Hero> partyMembers = new ArrayList<Hero>();
	public Inventory inventory = new Inventory();
	
	public List<Hero> getMemberAll() {
		return members;
	}
	
	public List<Item> getItemAll() {
		return inventory.getItemAll();
	}
	
	public boolean isPartyEmpty() {
		return partyMembers.size() == 0;
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
	
	public void run() {
		while (true) {
			printMenu();
			int menu = Input.getInputNumber("메뉴");
			
			switch (menu) {
				case MENU_MEMBER_VIEW_ALL:
					printMemberAll();
					break;
				case MENU_MEMBER_HIRE:
					hireHeroAsMember();
					break;
				case MENU_MEMBER_FIRE:
					fireMember();
					break;
				case MENU_PARTY_MEMBER_VIEW_ALL:
					printPartyMemberAll();
					break;
				case MENU_PARTY_MEMBER_CHANGE:
					changePartyMember();
					break;
				case MENU_GO_BACK:
					return;
			}
		}
	}
	
	private Hero getRandomHero() {
		Hero[] heroes = {
				new Healer(),
				new Mage(),
				new Warrior(),
			};

		int minIndex = 0;
		int maxIndex = heroes.length;
		int randomIndex = (int)(Math.random() * maxIndex) + minIndex;

		return heroes[randomIndex];
	}
	
	private List<Hero> getRandomHeroes(int numOfHeroes) {
		List<Hero> heroes = new ArrayList<Hero>();
		
		for (int i = 0; i < numOfHeroes; i++)
			heroes.add(getRandomHero());
		
		return heroes;
	}
	
	public void hireHeroAsMember() {
		int numOfHeroes = 3;
		List<Hero> heroes = getRandomHeroes(numOfHeroes);
		
		Print.printListWithListNumber(heroes);
		int heroIndex = Input.getInputNumber("고용할 용병의 숫자: ") - 1;

		if (heroIndex < 0 || heroIndex >= heroes.size()) {
			System.out.println("잘못된 숫자입니다");
			return;
		}
		
		Hero hero = heroes.get(heroIndex);
		int hireFee = hero.getLevel() * 1000;
		
		if (hireFee > money) {
			System.out.println("구매 금액이 부족합니다");
			return;
		}
		
		members.add(hero);
		money -= hireFee;
		System.out.println("고용 성공");
		System.out.println("남은 자본금: " + money);
	}
	
	public void fireMember() {
		if (members.isEmpty()) {
			System.out.println("길드원이 없습니다");
			return;
		}

		Print.printListWithListNumber(members);
		int memberIndex = Input.getInputNumber("구조조정할 길드원의 숫자: ") - 1;
		
		if (memberIndex < 0 || memberIndex >= members.size()) {
			System.out.println("잘못된 숫자입니다");
			return;
		}
		
		members.remove(memberIndex);
		System.out.println("길드원 추방 성공");
	}
	
	public boolean firePartyMember() {
		Print.printListWithListNumber(partyMembers);
		int partyMemberIndex = Input.getInputNumber("파티에서 추방할 파티원의 숫자: ") - 1;
		
		if (partyMemberIndex < 0 || partyMemberIndex >= partyMembers.size()) {
			System.out.println("잘못된 숫자입니다");
			return false;
		}
		
		return true;
	}
	
	public void changePartyMember() {
		if (partyMembers.size() == MAX_NUM_OF_PARTY_MEMBERS) {
			System.out.println("파티가 만원입니다");
			return;
		}
		
		if (members.isEmpty()) {
			System.out.println("길드원이 없습니다");
			return;
		}

		Print.printListWithListNumber(members);
		int memberIndex = Input.getInputNumber("파티에 추가할 길드원의 숫자: ") - 1;

		if (memberIndex < 0 || memberIndex >= members.size()) {
			System.out.println("잘못된 숫자입니다");
			return;
		}

		Hero member = members.get(memberIndex);

		if (member.hasParty()) {
			System.out.println("이미 파티원입니다");
			return;
		}
		
		boolean shouldAddMemberToParty = true;

		if (partyMembers.size() == MAX_NUM_OF_PARTY_MEMBERS)
			shouldAddMemberToParty = firePartyMember();
		
		if (!shouldAddMemberToParty)
			return;
		
		member.joinParty();
		partyMembers.add(member);
		System.out.println("파티 가입 성공");
	}
	
	private void printMenu() {
		System.out.println("=== 길드 관리 ===");
		System.out.println("1) 길드원 목록");
		System.out.println("2) 길드원 증원");
		System.out.println("3) 길드원 감원");
		System.out.println("4) 파티원 목록");
		System.out.println("5) 파티원 추가/교체");
		System.out.println("0) 뒤로가기");
		System.out.println("==============");
	}
	
	private void printMemberAll() {
		if (members.isEmpty()) {
			System.out.println("길드원이 없습니다");
			return;
		}

		Print.printListWithListNumber(members);
	}
	
	private void printPartyMemberAll() {
		if (partyMembers.isEmpty()) {
			System.out.println("파티원이 없습니다");
			return;
		}

		Print.printListWithListNumber(partyMembers);
	}
}
