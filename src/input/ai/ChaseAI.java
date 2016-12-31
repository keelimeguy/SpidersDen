package input.ai;

import java.util.ArrayList;

import level.Level;
import entity.Entity;
import entity.mob.Mob;

public abstract class ChaseAI extends AI {
	protected Mob target;

	public ChaseAI(Level level, Mob master, Mob target) {
		super(level, master);
		this.master = master;
		this.target = target;
	}

	public Mob getTarget() {
		return target;
	}
	
	public void update() {
		reset();
		ArrayList<int[]> path = AStar.findPath(level.getWidth(), level.getHeight(), master.getX(), master.getY(), target.getX(), target.getY(), level.getCollidable(), true);
		if (path != null && !path.isEmpty()) {
			int[] next = path.get(0);
			if (next[0] > master.getX())
				right = true;
			else if (next[0] < master.getX()) left = true;
			if (next[1] > master.getY())
				down = true;
			else if (next[1] < master.getY()) up = true;
		}
	}
}
