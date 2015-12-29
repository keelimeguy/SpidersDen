package entity.mob;

import entity.Entity;
import graphics.Screen;
import graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0, lastDir = 0, savedDir = 0;
	protected boolean moving = false, newDir = true;

	/**
	 * Moves the player and updates its direction
	 * @param dx : The change in x of the mob's location
	 * @param dy : The change in y of the mob's location
	 */
	public void move(int dx, int dy) {

		// Update the direction the mob is moving in
		if (dy < 0 && dx == 0 && !(dir % 2 != 0 && moving)) {
			lastDir = dir;
			dir = 0;
		} else if (dy < 0 && lastDir != 0) {
			//lastDir = dir;
			dir = 0;
		}
		if (dy > 0 && dx == 0 && !(dir % 2 != 0 && moving)) {
			lastDir = dir;
			dir = 2;
		} else if (dy > 0 && lastDir != 2) {
			//lastDir = dir;
			dir = 2;
		}
		if (dx > 0 && dy == 0 && !(dir % 2 != 1 && moving)) {
			lastDir = dir;
			dir = 1;
		} else if (dx > 0 && lastDir != 1) {
			//lastDir = dir;
			dir = 1;
		}
		if (dx < 0 && dy == 0 && !(dir % 2 != 1 && moving)) {
			lastDir = dir;
			dir = 3;
		} else if (dx < 0 && lastDir != 3) {
			//lastDir = dir;
			dir = 3;
		}
		if (dy == 0 && dx == 0) lastDir = -1;

		/*if (dy < 0) dir = 0;
		if (dy > 0) dir = 2;
		if (dx > 0) dir = 1;
		if (dx < 0) dir = 3;*/

		// If the mob won't collide, move
		if (!collision(0, dy)) y += dy;
		if (!collision(dx, 0)) x += dx;

	}

	public void update() {
	}

	protected void shoot(int x, int y, double dir) {
	}

	public void render(Screen screen) {
	}

	/**
	 * Determines if the mob will collide should it move in the given direction
	 * @param dx : The change in x of the mob's location
	 * @param dy : The change in y of the mob's location
	 * @return 
	 * True if it will collide, false otherwise
	 */
	protected boolean collision(int dx, int dy) {
		return level.getTile((x + dx) >> 4, (y + dy) >> 4).solid();
	}
}
