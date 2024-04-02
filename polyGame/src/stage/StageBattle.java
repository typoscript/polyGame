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
			
			heroesTakeTurn();
			monstersAttackHeroes();
		}
		
		if (heroes.size() == 0)
			GameManager.isRunning = false;
	}
}
