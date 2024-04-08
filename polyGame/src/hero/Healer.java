package hero;

import item.ItemArmor;
import item.ItemWeapon;
import main.Player;
import main.Unit;
import main.UnitStatus;
import utils.Input;

public class Healer extends Hero implements Actionable {
	private int healPower;

	public Healer() {
		name = "의사";
		maxHp = 150;
		hp = maxHp;
		attackPower = 10;
		healPower = attackPower;
	}

	public Healer(String name, int level, int hp, int maxHp, int attackPower, int armorPower, int exp, UnitStatus status, boolean hasParty, ItemWeapon weapon, ItemArmor armor) {
		super(name, level, hp, maxHp, attackPower, armorPower, exp, status, hasParty, weapon, armor);
		this.healPower = attackPower;
	}

	public void heal(Unit target) {
		target.increaseHp(healPower);
		
		System.out.printf("%s에게 치료 ([%d]hp 회복)\n", target.getName(), healPower);
	}
	
	@Override
	public void attack(Unit target) {
		target.decreaseHp(attackPower);

		System.out.printf("%s에게 주사 공격 ([%d] 데미지)\n", target.getName(), attackPower);
		System.out.println(target);
	}
	
	@Override
	public void chooseAction(Unit target) { }

	@Override
	public void chooseAction(Unit attackTarget, Unit healTarget) {
		final int ATTACK = 1;
		final int ITEM_USE = 2;
		final int HEAL = 3;
		
		if (isSilent()) {
			handleSilence();
			return;
		}
		
		while (true) {
			System.out.printf("[%s] 1) 공격 2) 아이템 사용 3) 힐\n", printBattleStatus());
			int action = Input.getInputNumber("메뉴");
			
			switch (action) {
				case ATTACK:
					attack(attackTarget);
					return;
				case ITEM_USE:
					boolean isItemUsed = Player.guild.inventory.useItem(this);

					if (isItemUsed)
						return;
				case HEAL:
					heal(healTarget);
					return;
			}
		}
	}
}
