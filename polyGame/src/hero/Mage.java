package hero;

import utils.Input;
import item.ItemArmor;
import item.ItemWeapon;
import main.Player;
import main.Unit;
import main.UnitStatus;

public class Mage extends Hero implements Actionable {
	public Mage() {
		name = HeroNames.MAGE;
		maxHp = 100;
		hp = maxHp;
		attackPower = 20;
	}

	public Mage(String name, int level, int hp, int maxHp, int attackPower, int armorPower, int exp, UnitStatus status, boolean hasParty, ItemWeapon weapon, ItemArmor armor) {
		super(name, level, hp, maxHp, attackPower, armorPower, exp, status, hasParty, weapon, armor);
	}
	
	public void increaseAttackPower() {
		this.attackPower += getRandomAttackPower();
		
		System.out.printf("공격력 추가 상승 (+%d)\n", attackPower);
	}
	
	public int getRandomAttackPower() {
		return (int)(Math.random() * 30);
	}

	@Override
	public void attack(Unit target) {
		target.decreaseHp(attackPower);

		System.out.printf("%s에게 지팡이 공격 ([%d] 데미지)\n", target.getName(), attackPower);
		System.out.println(target);
	}
	

	@Override
	public void chooseAction(Unit target) {
		final int ATTACK = 1;
		final int ITEM_USE = 2;
		final int SKILL = 3;

		if (isSilent()) {
			handleSilence();
			return;
		}
		
		while (true) {
			System.out.printf("[%s] 1) 공격 2) 아이템 사용 3) 공격력 증가 스킬\n", printBattleStatus());
			int action = Input.getInputNumber("메뉴");
			
			switch (action) {
				case ATTACK:
					attack(target);
					return;
				case ITEM_USE:
					boolean isItemUsed = Player.guild.inventory.useItem(this);

					if (isItemUsed)
						return;
				case SKILL:
					increaseAttackPower();
					return;
			}
		}
		
	}

	@Override
	public void chooseAction(Unit firstTarget, Unit secondTarget) { }
}
