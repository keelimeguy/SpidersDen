package level;

import input.ai.SpiderAI;
import entity.mob.Mob;
import entity.mob.Spider;

public class SpiderSpawner extends EnemySpawner {

	public SpiderSpawner(Spider mob, Level level, int speed) {
		super(mob, level, speed);

	}

	public void update(Mob target) {
		// Increase the animation step, but don't let it increase indefinitely
		if (anim < 7500)
			anim++;
		else
			anim = 0;

		if (anim % speed == speed - 1) {
			level.add(new Spider(random.nextInt(level.getWidth()), level.getHeight(), new SpiderAI(level, null, target), (Spider) mob));
			anim = 0;
		}
	}

}
