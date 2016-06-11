package level;

import java.util.Random;

import entity.mob.Mob;

public abstract class EnemySpawner<T> {

	protected Mob mob;
	protected Level level;
	protected Random random = new Random();

	public int anim = 0, speed = 1;

	public EnemySpawner(Mob mob, Level level, int speed) {
		this.mob = mob;
		this.level = level;
		this.speed = speed;
	}

	public void update(Mob target) {
	}
}
