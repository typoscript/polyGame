package stage;

import main.GameManager;

public class StageLobby extends Stage {
	private final int MENU_BATTLE = 1;
	private final int MENU_MARKET = 2;
	private final int MENU_QUIT = 3;

	@Override
	public void init() { }

	@Override
	public StageName run() {
		System.out.printf("=== 로비 (현재 스테이지 %d) ====\n", GameManager.getStageLevel());
		System.out.println("1) 전투 2) 정비 3) 종료");
		System.out.println("==========================");
		
		while (true) {
			System.out.print("메뉴: ");
			int menu = GameManager.sc.nextInt();
			
			switch (menu) {
				case MENU_BATTLE:
					return StageName.BATTLE;
				case MENU_MARKET:
					return StageName.MARKET;
				case MENU_QUIT:
					GameManager.isRunning = false;
					return StageName.NO_STAGE;
			}
		}
	}
}
