package main;

import java.util.ArrayList;

public class UnitManager {
	private ArrayList<Unit> heores = new ArrayList<>();
	private ArrayList<Unit> monsters = new ArrayList<>();
	private final String PATH = "monsters.";
	private final String[] monsterClassNames = { "Mushroom", "Ghost", "Orc" };
	
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
