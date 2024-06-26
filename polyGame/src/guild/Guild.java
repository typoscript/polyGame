package guild;

import java.util.ArrayList;
import java.util.List;

import hero.Healer;
import hero.Hero;
import hero.HeroNames;
import hero.Mage;
import hero.Warrior;

import item.Item;
import item.ItemArmor;
import item.ItemHpPotion;
import item.ItemType;
import item.ItemWeapon;
import main.FileManager;
import main.Player;
import main.UnitStatus;
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
	private int stageLevel = 1;
	private List<Hero> members = new ArrayList<Hero>();
	private List<Hero> partyMembers = new ArrayList<Hero>();
	public Inventory inventory = new Inventory();

	public int getStageLevel() {
		return stageLevel;
	}

	public void levelUpStageLevel() {
		stageLevel++;
	}
	
	public List<Hero> getMemberAll() {
		return members;
	}

	public List<Hero> getPartyMemberAll() {
		return partyMembers;
	}
	
	public boolean isPartyEmpty() {
		return partyMembers.size() == 0;
	}
	
	public boolean isPartyMemberDead() {
		for (Hero member : partyMembers) {
			if (member.isDead())
				return true;
		}
		
		return false;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setStageLevel(int stageLevel) {
		this.stageLevel = stageLevel;
	}

	public void setMoney(int money) {
		this.money = money;
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
		final int heroPrice = 1000;
		int numOfHeroes = 3;
		List<Hero> heroes = getRandomHeroes(numOfHeroes);
		
		Print.printListWithListNumber(heroes);
		System.out.printf("용병 가격: %d\n", heroPrice);
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
		int index = Input.getInputNumber("구조조정할 길드원의 숫자: ") - 1;
		
		if (index < 0 || index >= members.size()) {
			System.out.println("잘못된 숫자입니다");
			return;
		}
		
		Hero member = members.get(index);
		
		members.remove(member);
		partyMembers.remove(member);
		System.out.println("길드원 추방 성공");
	}
	
	public boolean firePartyMember() {
		Print.printListWithListNumber(partyMembers);
		int index = Input.getInputNumber("파티에서 추방할 파티원의 숫자: ") - 1;
		
		if (index < 0 || index >= partyMembers.size()) {
			System.out.println("잘못된 숫자입니다");
			return false;
		}
		
		partyMembers.remove(index);
		
		return true;
	}
	
	public void changePartyMember() {
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
	
	public void increasePartyMembersExp(int exp) {
		for (Hero member : partyMembers)
			member.increaseExp(exp);
	}
	
	public void loadGameData() {
		loadGuildDataFromFile();
		loadMembersFromFile();
	}
	
	private void loadGuildDataFromFile() {
		inventory.clearItems();
		String data = FileManager.getDataFromFile(FileManager.GUILD_FILE_NAME);
		
		if (data.isEmpty())
			return;
		
		String[] guildInfo = data.split("\n");
		String[] stageAndMoney = guildInfo[0].split("/");
		int stageLevel = Integer.parseInt(stageAndMoney[0]);
		int money = Integer.parseInt(stageAndMoney[1]);
		
		setStageLevel(stageLevel);
		setMoney(money);
		
		for (int i = 1; i < guildInfo.length; i++) {
			String[] info = guildInfo[i].split("/");
			
			String type = info[0];
			String name = info[1];
			int price = Integer.parseInt(info[2]);
			int stat = Integer.parseInt(info[3]);

			switch (type) {
				case (ItemType.WEAPON):
					inventory.addItem(new ItemWeapon(name, price, stat));
					break;
				case (ItemType.ARMOR):
					inventory.addItem(new ItemArmor(name, price, stat));
					break;
				case (ItemType.HP_POTION):
					inventory.addItem(new ItemHpPotion(name, price, stat));
					break;
			}
		}
	}
	
	private void loadMembersFromFile() {
		members = new ArrayList<Hero>();
		partyMembers = new ArrayList<Hero>();

		String data = FileManager.getDataFromFile(FileManager.HERO_FILE_NAME);
		
		if (data.isEmpty())
			return;
		
		String[] membersInfo = data.split("\n");
		
		for (String memberInfo : membersInfo) {
			String[] info = memberInfo.split("/");
			
			String name = info[0];
			UnitStatus status = UnitStatus.valueOf(info[1]);
			boolean hasParty = Boolean.parseBoolean(info[2]);
			String weaponName = info[3];
			String armorName = info[4];
			
			int level = Integer.parseInt(info[5]);
			int hp = Integer.parseInt(info[6]);
			int maxHp = Integer.parseInt(info[7]);

			int attackPower = Integer.parseInt(info[8]);
			int armorPower = Integer.parseInt(info[9]);
			int exp = Integer.parseInt(info[10]);

			Hero hero = null;
			ItemWeapon weapon = null;
			ItemArmor armor = null;
			
			List<Item> items = inventory.getItemAll();
			
			for (int i = 0; i < items.size(); i++) {
				Item item = items.get(i);

				if (item.NAME.equals(weaponName)) {
					weapon = (ItemWeapon) item;
					items.remove(item);
				} else if (item.NAME.equals(armorName)) {
					armor = (ItemArmor) item;
					items.remove(item);
				}
			}
			
			switch (name) {
				case HeroNames.WARRIOR:
					hero = new Warrior(name, level, hp, maxHp, attackPower, armorPower, exp, status, hasParty, weapon, armor);
					break;
				case HeroNames.MAGE:
					hero = new Mage(name, level, hp, maxHp, attackPower, armorPower, exp, status, hasParty, weapon, armor);
					break;
				case HeroNames.HEALER:
					hero = new Healer(name, level, hp, maxHp, attackPower, armorPower, exp, status, hasParty, weapon, armor);
					break;
			}

			members.add(hero);

			if (hasParty)
				partyMembers.add(hero);
		}
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
	
	public void printPartyMemberLevelAndExp() {
		List<Hero> members = getPartyMemberAll();
		
		for (Hero member : members) {
			System.out.printf("이름: %s | 레벨: %d | 경험치: %d\n", member.getName(), member.getLevel(), member.getExp());
		}
	}

	private void printPartyMemberAll() {
		if (partyMembers.isEmpty()) {
			System.out.println("파티원이 없습니다");
			return;
		}

		Print.printListWithListNumber(partyMembers);
	}
}
