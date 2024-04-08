package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import hero.Hero;

public class FileManager {
	public static final String HERO_FILE_NAME = "hero.txt";
	public static final String SHOP_ITEM_FILE_NAME = "shop_items.txt";
	private static String DATA_DIR = "src/data/";
	private static FileWriter fw;
	private static FileReader fr;
	private static BufferedReader br;
	
	public static void saveHeroData() {
		String data = "";

		List<Hero> members = Player.guild.getMemberAll();
		
		for (int i = 0; i < members.size(); i++) {
			Hero hero = members.get(i);
			String weaponName = hero.getWeapon() == null ? "NONE" : hero.getWeapon().NAME;
			String armorName = hero.getArmor() == null ? "NONE" : hero.getArmor().NAME;

			data += hero.getName() + "/" +
					hero.getLevel() + "/" +
					hero.getHp() + "/" +
					hero.getMaxHp() + "/" +
					hero.getAttackPower() + "/" +
					hero.getArmorPower() + "/" +
					hero.getStatus() + "/" +
					hero.getExp() + "/" +
					hero.hasParty() + "/" +
					weaponName + "/" +
					armorName;
			
			if (i < members.size() - 1)
				data += "\n";
		}
		
		try {
			fw = new FileWriter(DATA_DIR + HERO_FILE_NAME);
			fw.write(data);
			
			fw.close();
		} catch (Exception e) {
			System.out.println("파일 저장 실패: " + HERO_FILE_NAME);
		}
	}
	
	public static String getDataFromFile(String fileName) {
		String data = "";

		try {
			fr = new FileReader(DATA_DIR + fileName);
			br = new BufferedReader(fr);
			
			while (br.ready())
				data += br.readLine() + "\n";
			
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("파일 로드 실패");
		}
		
		return data;
	}
}
