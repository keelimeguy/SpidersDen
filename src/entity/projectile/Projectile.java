package entity.projectile;

import java.util.Random;

import entity.Entity;
import entity.mob.Mob;
import graphics.Sprite;

public abstract class Projectile extends Entity {

	protected final int xOrigin, yOrigin;
	protected double dx, dy;
	protected double angle;
	protected Sprite sprite;
	protected double x, y;
	protected double speed, range;
	protected int damage;

	protected final Random random = new Random();

	/**
	 * Create a new Projectile at a given position with a given facing.
	 * @param x : The X-position where the projectile originated.
	 * @param y : The Y-position where the projectile originated.
	 * @param dir : The direction the projectile will head.
	 */
	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public int getSpriteSizeX() {
		return sprite.SIZE_X;
	}

	public int getSpriteSizeY() {
		return sprite.SIZE_Y;
	}

	protected void move() {
	}

	public int getCornerPinX(int c, int dx, int xOff, boolean mirror) {
		if (xOff <= 0)
			return ((int) (x + dx) + (c % 2) * (sprite.SIZE_X / 2 + xOff) - sprite.SIZE_X / 4 - (mirror ? (((c % 2) + 1) % 2) * xOff : 0)) >> 4;
		else
			return ((int) (x + dx) + (c % 2) * (sprite.SIZE_X / 2 - (mirror ? xOff : 0)) - sprite.SIZE_X / 4 + (((c % 2) + 1) % 2) * xOff) >> 4;
	}

	public int getCornerPinY(int c, int dy, int yOff, boolean mirror) {
		if (yOff >= 0)
			return ((int) (y + dy) + (c / 2) * (sprite.SIZE_Y / 2 - yOff) - sprite.SIZE_Y / 4 + (mirror && c < 2 ? yOff : 0)) >> 4;
		else
			return ((int) (y + dy) + (c / 2) * sprite.SIZE_Y / 2 - sprite.SIZE_Y / 4 - (((c / 2) + 1) % 2) * yOff + (mirror ? (((c / 2)) % 2) * yOff : 0)) >> 4;
	}

	public int getEdgePinX(int c, int dx, int xOff, boolean mirror) {
		if (c < 2)
			return ((int) (x + dx) + xOff / 2 - (mirror ? xOff / 2 : 0)) >> 4;
		else if (xOff <= 0)
			return ((int) (x + dx) + (int) Math.pow(0, (int) ((c - 2) % 2)) * (sprite.SIZE_X / 2 + xOff) - sprite.SIZE_X / 4 - (mirror ? ((c - 2) % 2) * xOff : 0)) >> 4;
		else
			return ((int) (x + dx) + (int) Math.pow(0, (int) ((c - 2) % 2)) * sprite.SIZE_X / 2 + ((c - 2) % 2) * xOff - sprite.SIZE_X / 4 - (mirror ? ((c - 1) % 2) * xOff : 0)) >> 4;
	}

	public int getEdgePinY(int c, int dy, int yOff, boolean mirror) {
		if (c >= 2)
			return ((int) (y + dy) + sprite.SIZE_Y / 2 - sprite.SIZE_Y / 2 - yOff / 2 + (mirror ? yOff / 2 : 0)) >> 4;
		else if (yOff <= 0)
			return ((int) (y + dy) + (int) Math.pow(0, ((int) ((c % 2) + 1)) % 2) * sprite.SIZE_Y / 2 - (((c % 2) + 1) % 2) * yOff - sprite.SIZE_Y / 4 + (mirror ? (c % 2) * yOff : 0)) >> 4;
		else
			return ((int) (y + dy) + (int) Math.pow(0, ((int) ((c % 2) + 1)) % 2) * sprite.SIZE_Y / 2 - sprite.SIZE_Y / 4 - (c % 2) * yOff + (mirror ? ((c + 1) % 2) * yOff : 0)) >> 4;
	}

	protected boolean collision(int dx, int dy) {
		if (level.getTile(((int) x + dx) >> 4, ((int) y + dy) >> 4).solid()) return true;
		for (Entity e : level.getEntities())
			if (e instanceof Mob) for (int c = 0; c < 4; c++) {
				int xt = ((Mob) e).getCornerPinX(c, 0, 0, false);
				int yt = ((Mob) e).getCornerPinY(c, 0, 0, false);
				int xxt = ((Mob) e).getEdgePinX(c, 0, 0, false);
				int yyt = ((Mob) e).getEdgePinY(c, 0, 0, false);
				if (level.getTile(xt, yt).equals(level.getTile(((int) x + dx) >> 4, ((int) y + dy) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x + dx) >> 4, ((int) y + dy) >> 4))) return true;
			}
		return false;
	}
}
