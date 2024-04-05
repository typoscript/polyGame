package item;

import main.Unit;

public class ItemHpPotion extends ItemUse {
	public ItemHpPotion(String name, int price, int stat) {
		super(name, price, stat);
	}

	@Override
	public void use(Unit target) {
		target.increaseHp(STAT);
		System.out.printf("%s 회복후 체력: %d\n", target.getName(), target.getHp());
	}
	
	@Override
	public String toString() {
		return String.format("이름: %s | 가격: %d | 회복력: %d", NAME, PRICE, STAT);
	}
}
