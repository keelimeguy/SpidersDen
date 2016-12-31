package entity.projectile;

import entity.Entity;
import entity.mob.Mob;
import game.Game;
import graphics.Screen;
import graphics.Sprite;

import java.util.Random;

public class FireballProjectile extends Projectile {

	public static final int FIRE_RATE = 4; //higher number = slower rate
	protected int curFrame, anim = 0, rotateSpeed;
	public Sprite[] sprites;

	/**
	 * Creates a new WizardProjectile
	 * @param x : The X-position of the projectile.
	 * @param y : The Y-position of the projectile.
	 * @param dir : The direction the projectile is facing.
	 */
	public FireballProjectile(int x, int y, double dir, Sprite[] sprites) {
		super(x, y, dir);
		range = 400;
		speed = 4;
		rotateSpeed = 4;
		damage = 5;
		Random rand = new Random();
		int start = rand.nextInt(sprites.length);
		this.sprite = sprites[start];
		this.sprites = sprites;
		curFrame = start;
		dx = speed * Math.cos(angle);
		dy = speed * Math.sin(angle);
	}

	public FireballProjectile(int x, int y, double dir, Sprite[] sprites, int damage) {
		super(x, y, dir);
		range = 400;
		speed = 4;
		rotateSpeed = 4;
		this.damage = damage;
		Random rand = new Random();
		int start = rand.nextInt(sprites.length);
		this.sprite = sprites[start];
		this.sprites = sprites;
		curFrame = start;
		dx = speed * Math.cos(angle);
		dy = speed * Math.sin(angle);
	}

	/**
	 * Updates the projectile.
	 */
	public void update(Game game) {
		if (hidden) return;
		// Increase the animation step, but don't let it increase indefinitely
		if (anim < 7500)
			anim++;
		else
			anim = 0;
		if (anim % rotateSpeed == 1) curFrame++;
		if (curFrame >= sprites.length) curFrame = 0;
		sprite = sprites[curFrame];
		move();
	}

	/**
	 * Moves the projectile along its trajectory
	 */
	protected void move() {
		if (!collision((int) dx, (int) dy)) {
			x += dx;
			y += dy;
		} else
			remove();
		if (distance() > range) remove();
	}

	/**
	 * Determines the distance the projectile has traveled.
	 * @return The distance traveled as a Double value.
	 */
	protected double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
		return dist;
	}

	protected boolean collision(int dx, int dy) {
		for (Entity e : level.getEntities())
			if (e instanceof Mob && ((Mob) e).isSolid()) {
				for (int c = 0; c < 4; c++) {
					int xt = ((Mob) e).getCornerPinX(c, 0, 0, false);
					int yt = ((Mob) e).getCornerPinY(c, 0, 0, false);
					int xxt = ((Mob) e).getEdgePinX(c, 0, 0, false);
					int yyt = ((Mob) e).getEdgePinY(c, 0, 0, false);
					if (level.getTile(xt, yt).equals(level.getTile(((int) x + dx) >> 4, ((int) y + dy) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x + dx) >> 4, ((int) y + dy) >> 4))) {
						((Mob) e).hit(damage);
						return true;
					}
				}
			}
		return false;
	}

	/**
	 * Renders the projectile.
	 * @param screen : The Screen to which the projectile will be rendered.
	 */
	public void render(Screen screen) {
		if (hidden) return;
		if (!visible) return;
		screen.renderProjectile((int) x - sprite.SIZE_X / 2, (int) y - sprite.SIZE_Y / 2, this);
	}
}
