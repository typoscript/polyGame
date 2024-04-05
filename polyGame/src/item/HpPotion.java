package item;

import main.Unit;

public class HpPotion extends ItemUsable {

	public HpPotion(String name, int price, int stat) {
		super(name, price, stat);
	}

	@Override
	public void use(Unit target) {
		target.increaseHp(STAT);
	}
	
	@Override
	public String toString() {
		return String.format("이름: %s | 가격: %d | 회복력: %d", NAME, PRICE, STAT);
	}
}
