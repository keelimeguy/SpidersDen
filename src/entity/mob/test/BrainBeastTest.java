package entity.mob.test;

import level.tile.SolidType;
import game.Game;
import graphics.EnemySprite;
import graphics.FireballSprite;
import graphics.Screen;
import graphics.Sprite;
import input.Keyboard;
import input.Mouse;
import entity.mob.Mob;
import entity.projectile.FireballProjectile;
import entity.projectile.Projectile;

public class BrainBeastTest extends Mob {

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
	public BrainBeastTest(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprites = EnemySprite.brainBeast;
		sprite = sprites[0][0];
		fireRate = FireballProjectile.FIRE_RATE;
		animSpeed = 10;
		moveSpeed = 1;
	}

	/**
	 * Updates the player animation and moves the player when necessary
	 */
	public void update(Game game) {
		int width = game.getWindowWidth();
		int height = game.getWindowHeight();

		if (fireRate > 0) fireRate--;

		// Increase the animation step, but don't let it increase indefinitely
		if (anim < 7500)
			anim++;
		else
			anim = 0;

		// Update the change in position when a movement key is pressed
		int dx = 0, dy = 0;
		if (input.up) dy--;
		if (input.down) dy++;
		if (input.left) dx--;
		if (input.right) dx++;

		if (anim % 24 == 23) spaceFree = true;

		// Move the player if its position will change, set walking flag accordingly
		if (dx != 0 || dy != 0) {
			move(dx * moveSpeed, dy * moveSpeed);
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
		Projectile p = new FireballProjectile(x, y, dir, FireballSprite.fireballBlackFull);
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
				if (anim % (2 * animSpeed) >= 10 * animSpeed)
					sprite = sprites[0][1];
				else
					sprite = sprites[0][0];
			}
		}
		// down
		if (dir == 2) {
			sprite = sprites[2][0];
			if (walking) {
				if (anim % (2 * animSpeed) >= 1 * animSpeed)
					sprite = sprites[2][1];
				else
					sprite = sprites[2][0];
			}
		}
		// right
		if (dir == 1) {
			sprite = sprites[1][0];
			if (walking) {
				if (anim % (2 * animSpeed) >= 1 * animSpeed)
					sprite = sprites[1][1];
				else
					sprite = sprites[1][0];
			}
		}
		// left
		if (dir == 3) {
			sprite = sprites[1][0];
			if (walking) {
				if (anim % (2 * animSpeed) >= 1 * animSpeed)
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

		showCollision(screen);
	}

	public void showCollision(Screen screen) {
		int xOff = 0;
		int yOff = 0;
		int dx = 0;
		int dy = 0;
		boolean mirror = false;
		for (int c = 0; c < 4; c++) {
			screen.setPixel(0xffffff00, getCornerPinX(c, dx, xOff, mirror) * 16 - screen.getXOffset(), getCornerPinY(c, dy, yOff, mirror) * 16 - screen.getYOffset());
			screen.setPixel(0xffffffff, getEdgePinX(c, dx, xOff, mirror) * 16 - screen.getXOffset(), getEdgePinY(c, dy, yOff, mirror) * 16 - screen.getYOffset());
			if (yOff >= 0) {
				if (xOff <= 0) {
					screen.setPixel(0xff0000ff, ((x + dx) + (c % 2) * (sprite.SIZE_X / 2 + xOff) - sprite.SIZE_X / 4 - (mirror ? (((c % 2) + 1) % 2) * xOff : 0)) - screen.getXOffset(), ((y + dy) + (c / 2) * (sprite.SIZE_Y / 2 - yOff) - sprite.SIZE_Y / 4 + (mirror && c < 2 ? yOff : 0)) - screen.getYOffset());
					if (c < 2)
						screen.setPixel(0xff00ffff, ((x + dx) + xOff / 2 - (mirror ? xOff / 2 : 0)) - screen.getXOffset(), ((y + dy) + (int) Math.pow(0, ((int) ((c % 2) + 1)) % 2) * sprite.SIZE_Y / 2 - sprite.SIZE_Y / 4 - (c % 2) * yOff + (mirror ? ((c + 1) % 2) * yOff : 0)) - screen.getYOffset());
					else
						screen.setPixel(0xff00ffff, ((x + dx) + (int) Math.pow(0, (int) ((c - 2) % 2)) * (sprite.SIZE_X / 2 + xOff) - sprite.SIZE_X / 4 - (mirror ? ((c - 2) % 2) * xOff : 0)) - screen.getXOffset(), ((y + dy) + sprite.SIZE_Y / 2 - sprite.SIZE_Y / 2 - yOff / 2 + (mirror ? yOff / 2 : 0)) - screen.getYOffset());
				} else {
					if (c < 2)
						screen.setPixel(0xff00ffff, ((x + dx) + xOff / 2 - (mirror ? xOff / 2 : 0)) - screen.getXOffset(), ((y + dy) + (int) Math.pow(0, ((int) ((c % 2) + 1)) % 2) * sprite.SIZE_Y / 2 - sprite.SIZE_Y / 4 - (c % 2) * yOff + (mirror ? ((c + 1) % 2) * yOff : 0)) - screen.getYOffset());
					else
						screen.setPixel(0xff00ffff, ((x + dx) + (int) Math.pow(0, (int) ((c - 2) % 2)) * sprite.SIZE_X / 2 + ((c - 2) % 2) * xOff - sprite.SIZE_X / 4 - (mirror ? ((c - 1) % 2) * xOff : 0)) - screen.getXOffset(), ((y + dy) + sprite.SIZE_Y / 2 - sprite.SIZE_Y / 2 - yOff / 2 + (mirror ? yOff / 2 : 0)) - screen.getYOffset());
					screen.setPixel(0xff0000ff, ((x + dx) + (c % 2) * (sprite.SIZE_X / 2 - (mirror ? xOff : 0)) - sprite.SIZE_X / 4 + (((c % 2) + 1) % 2) * xOff) - screen.getXOffset(), ((y + dy) + (c / 2) * (sprite.SIZE_Y / 2 - yOff) - sprite.SIZE_Y / 4 + (mirror && c < 2 ? yOff : 0)) - screen.getYOffset());
				}
			} else {
				if (xOff <= 0) {
					screen.setPixel(0xff0000ff, ((x + dx) + (c % 2) * (sprite.SIZE_X / 2 + xOff) - sprite.SIZE_X / 4 - (mirror ? (((c % 2) + 1) % 2) * xOff : 0)) - screen.getXOffset(), ((y + dy) + (c / 2) * sprite.SIZE_Y / 2 - sprite.SIZE_Y / 4 - (((c / 2) + 1) % 2) * yOff + (mirror ? (((c / 2)) % 2) * yOff : 0)) - screen.getYOffset());
					if (c < 2)
						screen.setPixel(0xff00ffff, ((x + dx) + xOff / 2 - (mirror ? xOff / 2 : 0)) - screen.getXOffset(), ((y + dy) + (int) Math.pow(0, ((int) ((c % 2) + 1)) % 2) * sprite.SIZE_Y / 2 - (((c % 2) + 1) % 2) * yOff - sprite.SIZE_Y / 4 + (mirror ? (c % 2) * yOff : 0)) - screen.getYOffset());
					else
						screen.setPixel(0xff00ffff, ((x + dx) + (int) Math.pow(0, (int) ((c - 2) % 2)) * (sprite.SIZE_X / 2 + xOff) - sprite.SIZE_X / 4 - (mirror ? ((c - 2) % 2) * xOff : 0)) - screen.getXOffset(), ((y + dy) + sprite.SIZE_Y / 2 - sprite.SIZE_Y / 2 - yOff / 2 + (mirror ? yOff / 2 : 0)) - screen.getYOffset());
				} else {
					screen.setPixel(0xff0000ff, ((x + dx) + (c % 2) * (sprite.SIZE_X / 2 - (mirror ? xOff : 0)) - sprite.SIZE_X / 4 + (((c % 2) + 1) % 2) * xOff) - screen.getXOffset(), ((y + dy) + (c / 2) * sprite.SIZE_Y / 2 - sprite.SIZE_Y / 4 - (((c / 2) + 1) % 2) * yOff + (mirror ? (((c / 2)) % 2) * yOff : 0)) - screen.getYOffset());
					if (c < 2)
						screen.setPixel(0xff00ffff, ((x + dx) + xOff / 2 - (mirror ? xOff / 2 : 0)) - screen.getXOffset(), ((y + dy) + (int) Math.pow(0, ((int) ((c % 2) + 1)) % 2) * sprite.SIZE_Y / 2 - (((c % 2) + 1) % 2) * yOff - sprite.SIZE_Y / 4 + (mirror ? (c % 2) * yOff : 0)) - screen.getYOffset());
					else
						screen.setPixel(0xff00ffff, ((x + dx) + (int) Math.pow(0, (int) ((c - 2) % 2)) * sprite.SIZE_X / 2 + ((c - 2) % 2) * xOff - sprite.SIZE_X / 4 - (mirror ? ((c - 1) % 2) * xOff : 0)) - screen.getXOffset(), ((y + dy) + sprite.SIZE_Y / 2 - sprite.SIZE_Y / 2 - yOff / 2 + (mirror ? yOff / 2 : 0)) - screen.getYOffset());
				}
			}
		}
	}

	protected boolean collision(int dx, int dy) {
		for (int c = 0; c < 4; c++) {
			int xOff = 0, yOff = 0;
			boolean mirror = false;
			int xt = getCornerPinX(c, dx, xOff, mirror);
			int yt = getCornerPinY(c, dy, yOff, mirror);
			int xxt = getEdgePinX(c, dx, xOff, mirror);
			int yyt = getEdgePinY(c, dy, yOff, mirror);

			//System.out.println("CORNER");
			switch (level.getTile(xt, yt).solidType()) {
			case SolidType.NONE:
				//System.out.println("NONE");
				break;
			case SolidType.FULL:
				//System.out.println("FULL");
				return true;
			case SolidType.TOP:
				//System.out.println("TOP");
				xOff = 0;
				yOff = -sprite.SIZE_Y / 2 + 16;
				break;
			case SolidType.BOTTOM:
				//System.out.println("BOTTOM");
				xOff = 0;
				yOff = sprite.SIZE_Y / 2 - 16;
				break;
			case SolidType.LEFT:
				//System.out.println("LEFT");
				xOff = sprite.SIZE_X / 2 - 16;
				yOff = 0;
				break;
			case SolidType.RIGHT:
				//System.out.println("RIGHT");
				xOff = -sprite.SIZE_X / 2 + 16;
				yOff = 0;
				break;
			case SolidType.TOPLEFT:
				//System.out.println("TOPLEFT");
				xOff = sprite.SIZE_X / 2 - 16;
				yOff = -sprite.SIZE_Y / 2 + 16;
				break;
			case SolidType.BOTTOMLEFT:
				//System.out.println("BOTTOMLEFT");
				xOff = sprite.SIZE_X / 2 - 16;
				yOff = sprite.SIZE_Y / 2 - 16;
				break;
			case SolidType.TOPRIGHT:
				//System.out.println("TOPRIGHT");
				xOff = -sprite.SIZE_X / 2 + 16;
				yOff = -sprite.SIZE_Y / 2 + 16;
				break;
			case SolidType.BOTTOMRIGHT:
				//System.out.println("BOTTOMRIGHT");
				xOff = -sprite.SIZE_X / 2 + 16;
				yOff = sprite.SIZE_Y / 2 - 16;
				break;
			case SolidType.NOTTOPLEFT:
				//System.out.println("NOTTOPLEFT");
				xOff = -sprite.SIZE_X / 2 + 16;
				yOff = sprite.SIZE_Y / 2 - 16;
				break;
			case SolidType.NOTBOTTOMLEFT:
				//System.out.println("NOTBOTTOMLEFT");
				xOff = -sprite.SIZE_X / 2 + 16;
				yOff = -sprite.SIZE_Y / 2 + 16;
				break;
			case SolidType.NOTTOPRIGHT:
				//System.out.println("NOTTOPRIGHT");
				xOff = sprite.SIZE_X / 2 - 16;
				yOff = sprite.SIZE_Y / 2 - 16;
				break;
			case SolidType.NOTBOTTOMRIGHT:
				//System.out.println("NOTBOTTOMRIGHT");
				xOff = sprite.SIZE_X / 2 - 16;
				yOff = -sprite.SIZE_Y / 2 + 16;
				break;
			case SolidType.TOPLEFTDIAGONAL:
				//System.out.println("TOPLEFTDIAGONAL");
				xOff = 16;
				yOff = 16;
				mirror = true;
				break;
			case SolidType.TOPRIGHTDIAGONAL:
				//System.out.println("TOPRIGHTDIAGONAL");
				xOff = 16;
				yOff = 16;
				mirror = true;
				break;
			}
			xt = getCornerPinX(c, dx, xOff, mirror);
			yt = getCornerPinY(c, dy, yOff, mirror);
			//System.out.println(c + "  " + xt + ", " + xt + " " + level.getTile(xt, yt).solid());
			if (level.getTile(xt, yt).solid()) return true;

			mirror = false;

			//System.out.println("EDGE");
			switch (level.getTile(xxt, yyt).solidType()) {
			case SolidType.NONE:
				//System.out.println("NONE");
				xOff = 0;
				yOff = 0;
				break;
			case SolidType.FULL:
				//System.out.println("FULL");
				return true;
			case SolidType.TOP:
				//System.out.println("TOP");
				xOff = 0;
				yOff = -sprite.SIZE_Y / 2 + 16;
				break;
			case SolidType.BOTTOM:
				//System.out.println("BOTTOM");
				xOff = 0;
				yOff = sprite.SIZE_Y / 2 - 16;
				break;
			case SolidType.LEFT:
				//System.out.println("LEFT");
				xOff = sprite.SIZE_X / 2 - 16;
				yOff = 0;
				break;
			case SolidType.RIGHT:
				//System.out.println("RIGHT");
				xOff = -sprite.SIZE_X / 2 + 16;
				yOff = 0;
				break;
			case SolidType.TOPLEFT:
				//System.out.println("TOPLEFT");
				xOff = sprite.SIZE_X / 2 - 16;
				yOff = -sprite.SIZE_Y / 2 + 16;
				break;
			case SolidType.BOTTOMLEFT:
				//System.out.println("BOTTOMLEFT");
				xOff = sprite.SIZE_X / 2 - 16;
				yOff = sprite.SIZE_Y / 2 - 16;
				break;
			case SolidType.TOPRIGHT:
				//System.out.println("TOPRIGHT");
				xOff = -sprite.SIZE_X / 2 + 16;
				yOff = -sprite.SIZE_Y / 2 + 16;
				break;
			case SolidType.BOTTOMRIGHT:
				//System.out.println("BOTTOMRIGHT");
				xOff = -sprite.SIZE_X / 2 + 16;
				yOff = sprite.SIZE_Y / 2 - 16;
				break;
			case SolidType.NOTTOPLEFT:
				//System.out.println("NOTTOPLEFT");
				xOff = -sprite.SIZE_X / 2 + 16;
				yOff = sprite.SIZE_Y / 2 - 16;
				break;
			case SolidType.NOTBOTTOMLEFT:
				//System.out.println("NOTBOTTOMLEFT");
				xOff = -sprite.SIZE_X / 2 + 16;
				yOff = -sprite.SIZE_Y / 2 + 16;
				break;
			case SolidType.NOTTOPRIGHT:
				//System.out.println("NOTTOPRIGHT");
				xOff = sprite.SIZE_X / 2 - 16;
				yOff = sprite.SIZE_Y / 2 - 16;
				break;
			case SolidType.NOTBOTTOMRIGHT:
				//System.out.println("NOTBOTTOMRIGHT");
				xOff = sprite.SIZE_X / 2 - 16;
				yOff = -sprite.SIZE_Y / 2 + 16;
				break;
			case SolidType.TOPLEFTDIAGONAL:
				//System.out.println("TOPLEFTDIAGONAL");
				xOff = 16;
				yOff = 16;
				mirror = true;
				break;
			case SolidType.TOPRIGHTDIAGONAL:
				//System.out.println("TOPRIGHTDIAGONAL");
				xOff = 16;
				yOff = 16;
				mirror = true;
				break;
			}
			xxt = getEdgePinX(c, dx, xOff, mirror);
			yyt = getEdgePinY(c, dy, yOff, mirror);
			//System.out.println(c + "  " + xxt + ", " + yyt + " " + level.getTile(xxt, yyt).solid());
			if (level.getTile(xxt, yyt).solid()) return true;
		}
		return false;
	}
}
