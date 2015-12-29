package entity.projectile;

import graphics.Screen;
import graphics.Sprite;

import java.util.Random;

public class FireballProjectile extends Projectile {

	public static final int FIRE_RATE = 4; //higher number = slower rate
	protected int curFrame, anim = 0, rotateSpeed;

	/**
	 * Creates a new WizardProjectile
	 * @param x : The X-position of the projectile.
	 * @param y : The Y-position of the projectile.
	 * @param dir : The direction the projectile is facing.
	 */
	public FireballProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 200;
		speed = 4;
		rotateSpeed = 4;
		damage = 20;
		Random rand = new Random();
		int start = rand.nextInt(Sprite.fireball.length);
		sprite = Sprite.fireball[start];
		curFrame = start;
		dx = speed * Math.cos(angle);
		dy = speed * Math.sin(angle);
	}

	/**
	 * Updates the projectile.
	 */
	public void update() {
		// Increase the animation step, but don't let it increase indefinitely
		if (anim < 7500)
			anim++;
		else
			anim = 0;
		if (anim % rotateSpeed == 1) curFrame++;
		if (curFrame >= Sprite.fireball.length) curFrame = 0;
		sprite = Sprite.fireball[curFrame];
		move();
	}

	/**
	 * Moves the projectile along its trajectory
	 */
	protected void move() {
		x += dx;
		y += dy;
		if (distance() > range) remove();
	}

	/**
	 * Determines the distance the projectile has traveled.
	 * @return The distance traveled as a Double value.
	 */
	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
		return dist;
	}

	/**
	 * Renders the projectile.
	 * @param screen : The Screen to which the projectile will be rendered.
	 */
	public void render(Screen screen) {
		screen.renderProjectile((int) x - sprite.SIZE_X / 2, (int) y - sprite.SIZE_Y / 2, this);
	}
}
