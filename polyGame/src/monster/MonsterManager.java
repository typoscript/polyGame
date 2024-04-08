package monster;

import java.util.ArrayList;
import java.util.List;

import hero.Healer;
import hero.Mage;
import hero.Warrior;
import main.GameManager;
import main.Player;
import main.Unit;

public class MonsterManager {
	private final String PATH = "monster.";
	private final String[] monsterClassNames = { "Mushroom", "Ghost", "Orc" };
	private static MonsterManager instance = new MonsterManager();
	private ArrayList<Unit> monsters = new ArrayList<>();
	
	public static MonsterManager getInstance() {
		return instance;
	}
	
	private MonsterManager() { }
	
	public List<Unit> getMonsters() {
		return monsters;
	}
	
	public boolean isMonsterAllDead() {
		return monsters.isEmpty();
	}
	
	public void spawnMonsters() {
		spawnMonsters(Player.guild.getStageLevel());
	}
	
	private void spawnMonsters(int monsterCount) {
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
		}
	}
}
