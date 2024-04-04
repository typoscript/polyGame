package shop;

public class Calculator {
	private static int TAX_PERCENTAGE = 50;
	private Calculator() { }
	
	public static int getSellingTax(int price) {
		return (int)(price * (TAX_PERCENTAGE / 100.0));
	}
	
	public static int getSellingPrice(int price) {
		return price - getSellingTax(price);
	}
}