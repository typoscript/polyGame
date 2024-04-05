package hero;

import utils.Input;
import main.Player;
import main.Unit;

public class Warrior extends Hero implements Actionable {
	public Warrior() {
		name = "전사";
		maxHp = 200;
		hp = maxHp;
		attackPower = 30;
	}
	
	@Override
	public void attack(Unit target) {
		target.decreaseHp(attackPower);

		System.out.printf("%s에게 몸둥이 공격 ([%d] 데미지)\n", target.getName(), attackPower);
		System.out.println(target);
	}

	@Override
	public void chooseAction(Unit target) {
		final int ATTACK = 1;
		final int ITEM_USE = 2;

		if (isSilent()) {
			handleSilence();
			return;
		}
		
		while (true) {
			System.out.printf("[%s] 1) 공격 2) 아이템 사용\n", name);
			int action = Input.getInputNumber("메뉴");
			
			switch (action) {
				case ATTACK:
					attack(target);
				case ITEM_USE:
					Player.guild.inventory.useItem(this);
					return;
			}
		}
		
	}

	@Override
	public void chooseAction(Unit firstTarget, Unit secondTarget) { }
}