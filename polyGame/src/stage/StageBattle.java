package stage;

import java.util.ArrayList;
import java.util.List;

import hero.Actionable;
import hero.Healer;
import main.GameManager;
import main.Unit;
import main.UnitManager;

public class StageBattle extends Stage {
	UnitManager unitManager = new UnitManager();
	List<Unit> heroes = new ArrayList<Unit>();
	List<Unit> monsters = new ArrayList<Unit>();
	
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
		monster.attack(getRandomHero());
	}

	private void takeTurnHeroes() {
		for (Unit hero : heroes) {
			takeActionHero((Actionable) hero);
		}
	}
	
	private void takeActionHero(Actionable hero) {
		Unit monster = getRandomMonster();

		if (hero instanceof Healer)
			hero.chooseAction(monster, getRandomHero());
		else
			hero.chooseAction(monster);
		
		handleUnitDead();
	}
	
	private void attackHeroesByMonsters() {
		for (Unit monster : monsters)
			attackRandomHero(monster);
	}
	
	private void handleUnitDead() {
		for (int i = 0; i < heroes.size(); i++) {
			Unit hero = heroes.get(i);

			if (hero.isDead())
				heroes.remove(hero);
		}

		for (int i = 0; i < monsters.size(); i++) {
			Unit monster = monsters.get(i);

			if (monster.isDead())
				heroes.remove(monster);
		}
	}
	
	private boolean isRunning() {
		return heroes.size() > 0 || monsters.size() > 0;
	}

	@Override
	public void init() {
		heroes = unitManager.getHeroes();
		monsters = unitManager.getMonsters();
	}

	@Override
	public void run() {
		init();
		
		while (isRunning()) {
			printUnitAll();
			
			takeTurnHeroes();
			attackHeroesByMonsters();
		}
		
		if (heroes.size() == 0)
			GameManager.isRunning = false;
	}
}
