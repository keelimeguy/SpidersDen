package input.ai;

import input.Keyboard;
import level.Level;
import entity.mob.Mob;

public abstract class AI extends Keyboard {
	protected Level level;
	protected Mob master;

	public AI(Level level, Mob master) {
		this.level = level;
		this.master = master;
	}

	public void init(Mob master) {
		this.master = master;
	}

	protected void reset() {
		up = false;
		down = false;
		left = false;
		right = false;
		q = false;
		e = false;
		n1 = false;
		n2 = false;
		n3 = false;
		n4 = false;
		n5 = false;
		n6 = false;
		n7 = false;
		n8 = false;
		n9 = false;
		n0 = false;
		space = false;
		shift = false;
		ctrl = false;
	}

	public void update() {

	}
}
