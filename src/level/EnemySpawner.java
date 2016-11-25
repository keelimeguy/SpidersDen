package level;

import java.util.Random;

import entity.mob.Mob;
import game.Game;

public abstract class EnemySpawner {

	protected Mob mob;
	protected Level level;
	protected Random random = new Random();

	public int anim = 0, speed = 1;

	public EnemySpawner(Mob mob, Level level, int speed) {
		this.mob = mob;
		this.level = level;
		this.speed = speed;
	}

	public void update(Game game) {
	}
}
