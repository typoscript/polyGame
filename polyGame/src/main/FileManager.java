package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import hero.Hero;
import item.Item;
import item.ItemArmor;
import item.ItemHpPotion;
import item.ItemType;
import item.ItemUse;
import item.ItemWeapon;

public class FileManager {
	public static final String GUILD_FILE_NAME = "guild.txt";
	public static final String HERO_FILE_NAME = "hero.txt";
	public static final String SHOP_ITEM_FILE_NAME = "shop_items.txt";
	private static String DATA_DIR = "src/data/";
	private static FileWriter fw;
	private static FileReader fr;
	private static BufferedReader br;
	
	public static void saveGameData() {
		saveHeroData(); // hero 저장 시, hero의 장비를 벗기고 인벤토리에 item 저장
		saveGuildData();
	}
	
	private static void saveGuildData() {
		String guildData = Player.guild.getStageLevel() + "/" + Player.guild.getMoney();
		List<Item> items = Player.guild.inventory.getItemAll();
		
		for (Item item : items) {
			String type = ItemType.getType(item);

			guildData += "\n" + type + "/" + item.NAME + "/" + item.PRICE + "/";
			
			if (item instanceof ItemUse)
				guildData += ((ItemHpPotion)item).STAT;
			else if (item instanceof ItemWeapon)
				guildData += ((ItemWeapon)item).ATTACK_POWER;
			else if (item instanceof ItemArmor)
				guildData += ((ItemArmor)item).ARMOR_POWER;
		}
		
		try {
			fw = new FileWriter(DATA_DIR + GUILD_FILE_NAME);
			fw.write(guildData);
			
			fw.close();
		} catch (Exception e) {
			System.out.println("파일 저장 실패: " + GUILD_FILE_NAME);
		}
	}
	
	private static void saveHeroData() {
		String data = "";

		List<Hero> members = Player.guild.getMemberAll();
		
		for (int i = 0; i < members.size(); i++) {
			Hero hero = members.get(i);
			String weaponName = "NONE";
			String armorName = "NONE";
			
			if (hero.hasWeapon()) {
				weaponName = hero.getWeapon().NAME;
				Player.guild.inventory.addItem(hero.unEquipWeapon());
			}

			if (hero.hasArmor()) {
				armorName = hero.getArmor().NAME;
				Player.guild.inventory.addItem(hero.unEquipArmor());
			}

			data += hero.getName() + "/" +
					hero.getStatus() + "/" +
					hero.hasParty() + "/" +
					weaponName + "/" +
					armorName + "/" +

					hero.getLevel() + "/" +
					hero.getHp() + "/" +
					hero.getMaxHp() + "/" +

					hero.getAttackPower() + "/" +
					hero.getArmorPower() + "/" +
					hero.getExp();
			
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
			System.out.println("파일 로드 실패: " + fileName);
		}
		
		return data;
	}
}
