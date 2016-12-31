package entity.mob;

import entity.Entity;
import game.Game;
import graphics.Screen;
import graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0, lastDir = 0, savedDir = 0;
	protected boolean moving = false, newDir = true, collidable = true;
	protected int moveSpeed = 1, animSpeed = 1;
	protected int health, maxHealth;

	public Mob() {
	}

	public Mob(int x, int y, Mob mob) {
		this.x = x;
		this.y = y;
		sprite = new Sprite(mob.sprite);
		health = mob.health;
		maxHealth = mob.maxHealth;
		moveSpeed = mob.moveSpeed;
		animSpeed = mob.animSpeed;
		this.test = mob.test;
	}

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

	public int getHealth() {
		return health;
	}

	public void hit(int damage) {
		health -= damage;
		if (health < 0) health = 0;
		if (health > maxHealth) health = maxHealth;
	}

	public void checkDeath() {
		if (health <= 0) remove();
	}

	public void update(Game game) {
		if (hidden) return;
		checkDeath();
	}

	protected void shoot(int x, int y, double dir) {
	}

	public void render(Screen screen) {
		if (hidden) return;
		if (!visible) return;
	}

	public int getCornerPinX(int c, int dx, int xOff, boolean mirror) {
		if (xOff <= 0)
			return ((x + dx) + (c % 2) * (sprite.SIZE_X / 2 + xOff) - sprite.SIZE_X / 4 - (mirror ? (((c % 2) + 1) % 2) * xOff : 0)) >> 4;
		else
			return ((x + dx) + (c % 2) * (sprite.SIZE_X / 2 - (mirror ? xOff : 0)) - sprite.SIZE_X / 4 + (((c % 2) + 1) % 2) * xOff) >> 4;
	}

	public int getCornerPinY(int c, int dy, int yOff, boolean mirror) {
		if (yOff >= 0)
			return ((y + dy) + (c / 2) * (sprite.SIZE_Y / 2 - yOff) - sprite.SIZE_Y / 4 + (mirror && c < 2 ? yOff : 0)) >> 4;
		else
			return ((y + dy) + (c / 2) * sprite.SIZE_Y / 2 - sprite.SIZE_Y / 4 - (((c / 2) + 1) % 2) * yOff + (mirror ? (((c / 2)) % 2) * yOff : 0)) >> 4;
	}

	public int getEdgePinX(int c, int dx, int xOff, boolean mirror) {
		if (c < 2)
			return ((x + dx) + xOff / 2 - (mirror ? xOff / 2 : 0)) >> 4;
		else if (xOff <= 0)
			return ((x + dx) + (((c - 2) % 2) == 0 ? 1 : 0) * (sprite.SIZE_X / 2 + xOff) - sprite.SIZE_X / 4 - (mirror ? ((c - 2) % 2) * xOff : 0)) >> 4;
		else
			return ((x + dx) + (((c - 2) % 2) == 0 ? 1 : 0) * sprite.SIZE_X / 2 + ((c - 2) % 2) * xOff - sprite.SIZE_X / 4 - (mirror ? ((c - 1) % 2) * xOff : 0)) >> 4;
	}

	public int getEdgePinY(int c, int dy, int yOff, boolean mirror) {
		if (c >= 2)
			return ((y + dy) + sprite.SIZE_Y / 2 - sprite.SIZE_Y / 2 - yOff / 2 + (mirror ? yOff / 2 : 0)) >> 4;
		else if (yOff <= 0)
			return ((y + dy) + ((((c % 2) + 1) % 2) == 0 ? 1 : 0) * sprite.SIZE_Y / 2 - (((c % 2) + 1) % 2) * yOff - sprite.SIZE_Y / 4 + (mirror ? (c % 2) * yOff : 0)) >> 4;
		else
			return ((y + dy) + ((((c % 2) + 1) % 2) == 0 ? 1 : 0) * sprite.SIZE_Y / 2 - sprite.SIZE_Y / 4 - (c % 2) * yOff + (mirror ? ((c + 1) % 2) * yOff : 0)) >> 4;
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

	public boolean isSolid() {
		return collidable;
	}

	public Sprite getSprite() {
		return sprite;
	}
}
