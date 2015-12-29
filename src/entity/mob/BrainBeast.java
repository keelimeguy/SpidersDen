package entity.mob;

import entity.projectile.FireballProjectile;
import entity.projectile.Projectile;
import graphics.EnemySprite;
import graphics.Screen;
import graphics.Sprite;
import input.Keyboard;
import input.Mouse;

import java.util.Random;

public class BrainBeast extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private Sprite[][] sprites;
	private int anim = 0;
	private boolean walking = false, spaceFree = false;

	private int fireRate = 0;
	Projectile p;

	/**
	 * Creates a player at a specific (x,y) location
	 * @param x : The starting x coordinate (in pixel units)
	 * @param y : The starting y coordinate (in pixel units)
	 * @param input : The Keyboard controller for this player
	 */
	public BrainBeast(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprites = EnemySprite.brainBeast;
		sprite = sprites[0][0];
		fireRate = FireballProjectile.FIRE_RATE;
	}

	/**
	 * Updates the player animation and moves the player when necessary
	 */
	public void update(int width, int height) {

		if (fireRate > 0) fireRate--;

		// Increase the animation step, but don't let it increase indefinitely
		if (anim < 7500)
			anim++;
		else
			anim = 0;

		Random rand = new Random();
		
		boolean up = rand.nextBoolean();
		boolean down = rand.nextBoolean();
		boolean left = rand.nextBoolean();
		boolean right = rand.nextBoolean();
		
		// Update the change in position when a movement key is pressed
		int dx = 0, dy = 0;
		if (up) dy--;
		if (down) dy++;
		if (left) dx--;
		if (right) dx++;

		if (anim % 24 == 23) spaceFree = true;

		// Move the player if its position will change, set walking flag accordingly
		if (dx != 0 || dy != 0) {
			move(dx, dy);
			walking = true;
		} else {
			walking = false;
		}
		clear();
		updateShooting(width, height);
	}

	/**
	 * Clears projectiles which have been removed from the level.
	 */
	private void clear() {
		for (int i = 0; i < level.getProjectiles().size(); i++) {
			Projectile p = level.getProjectiles().get(i);
			if (p.isRemoved()) level.getProjectiles().remove(i);
		}
	}

	/**
	 * Creates a new projectile when the player shoots.
	 * @param x : The X-Position of the projectile.
	 * @param y : The Y-Position of the projectile.
	 * @param dir : The direction where the projectile faces.
	 */
	protected void shoot(int x, int y, double dir) {
		Projectile p = new FireballProjectile(x, y, dir);
		level.addProjectile(p);
	}

	/**
	 * Determines if the player is shooting and fires a projectile in the appropriate direction.
	 */
	private void updateShooting(int width, int height) {

		// Shoot when mouse clicks
		if (Mouse.getB() == 1 && fireRate <= 0) {
			double dx = Mouse.getX() - (width / 2);
			double dy = Mouse.getY() - (height / 2);
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
			fireRate = FireballProjectile.FIRE_RATE;
		}
	}

	/**
	 *  Renders the player according to its direction and animation step
	 */
	public void render(Screen screen) {

		// Flip variable (0=none, 1=horizontal, 2=vertical, 3=both)
		int flip = 0;

		// Change the sprite according to the player direction:

		// up
		if (dir == 0) {
			sprite = sprites[0][0];
			if (walking) {
				if (anim % 20 >= 10)
					sprite = sprites[0][1];
				else
					sprite = sprites[0][0];
			}
		}
		// down
		if (dir == 2) {
			sprite = sprites[2][0];
			if (walking) {
				if (anim % 20 >= 10)
					sprite = sprites[2][1];
				else
					sprite = sprites[2][0];
			}
		}
		// right
		if (dir == 1) {
			sprite = sprites[1][0];
			if (walking) {
				if (anim % 20 >= 10)
					sprite = sprites[1][1];
				else
					sprite = sprites[1][0];
			}
		}
		// left
		if (dir == 3) {
			sprite = sprites[1][0];
			if (walking) {
				if (anim % 20 >= 10)
					sprite = sprites[1][1];
				else
					sprite = sprites[1][0];
			}
			flip = 1;
		}

		// Offset the position to center the player
		int xx = x - sprite.SIZE_X / 2;
		int yy = y - sprite.SIZE_Y / 2;

		// Render the player sprite
		screen.renderMob(xx, yy, sprite, flip);
	}

	protected boolean collision(int dx, int dy) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = ((x + dx) + c % 2 * 13 - 7) >> 4;
			int yt = ((y + dy) + c / 2 * 8 + 7) >> 4;
			if (level.getTile(xt, yt).solid()) solid = true;
		}
		return solid;
	}
}
