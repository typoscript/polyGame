package stage;

public abstract class Stage {
	abstract public void init();
	abstract public Stage run(); // return next stage
}
