package stage;

import java.util.ArrayList;
import java.util.List;

import hero.Actionable;
import hero.Healer;
import hero.Hero;
import main.GameManager;
import main.Player;
import main.Unit;
import monster.MonsterManager;

public class StageBattle extends Stage {
	private MonsterManager monsterManager = MonsterManager.getInstance();
	private List<Hero> heroes = new ArrayList<Hero>();
	private List<Unit> monsters = new ArrayList<Unit>();
	
	private void printUnitAll() {
		System.out.println("== hereos ==");
		for (Unit hero : heroes)
			System.out.println(hero);
		System.out.println("============");

		System.out.println("== Monsters ==");
		for (Unit monster : monsters)
			System.out.println(monster);
		System.out.println("==============");
	}
	
	private Unit getRandomHero() {
		int ranIdx = (int)(Math.random() * heroes.size());
		return heroes.get(ranIdx);
	}

	private Unit getRandomMonster() {
		int ranIdx = (int)(Math.random() * monsters.size());
		return monsters.get(ranIdx);
	}
	
	private void attackRandomHero(Unit monster) {
		if (heroes.isEmpty())
			return;

		monster.attack(getRandomHero());
		
		handleUnitDead();
	}

	private void takeTurnHeroes() {
		for (Unit hero : heroes)
			takeActionHero((Actionable) hero);
	}
	
	private void takeActionHero(Actionable hero) {
		if (monsters.isEmpty())
			return;

		Unit monster = getRandomMonster();
		
		if (hero instanceof Healer)
			hero.chooseAction(monster, getRandomHero());
		else
			hero.chooseAction(monster);
		
		handleUnitDead();
	}
	
	private void attackHeroesByMonsters() {
		for (Unit monster : monsters) {
			attackRandomHero(monster);
			
			try {
				Thread.sleep(500);
			} catch (Exception e) { }
		}
	}
	
	private void handleUnitDead() {
		for (int i = 0; i < heroes.size(); i++) {
			Unit hero = heroes.get(i);

			if (hero.isDead()) {
				heroes.remove(hero);
				System.out.printf("%s 사망\n", hero.getName());
			}
		}

		for (int i = 0; i < monsters.size(); i++) {
			Unit monster = monsters.get(i);

			if (monster.isDead()) {
				monsters.remove(monster);
				System.out.printf("%s 사망\n", monster.getName());
			}
		}
	}
	
	private boolean isRunning() {
		return heroes.size() > 0 && monsters.size() > 0;
	}
	
	private int getStageClearMoney() {
		return GameManager.getStageLevel() * 1000;
	}
	
	private int getStageClearExp() {
		return GameManager.getStageLevel() * 10;
	}
	
	private void handleStageClear() {
		int money = getStageClearMoney();
		int exp = getStageClearExp();
		GameManager.levelUpStageLevel();

		Player.guild.addMoney(money);
		Player.guild.increasePartyMembersExp(exp);
		System.out.printf("스테이지 클리어 상금: %d | 획득 경험치: %d\n", money, exp);
	}
	
	private boolean isValidParty() {
		if (Player.guild.isPartyEmpty()) {
			System.out.println("파티원이 없습니다");
			return false;
		}
		
		if (Player.guild.isMemberDead()) {
			System.out.println("파티원중 사망자가 있습니다");
			return false;
		}

		return true;
	}

	@Override
	public void init() {
		heroes = Player.guild.getPartyMemberAll();
		monsterManager.spawnMonsters();
		monsters = monsterManager.getMonsters();
	}

	@Override
	public StageName run() {
		if (!isValidParty())
			return StageName.LOBBY;

		init();
		
		while (isRunning()) {
			printUnitAll();
			
			takeTurnHeroes();
			attackHeroesByMonsters();
		}
		
		if (heroes.size() == 0)
			GameManager.isRunning = false;
		else
			handleStageClear();

		return StageName.LOBBY;
	}
}
