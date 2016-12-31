package entity.mob;

import entity.projectile.FireballProjectile;
import entity.projectile.Projectile;
import entity.ui.StatusBar;
import game.Game;
import graphics.FireballSprite;
import graphics.Screen;
import graphics.SpiderSprite;
import graphics.Sprite;
import input.Mouse;
import input.ai.AI;
import level.tile.SolidType;

public class Spider extends Mob {
	private AI input;
	private Sprite[][] sprites;
	private StatusBar healthBar;
	private int anim = 0, deadAnim = 0, deadTime = 180, attackingSpeed = 1, dyingSpeed = 1, damage = 10;
	private boolean walking = false, spaceFree = false, powered = false;
	private boolean attacking = false, attacked = false, dying = false, dead = false;

	private int fireRate = 0;

	/**
	 * Creates a Spider at a specific (x,y) location
	 * @param x : The starting x coordinate (in pixel units)
	 * @param y : The starting y coordinate (in pixel units)
	 * @param input : The Keyboard controller for this Spider
	 */
	public Spider(int x, int y, AI input) {
		input.init(this);
		this.x = x;
		this.y = y;
		this.input = input;
		sprites = SpiderSprite.spiderBlack;
		sprite = sprites[0][0];
		fireRate = FireballProjectile.FIRE_RATE;
		animSpeed = 4;
		attackingSpeed = 6;
		dyingSpeed = 10;
		moveSpeed = 1;
		dead = false;
		maxHealth = 100;
		health = maxHealth;
		healthBar = new StatusBar(x, y, sprite.SIZE_X / 2, 3, maxHealth, true, true);
	}

	public Spider(int x, int y, AI input, boolean test) {
		test();
		input.init(this);
		this.x = x;
		this.y = y;
		this.input = input;
		sprites = SpiderSprite.spiderBlack;
		sprite = sprites[0][0];
		fireRate = FireballProjectile.FIRE_RATE;
		animSpeed = 4;
		attackingSpeed = 6;
		dyingSpeed = 10;
		moveSpeed = 1;
		dead = false;
		maxHealth = 100;
		health = maxHealth;
		healthBar = new StatusBar(x, y, sprite.SIZE_X / 2, 3, maxHealth, true, true);
	}

	public Spider(int x, int y, AI input, Sprite[][] sprites, int maxHealth, int damage) {
		input.init(this);
		this.x = x;
		this.y = y;
		this.input = input;
		this.sprites = sprites;
		sprite = this.sprites[0][0];
		fireRate = FireballProjectile.FIRE_RATE;
		animSpeed = 4;
		attackingSpeed = 6;
		dyingSpeed = 10;
		moveSpeed = 1;
		dead = false;
		this.maxHealth = maxHealth;
		this.damage = damage;
		health = maxHealth;
		healthBar = new StatusBar(x, y, sprite.SIZE_X / 2, 3, maxHealth, true, true);
	}

	public Spider(int x, int y, AI input, Sprite[][] sprites, int maxHealth, int damage, boolean test) {
		input.init(this);
		this.test = test;
		this.x = x;
		this.y = y;
		this.input = input;
		this.sprites = sprites;
		sprite = this.sprites[0][0];
		fireRate = FireballProjectile.FIRE_RATE;
		animSpeed = 4;
		attackingSpeed = 6;
		dyingSpeed = 10;
		moveSpeed = 1;
		dead = false;
		this.maxHealth = maxHealth;
		this.damage = damage;
		health = maxHealth;
		healthBar = new StatusBar(x, y, sprite.SIZE_X / 2, 3, maxHealth, true, true);
	}

	public Spider(int x, int y, AI input, Spider spider) {
		super(x, y, spider);
		input.init(this);
		this.input = input;
		damage = spider.damage;
		sprites = spider.sprites;
		sprite = sprites[0][0];
		fireRate = spider.fireRate;
		attackingSpeed = spider.attackingSpeed;
		dyingSpeed = spider.dyingSpeed;
		dead = false;
		collidable = true;
		healthBar = new StatusBar(x, y, sprite.SIZE_X / 2, 3, maxHealth, true, true);
	}

	/**
	 * Updates the Spider animation and moves the Spider when necessary
	 */
	public void update(Game game) {
		if (hidden) return;

		int width = game.getWindowWidth();
		int height = game.getWindowHeight();

		input.update();

		if (fireRate > 0) fireRate--;

		// Increase the animation step, but don't let it increase indefinitely
		if (anim < 7500)
			anim++;
		else
			anim = 0;

		// Update the change in position when a movement key is pressed
		int dx = 0, dy = 0;

		if (!dying && !attacking && input.ctrl) {
			walking = false;
			attacking = true;
			anim = 0;
		} else if (!attacking && !dying && input.e) {
			walking = false;
			dying = true;
			anim = 0;
			collidable = false;
		} else if (!attacking && !dying) {
			if (input.up) dy--;
			if (input.down) dy++;
			if (input.left) dx--;
			if (input.right) dx++;

			if (input.q)
				powered = true;
			else
				powered = false;

			if (anim % 24 == 23) spaceFree = true;

			if (input.space && spaceFree) {
				spaceFree = false;
				anim = 0;
				if (sprites == SpiderSprite.spiderBlack)
					sprites = SpiderSprite.spiderBlue;
				else if (sprites == SpiderSprite.spiderBlue)
					sprites = SpiderSprite.spiderRed;
				else if (sprites == SpiderSprite.spiderRed)
					sprites = SpiderSprite.spiderSilver;
				else if (sprites == SpiderSprite.spiderSilver)
					sprites = SpiderSprite.spiderBlackDots;
				else if (sprites == SpiderSprite.spiderBlackDots)
					sprites = SpiderSprite.spiderBlueDots;
				else if (sprites == SpiderSprite.spiderBlueDots)
					sprites = SpiderSprite.spiderRedDots;
				else if (sprites == SpiderSprite.spiderRedDots)
					sprites = SpiderSprite.spiderSilverDots;
				else if (sprites == SpiderSprite.spiderSilverDots)
					sprites = SpiderSprite.spiderBlackSwirl;
				else if (sprites == SpiderSprite.spiderBlackSwirl)
					sprites = SpiderSprite.spiderBlueSwirl;
				else if (sprites == SpiderSprite.spiderBlueSwirl)
					//sprites = SpiderSprite.spiderRedSwirl;
					//else if (sprites == SpiderSprite.spiderRedSwirl)
					sprites = SpiderSprite.spiderSilverSwirl;
				else if (sprites == SpiderSprite.spiderSilverSwirl) sprites = SpiderSprite.spiderBlack;
			}

			// Move the Spider if its position will change, set walking flag accordingly
			if (dx != 0 || dy != 0) {
				move(dx * moveSpeed, dy * moveSpeed);
				walking = true;
			} else {
				walking = false;
			}
		}
		clear();
		updateShooting(width, height);
		healthBar.setValue(health);
		healthBar.setX(x - sprite.SIZE_X / 4);
		healthBar.setY(y - sprite.SIZE_Y / 3);
		checkDeath();
	}

	public void checkDeath() {
		if (dead == true) {
			deadAnim++;
			if (deadAnim >= deadTime / 2 && deadAnim % 4 == 0) visible = !visible;
			if (deadAnim >= deadTime) {
				level.addPoints(damage);
				remove();
			}
		}

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
	 * Creates a new projectile when the Spider shoots.
	 * @param x : The X-Position of the projectile.
	 * @param y : The Y-Position of the projectile.
	 * @param dir : The direction where the projectile faces.
	 */
	protected void shoot(int x, int y, double dir) {
		Projectile p = new FireballProjectile(x, y, dir, FireballSprite.fireballRed);
		if (!powered) {
			if (sprites == SpiderSprite.spiderBlack || sprites == SpiderSprite.spiderBlackDots || sprites == SpiderSprite.spiderBlackSwirl)
				p = new FireballProjectile(x, y, dir, FireballSprite.fireballCyan);
			else if (sprites == SpiderSprite.spiderSilver || sprites == SpiderSprite.spiderSilverDots || sprites == SpiderSprite.spiderSilverSwirl)
				p = new FireballProjectile(x, y, dir, FireballSprite.fireballPurple);
			else if (sprites == SpiderSprite.spiderBlue || sprites == SpiderSprite.spiderBlueDots || sprites == SpiderSprite.spiderBlueSwirl)
				p = new FireballProjectile(x, y, dir, FireballSprite.fireballBlue);
			else if (sprites == SpiderSprite.spiderRed || sprites == SpiderSprite.spiderRedDots || sprites == SpiderSprite.spiderRedSwirl) p = new FireballProjectile(x, y, dir, FireballSprite.fireballYellow);
		} else {
			p = new FireballProjectile(x, y, dir, FireballSprite.fireballRedFull);
			if (sprites == SpiderSprite.spiderBlack || sprites == SpiderSprite.spiderBlackDots || sprites == SpiderSprite.spiderBlackSwirl)
				p = new FireballProjectile(x, y, dir, FireballSprite.fireballCyanFull);
			else if (sprites == SpiderSprite.spiderSilver || sprites == SpiderSprite.spiderSilverDots || sprites == SpiderSprite.spiderSilverSwirl)
				p = new FireballProjectile(x, y, dir, FireballSprite.fireballPurpleFull);
			else if (sprites == SpiderSprite.spiderBlue || sprites == SpiderSprite.spiderBlueDots || sprites == SpiderSprite.spiderBlueSwirl)
				p = new FireballProjectile(x, y, dir, FireballSprite.fireballBlueFull);
			else if (sprites == SpiderSprite.spiderRed || sprites == SpiderSprite.spiderRedDots || sprites == SpiderSprite.spiderRedSwirl) p = new FireballProjectile(x, y, dir, FireballSprite.fireballYellowFull);
		}
		level.addProjectile(p);
	}

	/**
	 * Determines if the Spider is shooting and fires a projectile in the appropriate direction.
	 */
	private void updateShooting(int width, int height) {

		// Shoot when mouse clicks
		if (input.q && fireRate <= 0) {
			double dx = Mouse.getX() - (width / 2);
			double dy = Mouse.getY() - (height / 2);
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
			fireRate = FireballProjectile.FIRE_RATE;
		}
	}

	/**
	 *  Renders the Spider according to its direction and animation step
	 */
	public void render(Screen screen) {
		if (hidden) return;
		if (!visible) return;

		// Flip variable (0=none, 1=horizontal, 2=vertical, 3=both)
		int flip = 0;

		// Change the sprite according to the Spider direction:

		// up
		if (dir == 0) {
			sprite = sprites[0][2];
			if (walking) {
				if (anim % (8 * animSpeed) >= 7 * animSpeed)
					sprite = sprites[0][1];
				else if (anim % (8 * animSpeed) >= 6 * animSpeed)
					sprite = sprites[0][0];
				else if (anim % (8 * animSpeed) >= 5 * animSpeed)
					sprite = sprites[0][1];
				else if (anim % (8 * animSpeed) >= 4 * animSpeed)
					sprite = sprites[0][2];
				else if (anim % (8 * animSpeed) >= 3 * animSpeed)
					sprite = sprites[0][3];
				else if (anim % (8 * animSpeed) >= 2 * animSpeed)
					sprite = sprites[0][4];
				else if (anim % (8 * animSpeed) >= 1 * animSpeed)
					sprite = sprites[0][3];
				else
					sprite = sprites[0][2];
			} else if (attacking) {
				if (anim % (4 * attackingSpeed) <= 1 * attackingSpeed)
					sprite = sprites[0][6];
				else if (anim % (4 * attackingSpeed) <= 2 * attackingSpeed)
					sprite = sprites[0][7];
				else if (anim % (4 * attackingSpeed) <= 3 * attackingSpeed) {
					sprite = sprites[0][8];
					if (!attacked) {
						attacked = true;
						Mob target = input.getTarget();
						if (target != null) for (int c = 0; c < 4; c++) {
							int xt = target.getCornerPinX(c, 0, 0, false);
							int yt = target.getCornerPinY(c, 0, 0, false);
							int xxt = target.getEdgePinX(c, 0, 0, false);
							int yyt = target.getEdgePinY(c, 0, 0, false);
							if (level.getTile(xt, yt).equals(level.getTile(((int) x) >> 4, ((int) y) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x) >> 4, ((int) y) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x + 16) >> 4, ((int) y + 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x + 16) >> 4, ((int) y + 16) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x - 16) >> 4, ((int) y - 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x - 16) >> 4, ((int) y - 16) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x + 16) >> 4, ((int) y) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x + 16) >> 4, ((int) y) >> 4))
									|| level.getTile(xt, yt).equals(level.getTile(((int) x - 16) >> 4, ((int) y) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x - 16) >> 4, ((int) y) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x) >> 4, ((int) y + 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x) >> 4, ((int) y + 16) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x) >> 4, ((int) y - 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x) >> 4, ((int) y - 16) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x + 16) >> 4, ((int) y - 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x + 16) >> 4, ((int) y - 16) >> 4))
									|| level.getTile(xt, yt).equals(level.getTile(((int) x - 16) >> 4, ((int) y) >> 4 + 16)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x - 16) >> 4, ((int) y + 16) >> 4))) {
								target.hit(damage);
								break;
							}
						}
					}
				} else {
					sprite = sprites[0][2];
					attacking = false;
					attacked = false;
				}
			} else if (dying) {
				if (!dead && anim % (4 * dyingSpeed) <= 1 * dyingSpeed)
					sprite = sprites[0][10];
				else if (!dead && anim % (4 * dyingSpeed) <= 2 * dyingSpeed)
					sprite = sprites[0][11];
				else if (anim % (4 * dyingSpeed) <= 3 * dyingSpeed || dead && input.e) {
					sprite = sprites[0][12];
					dead = true;
				} else {
					sprite = sprites[0][2];
					dying = false;
					dead = false;
				}
			}
		}
		// down
		if (dir == 2) {
			sprite = sprites[2][2];
			if (walking) {
				if (anim % (8 * animSpeed) >= 7 * animSpeed)
					sprite = sprites[2][1];
				else if (anim % (8 * animSpeed) >= 6 * animSpeed)
					sprite = sprites[2][0];
				else if (anim % (8 * animSpeed) >= 5 * animSpeed)
					sprite = sprites[2][1];
				else if (anim % (8 * animSpeed) >= 4 * animSpeed)
					sprite = sprites[2][2];
				else if (anim % (8 * animSpeed) >= 3 * animSpeed)
					sprite = sprites[2][3];
				else if (anim % (8 * animSpeed) >= 2 * animSpeed)
					sprite = sprites[2][4];
				else if (anim % (8 * animSpeed) >= 1 * animSpeed)
					sprite = sprites[2][3];
				else
					sprite = sprites[2][2];
			} else if (attacking) {
				if (anim % (4 * attackingSpeed) <= 1 * attackingSpeed)
					sprite = sprites[2][6];
				else if (anim % (4 * attackingSpeed) <= 2 * attackingSpeed)
					sprite = sprites[2][7];
				else if (anim % (4 * attackingSpeed) <= 3 * attackingSpeed) {
					sprite = sprites[2][8];
					if (!attacked) {
						attacked = true;
						Mob target = input.getTarget();
						if (target != null) for (int c = 0; c < 4; c++) {
							int xt = target.getCornerPinX(c, 0, 0, false);
							int yt = target.getCornerPinY(c, 0, 0, false);
							int xxt = target.getEdgePinX(c, 0, 0, false);
							int yyt = target.getEdgePinY(c, 0, 0, false);
							if (level.getTile(xt, yt).equals(level.getTile(((int) x) >> 4, ((int) y) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x) >> 4, ((int) y) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x + 16) >> 4, ((int) y + 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x + 16) >> 4, ((int) y + 16) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x - 16) >> 4, ((int) y - 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x - 16) >> 4, ((int) y - 16) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x + 16) >> 4, ((int) y) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x + 16) >> 4, ((int) y) >> 4))
									|| level.getTile(xt, yt).equals(level.getTile(((int) x - 16) >> 4, ((int) y) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x - 16) >> 4, ((int) y) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x) >> 4, ((int) y + 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x) >> 4, ((int) y + 16) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x) >> 4, ((int) y - 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x) >> 4, ((int) y - 16) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x + 16) >> 4, ((int) y - 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x + 16) >> 4, ((int) y - 16) >> 4))
									|| level.getTile(xt, yt).equals(level.getTile(((int) x - 16) >> 4, ((int) y) >> 4 + 16)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x - 16) >> 4, ((int) y + 16) >> 4))) {
								target.hit(damage);
								break;
							}
						}
					}
				} else {
					sprite = sprites[2][2];
					attacking = false;
					attacked = false;
				}
			} else if (dying) {
				if (!dead && anim % (4 * dyingSpeed) <= 1 * dyingSpeed)
					sprite = sprites[2][10];
				else if (!dead && anim % (4 * dyingSpeed) <= 2 * dyingSpeed)
					sprite = sprites[2][11];
				else if (anim % (4 * dyingSpeed) <= 3 * dyingSpeed || dead && input.e) {
					sprite = sprites[2][12];
					dead = true;
				} else {
					sprite = sprites[2][2];
					dying = false;
					dead = false;
				}
			}
		}
		// right
		if (dir == 1) {
			sprite = sprites[3][2];
			if (walking) {
				if (anim % (8 * animSpeed) >= 7 * animSpeed)
					sprite = sprites[3][1];
				else if (anim % (8 * animSpeed) >= 6 * animSpeed)
					sprite = sprites[3][0];
				else if (anim % (8 * animSpeed) >= 5 * animSpeed)
					sprite = sprites[3][1];
				else if (anim % (8 * animSpeed) >= 4 * animSpeed)
					sprite = sprites[3][2];
				else if (anim % (8 * animSpeed) >= 3 * animSpeed)
					sprite = sprites[3][3];
				else if (anim % (8 * animSpeed) >= 2 * animSpeed)
					sprite = sprites[3][4];
				else if (anim % (8 * animSpeed) >= 1 * animSpeed)
					sprite = sprites[3][3];
				else
					sprite = sprites[3][2];
			} else if (attacking) {
				if (anim % (4 * attackingSpeed) <= 1 * attackingSpeed)
					sprite = sprites[3][6];
				else if (anim % (4 * attackingSpeed) <= 2 * attackingSpeed)
					sprite = sprites[3][7];
				else if (anim % (4 * attackingSpeed) <= 3 * attackingSpeed) {
					sprite = sprites[3][8];
					if (!attacked) {
						attacked = true;
						Mob target = input.getTarget();
						if (target != null) for (int c = 0; c < 4; c++) {
							int xt = target.getCornerPinX(c, 0, 0, false);
							int yt = target.getCornerPinY(c, 0, 0, false);
							int xxt = target.getEdgePinX(c, 0, 0, false);
							int yyt = target.getEdgePinY(c, 0, 0, false);
							if (level.getTile(xt, yt).equals(level.getTile(((int) x) >> 4, ((int) y) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x) >> 4, ((int) y) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x + 16) >> 4, ((int) y + 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x + 16) >> 4, ((int) y + 16) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x - 16) >> 4, ((int) y - 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x - 16) >> 4, ((int) y - 16) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x + 16) >> 4, ((int) y) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x + 16) >> 4, ((int) y) >> 4))
									|| level.getTile(xt, yt).equals(level.getTile(((int) x - 16) >> 4, ((int) y) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x - 16) >> 4, ((int) y) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x) >> 4, ((int) y + 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x) >> 4, ((int) y + 16) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x) >> 4, ((int) y - 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x) >> 4, ((int) y - 16) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x + 16) >> 4, ((int) y - 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x + 16) >> 4, ((int) y - 16) >> 4))
									|| level.getTile(xt, yt).equals(level.getTile(((int) x - 16) >> 4, ((int) y) >> 4 + 16)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x - 16) >> 4, ((int) y + 16) >> 4))) {
								target.hit(damage);
								break;
							}
						}
					}
				} else {
					sprite = sprites[3][2];
					attacking = false;
					attacked = false;
				}
			} else if (dying) {
				if (!dead && anim % (4 * dyingSpeed) <= 1 * dyingSpeed)
					sprite = sprites[3][10];
				else if (!dead && anim % (4 * dyingSpeed) <= 2 * dyingSpeed)
					sprite = sprites[3][11];
				else if (anim % (4 * dyingSpeed) <= 3 * dyingSpeed || dead && input.e) {
					sprite = sprites[3][12];
					dead = true;
				} else {
					sprite = sprites[3][2];
					dying = false;
					dead = false;
				}
			}
		}
		// left
		if (dir == 3) {
			sprite = sprites[1][2];
			if (walking) {
				if (anim % (8 * animSpeed) >= 7 * animSpeed)
					sprite = sprites[1][1];
				else if (anim % (8 * animSpeed) >= 6 * animSpeed)
					sprite = sprites[1][0];
				else if (anim % (8 * animSpeed) >= 5 * animSpeed)
					sprite = sprites[1][1];
				else if (anim % (8 * animSpeed) >= 4 * animSpeed)
					sprite = sprites[1][2];
				else if (anim % (8 * animSpeed) >= 3 * animSpeed)
					sprite = sprites[1][3];
				else if (anim % (8 * animSpeed) >= 2 * animSpeed)
					sprite = sprites[1][4];
				else if (anim % (8 * animSpeed) >= 1 * animSpeed)
					sprite = sprites[1][3];
				else
					sprite = sprites[1][2];
			} else if (attacking) {
				if (anim % (4 * attackingSpeed) <= 1 * attackingSpeed)
					sprite = sprites[1][6];
				else if (anim % (4 * attackingSpeed) <= 2 * attackingSpeed)
					sprite = sprites[1][7];
				else if (anim % (4 * attackingSpeed) <= 3 * attackingSpeed) {
					sprite = sprites[1][8];
					if (!attacked) {
						attacked = true;
						Mob target = input.getTarget();
						if (target != null) for (int c = 0; c < 4; c++) {
							int xt = target.getCornerPinX(c, 0, 0, false);
							int yt = target.getCornerPinY(c, 0, 0, false);
							int xxt = target.getEdgePinX(c, 0, 0, false);
							int yyt = target.getEdgePinY(c, 0, 0, false);
							if (level.getTile(xt, yt).equals(level.getTile(((int) x) >> 4, ((int) y) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x) >> 4, ((int) y) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x + 16) >> 4, ((int) y + 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x + 16) >> 4, ((int) y + 16) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x - 16) >> 4, ((int) y - 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x - 16) >> 4, ((int) y - 16) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x + 16) >> 4, ((int) y) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x + 16) >> 4, ((int) y) >> 4))
									|| level.getTile(xt, yt).equals(level.getTile(((int) x - 16) >> 4, ((int) y) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x - 16) >> 4, ((int) y) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x) >> 4, ((int) y + 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x) >> 4, ((int) y + 16) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x) >> 4, ((int) y - 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x) >> 4, ((int) y - 16) >> 4)) || level.getTile(xt, yt).equals(level.getTile(((int) x + 16) >> 4, ((int) y - 16) >> 4)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x + 16) >> 4, ((int) y - 16) >> 4))
									|| level.getTile(xt, yt).equals(level.getTile(((int) x - 16) >> 4, ((int) y) >> 4 + 16)) || level.getTile(xxt, yyt).equals(level.getTile(((int) x - 16) >> 4, ((int) y + 16) >> 4))) {
								target.hit(damage);
								break;
							}
						}
					}
				} else {
					sprite = sprites[1][2];
					attacking = false;
					attacked = false;
				}
			} else if (dying) {
				if (!dead && anim % (4 * dyingSpeed) <= 1 * dyingSpeed)
					sprite = sprites[1][10];
				else if (!dead && anim % (4 * dyingSpeed) <= 2 * dyingSpeed)
					sprite = sprites[1][11];
				else if (anim % (4 * dyingSpeed) <= 3 * dyingSpeed || dead && input.e) {
					sprite = sprites[1][12];
					dead = true;
				} else {
					sprite = sprites[1][2];
					dying = false;
					dead = false;
				}
			}
		}

		// Offset the position to center the Spider
		int xx = x - sprite.SIZE_X / 2;
		int yy = y - sprite.SIZE_Y / 2;

		// Render the Spider sprite
		screen.renderPlayer(xx, yy, sprite, flip);

		if (test) showCollision(screen);
	}

	public void renderTop(Screen screen) {
		if (hidden) return;
		if (!visible) return;
		healthBar.render(screen);
	}

	public void showCollision(Screen screen) {
		int xOff = 0;
		int yOff = 0;
		int dx = 0;
		int dy = 0;
		boolean mirror = false;
		for (int c = 0; c < 4; c++) {
			screen.setPixelScale(0xffffff00, getCornerPinX(c, dx, xOff, mirror) * 16 - screen.getXOffset(), getCornerPinY(c, dy, yOff, mirror) * 16 - screen.getYOffset());
			screen.setPixelScale(0xffffffff, getEdgePinX(c, dx, xOff, mirror) * 16 - screen.getXOffset(), getEdgePinY(c, dy, yOff, mirror) * 16 - screen.getYOffset());
			if (yOff >= 0) {
				if (xOff <= 0) {
					screen.setPixelScale(0xff0000ff, ((x + dx) + (c % 2) * (sprite.SIZE_X / 2 + xOff) - sprite.SIZE_X / 4 - (mirror ? (((c % 2) + 1) % 2) * xOff : 0)) - screen.getXOffset(), ((y + dy) + (c / 2) * (sprite.SIZE_Y / 2 - yOff) - sprite.SIZE_Y / 4 + (mirror && c < 2 ? yOff : 0)) - screen.getYOffset());
					if (c < 2)
						screen.setPixelScale(0xff00ffff, ((x + dx) + xOff / 2 - (mirror ? xOff / 2 : 0)) - screen.getXOffset(), ((y + dy) + ((((c % 2) + 1) % 2) == 0 ? 1 : 0) * sprite.SIZE_Y / 2 - sprite.SIZE_Y / 4 - (c % 2) * yOff + (mirror ? ((c + 1) % 2) * yOff : 0)) - screen.getYOffset());
					else
						screen.setPixelScale(0xff00ffff, ((x + dx) + (((c - 2) % 2) == 0 ? 1 : 0) * (sprite.SIZE_X / 2 + xOff) - sprite.SIZE_X / 4 - (mirror ? ((c - 2) % 2) * xOff : 0)) - screen.getXOffset(), ((y + dy) + sprite.SIZE_Y / 2 - sprite.SIZE_Y / 2 - yOff / 2 + (mirror ? yOff / 2 : 0)) - screen.getYOffset());
				} else {
					if (c < 2)
						screen.setPixelScale(0xff00ffff, ((x + dx) + xOff / 2 - (mirror ? xOff / 2 : 0)) - screen.getXOffset(), ((y + dy) + ((((c % 2) + 1) % 2) == 0 ? 1 : 0) * sprite.SIZE_Y / 2 - sprite.SIZE_Y / 4 - (c % 2) * yOff + (mirror ? ((c + 1) % 2) * yOff : 0)) - screen.getYOffset());
					else
						screen.setPixelScale(0xff00ffff, ((x + dx) + (((c - 2) % 2) == 0 ? 1 : 0) * sprite.SIZE_X / 2 + ((c - 2) % 2) * xOff - sprite.SIZE_X / 4 - (mirror ? ((c - 1) % 2) * xOff : 0)) - screen.getXOffset(), ((y + dy) + sprite.SIZE_Y / 2 - sprite.SIZE_Y / 2 - yOff / 2 + (mirror ? yOff / 2 : 0)) - screen.getYOffset());
					screen.setPixelScale(0xff0000ff, ((x + dx) + (c % 2) * (sprite.SIZE_X / 2 - (mirror ? xOff : 0)) - sprite.SIZE_X / 4 + (((c % 2) + 1) % 2) * xOff) - screen.getXOffset(), ((y + dy) + (c / 2) * (sprite.SIZE_Y / 2 - yOff) - sprite.SIZE_Y / 4 + (mirror && c < 2 ? yOff : 0)) - screen.getYOffset());
				}
			} else {
				if (xOff <= 0) {
					screen.setPixelScale(0xff0000ff, ((x + dx) + (c % 2) * (sprite.SIZE_X / 2 + xOff) - sprite.SIZE_X / 4 - (mirror ? (((c % 2) + 1) % 2) * xOff : 0)) - screen.getXOffset(), ((y + dy) + (c / 2) * sprite.SIZE_Y / 2 - sprite.SIZE_Y / 4 - (((c / 2) + 1) % 2) * yOff + (mirror ? (((c / 2)) % 2) * yOff : 0)) - screen.getYOffset());
					if (c < 2)
						screen.setPixelScale(0xff00ffff, ((x + dx) + xOff / 2 - (mirror ? xOff / 2 : 0)) - screen.getXOffset(), ((y + dy) + ((((c % 2) + 1) % 2) == 0 ? 1 : 0) * sprite.SIZE_Y / 2 - (((c % 2) + 1) % 2) * yOff - sprite.SIZE_Y / 4 + (mirror ? (c % 2) * yOff : 0)) - screen.getYOffset());
					else
						screen.setPixelScale(0xff00ffff, ((x + dx) + (((c - 2) % 2) == 0 ? 1 : 0) * (sprite.SIZE_X / 2 + xOff) - sprite.SIZE_X / 4 - (mirror ? ((c - 2) % 2) * xOff : 0)) - screen.getXOffset(), ((y + dy) + sprite.SIZE_Y / 2 - sprite.SIZE_Y / 2 - yOff / 2 + (mirror ? yOff / 2 : 0)) - screen.getYOffset());
				} else {
					screen.setPixelScale(0xff0000ff, ((x + dx) + (c % 2) * (sprite.SIZE_X / 2 - (mirror ? xOff : 0)) - sprite.SIZE_X / 4 + (((c % 2) + 1) % 2) * xOff) - screen.getXOffset(), ((y + dy) + (c / 2) * sprite.SIZE_Y / 2 - sprite.SIZE_Y / 4 - (((c / 2) + 1) % 2) * yOff + (mirror ? (((c / 2)) % 2) * yOff : 0)) - screen.getYOffset());
					if (c < 2)
						screen.setPixelScale(0xff00ffff, ((x + dx) + xOff / 2 - (mirror ? xOff / 2 : 0)) - screen.getXOffset(), ((y + dy) + ((((c % 2) + 1) % 2) == 0 ? 1 : 0) * sprite.SIZE_Y / 2 - (((c % 2) + 1) % 2) * yOff - sprite.SIZE_Y / 4 + (mirror ? (c % 2) * yOff : 0)) - screen.getYOffset());
					else
						screen.setPixelScale(0xff00ffff, ((x + dx) + (((c - 2) % 2) == 0 ? 1 : 0) * sprite.SIZE_X / 2 + ((c - 2) % 2) * xOff - sprite.SIZE_X / 4 - (mirror ? ((c - 1) % 2) * xOff : 0)) - screen.getXOffset(), ((y + dy) + sprite.SIZE_Y / 2 - sprite.SIZE_Y / 2 - yOff / 2 + (mirror ? yOff / 2 : 0)) - screen.getYOffset());
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
