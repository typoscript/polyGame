package stage;

import main.GameManager;
import main.UnitManager;
import shop.Shop;

public class StageMarket extends Stage {
	private final int GUILD_EDIT	= 1;
	private final int SHOP			= 2;
	private final int INVENTORY		= 3;
	private final int SAVE_DATA		= 4;
	private final int LOAD_DATA		= 5;
	private final int GO_BACK		= 0;

	private Shop shop;
	private UnitManager unitManager;
	
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
		unitManager = UnitManager.getInstance();
	}

	@Override
	public StageName run() {
		printMenu();
		
		while (true) {
			int menu = GameManager.sc.nextInt();
			
			switch (menu) {
				case GUILD_EDIT:
					break;
				case SHOP:
					break;
				case INVENTORY:
					break;
				case SAVE_DATA:
					break;
				case LOAD_DATA:
					break;
				case GO_BACK:
					return StageName.LOBBY;
			}
		}
		
		return StageName.LOBBY;
	}
}
