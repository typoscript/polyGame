package stage;

public abstract class Stage {
	abstract public void init();
	abstract public StageName run(); // return next stage
}
