package stage;

import main.GameManager;

public class StageLobby extends Stage {
	private final int MENU_BATTLE = 1;
	private final int MENU_QUIT = 2;

	@Override
	public void init() {
	}

	@Override
	public void run() {
		System.out.println("=== 로비 ====");
		System.out.println("1) 전투 2) 종료");
		System.out.println("===========");
		
		while (true) {
			System.out.print("메뉴: ");
			int menu = GameManager.sc.nextInt();
			
			switch (menu) {
				case MENU_BATTLE:
					return;
				case MENU_QUIT:
					GameManager.isRunning = false;
					return;
			}
		}
	}
}
