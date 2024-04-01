package main;

import java.util.ArrayList;
import java.util.List;

import hero.Healer;
import hero.Mage;
import hero.Warrior;

public class UnitManager {
	private ArrayList<Unit> heroes = new ArrayList<>();
	private ArrayList<Unit> monsters = new ArrayList<>();
	private final String PATH = "monsters.";
	private final String[] monsterClassNames = { "Mushroom", "Ghost", "Orc" };
	
	public UnitManager() {
		heroes.add(new Warrior());
		heroes.add(new Mage());
		heroes.add(new Healer());
	}
	
	public List<Unit> getHeroes() {
		return heroes;
	}

	public List<Unit> getMonsters() {
		return heroes;
	}
	
	public void spawnMonsters(int monsterCount) {
		for (int i = 0; i < monsterCount; i++) {
			int num = (int)(Math.random() * monsterClassNames.length);
			try {
				Class<?> clazz = Class.forName(PATH + monsterClassNames[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance(); // clazz.newInstance();
				Unit temp = (Unit) obj;
				monsters.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(monsters.get(i).name);
		}
	}
}
