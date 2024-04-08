package hero;

import utils.Input;
import item.ItemArmor;
import item.ItemWeapon;
import main.Player;
import main.Unit;
import main.UnitStatus;

public class Warrior extends Hero implements Actionable {
	public Warrior() {
		name = HeroNames.WARRIOR;
		maxHp = 200;
		hp = maxHp;
		attackPower = 30;
	}

	public Warrior(String name, int level, int hp, int maxHp, int attackPower, int armorPower, int exp, UnitStatus status, boolean hasParty, ItemWeapon weapon, ItemArmor armor) {
		super(name, level, hp, maxHp, attackPower, armorPower, exp, status, hasParty, weapon, armor);
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
			System.out.printf("[%s] 1) 공격 2) 아이템 사용\n", printBattleStatus());
			int action = Input.getInputNumber("메뉴");
			
			switch (action) {
				case ATTACK:
					attack(target);
					return;
				case ITEM_USE:
					boolean isItemUsed = Player.guild.inventory.useItem(this);

					if (isItemUsed)
						return;
			}
		}
		
	}

	@Override
	public void chooseAction(Unit firstTarget, Unit secondTarget) { }
}