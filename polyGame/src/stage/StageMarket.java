package stage;

import main.Player;
import shop.Shop;
import utils.Input;

public class StageMarket extends Stage {
	private final int GUILD_EDIT	= 1;
	private final int SHOP			= 2;
	private final int INVENTORY		= 3;
	private final int DATA_SAVE		= 4;
	private final int DATA_LOAD		= 5;
	private final int GO_BACK		= 0;

	private Shop shop;
	
	private void printMenu() {
		System.out.println("=== 시장 ===");
		System.out.println("1) 길드 관리");
		System.out.println("2) 상점");
		System.out.println("3) 인벤토리");
		System.out.println("4) 데이터 저장");
		System.out.println("5) 데이터 불러오기");
		System.out.println("0) 뒤로가기");
		System.out.println("==========");
	}

	@Override
	public void init() {
		shop = new Shop();
	}

	@Override
	public StageName run() {
		init();
		
		while (true) {
			printMenu();
			int menu = Input.getInputNumber("메뉴");
			
			switch (menu) {
				case GUILD_EDIT:
					Player.guild.run();
					break;
				case SHOP:
					shop.run();
					break;
				case INVENTORY:
					Player.guild.inventory.run();
					break;
				case DATA_SAVE:
					break;
				case DATA_LOAD:
					break;
				case GO_BACK:
					return StageName.LOBBY;
			}
		}
		
		//return StageName.LOBBY;
	}
}
