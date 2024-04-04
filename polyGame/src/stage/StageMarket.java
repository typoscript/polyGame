package stage;

import main.UnitManager;
import shop.Shop;

public class StageMarket extends Stage {
	Shop shop;
	UnitManager unitManager;

	@Override
	public void init() {
		shop = new Shop();
		unitManager = UnitManager.getInstance();
	}

	@Override
	public StageName run() {
		return null;
	}
}
