package hero;

import main.Unit;

public interface Actionable {
	public void chooseAction(Unit target);
	public void chooseAction(Unit firstTarget, Unit secondTarget);
}
