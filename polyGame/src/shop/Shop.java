package shop;

public class Shop {
	private final int MENU_BUY = 1;
	private final int MENU_SELL = 2;
	private final int MENU_QUIT = 0;

	private void printMenu() {
		System.out.println("=== 상점 ===");
		System.out.println("1. 구매하기");
		System.out.println("2. 판매하기");
		System.out.println("0. 뒤로가기");
	}
}
