package level;

import entity.mob.Spider;
import game.Game;
import input.ai.SpiderAI;

public class SpiderSpawner extends EnemySpawner {

	public SpiderSpawner(Spider mob, Level level, int speed) {
		super(mob, level, speed);
	}

	public void update(Game game) {
		// Increase the animation step, but don't let it increase indefinitely
		if (anim < speed * 3)
			anim++;
		else
			anim = 0;

		if (anim % speed == speed - 1) {
			int x = -1;
			int y = -1;

			int width = mob.getSprite().SIZE_X;
			int height = mob.getSprite().SIZE_Y;

			int xbound = level.getWidth() * 16;
			int ybound = level.getHeight() * 16;

			while (level.getTile(x >> 4, y >> 4).solid() || level.getTile(x + width / 2 >> 4, y >> 4).solid() || level.getTile(x - width / 2 >> 4, y >> 4).solid() || level.getTile(x + width / 2 >> 4, y + height / 2 >> 4).solid() || level.getTile(x + width / 2 >> 4, y - height / 2 >> 4).solid() || level.getTile(x - width / 2 >> 4, y + height / 2 >> 4).solid() || level.getTile(x - width / 2 >> 4, y - height / 2 >> 4).solid() || level.getTile(x >> 4, y + height / 2 >> 4).solid() || level.getTile(x >> 4, y - height / 2 >> 4).solid()) {
				x = (random.nextInt(xbound));
				y = (random.nextInt(ybound));
			}
			// System.out.println("New Spider: " + x + ", " + y + "   / " + xbound + ", " + ybound);
			level.add(new Spider(x, y, new SpiderAI(level, null, game.getPlayer()), (Spider) mob));
			anim = 0;
		}
	}
}
