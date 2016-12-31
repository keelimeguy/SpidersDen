package input.ai;

import java.util.ArrayList;

import level.Level;
import level.tile.SolidType;
import entity.Entity;
import entity.mob.Mob;

public class SpiderAI extends ChaseAI {
	protected int lasttx = -1, lastty = -1, lastmx = -1, lastmy = -1;
	protected ArrayList<int[]> lastPath = null;
	protected boolean first = true, done = true;

	public SpiderAI(Level level, Mob master, Mob target) {
		super(level, master, target);
	}

	public void update() {
		reset();
		if (master.getHealth() <= 0) {
			e = true;
			return;
		}

		int mx = (int) ((2 * master.getX() / 8.0 + master.getSprite().SIZE_X / 16.0) / 2.0 - 2.0);
		int my = (int) ((2 * master.getY() / 8.0 + master.getSprite().SIZE_Y / 16.0) / 2.0 - 2.0);
		int tx = (int) ((2 * target.getX() / 8.0 + target.getSprite().SIZE_X / 16.0) / 2.0 - 1.0);
		int ty = (int) ((2 * target.getY() / 8.0 + target.getSprite().SIZE_Y / 16.0) / 2.0 - 1.0);

		if (tx > mx + 1 || ty > my + 1 || tx < mx - 1 || ty < my - 1) {
			ctrl = false;
			if (tx < 2 * level.getWidth() && ty < 2 * level.getHeight() && tx >= 0 && ty >= 0) {
				ArrayList<int[]> path;
				if (first || tx != lasttx || ty != lastty || !done) {
					first = false;
					if (!done && tx == lasttx && ty == lastty) done = true;
					if (tx != lasttx || ty != lastty) done = false;
					lasttx = tx;
					lastty = ty;

					/*switch (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()]) {
					case SolidType.NONE:
						System.out.println("Before: NONE (" + tx + ", " + ty + ")");
						break;
					case SolidType.TOPLEFT:
						System.out.println("Before: TOPLEFT (" + tx + ", " + ty + ")");
						break;
					case SolidType.TOPRIGHT:
						System.out.println("Before: TOPRIGHT (" + tx + ", " + ty + ")");
						break;
					case SolidType.TOP:
						System.out.println("Before: TOP (" + tx + ", " + ty + ")");
						break;
					case SolidType.BOTTOMLEFT:
						System.out.println("Before: BOTTOMLEFT (" + tx + ", " + ty + ")");
						break;
					case SolidType.LEFT:
						System.out.println("Before: LEFT (" + tx + ", " + ty + ")");
						break;
					case SolidType.TOPRIGHTDIAGONAL:
						System.out.println("Before: TOPRIGHTDIAGONAL (" + tx + ", " + ty + ")");
						break;
					case SolidType.NOTBOTTOMRIGHT:
						System.out.println("Before: NOTBOTTOMRIGHT (" + tx + ", " + ty + ")");
						break;
					case SolidType.BOTTOMRIGHT:
						System.out.println("Before: BOTTOMRIGHT (" + tx + ", " + ty + ")");
						break;
					case SolidType.TOPLEFTDIAGONAL:
						System.out.println("Before: TOPLEFTDIAGONAL (" + tx + ", " + ty + ")");
						break;
					case SolidType.RIGHT:
						System.out.println("Before: RIGHT (" + tx + ", " + ty + ")");
						break;
					case SolidType.NOTBOTTOMLEFT:
						System.out.println("Before: NOTBOTTOMLEFT (" + tx + ", " + ty + ")");
						break;
					case SolidType.BOTTOM:
						System.out.println("Before: BOTTOM (" + tx + ", " + ty + ")");
						break;
					case SolidType.NOTTOPRIGHT:
						System.out.println("Before: NOTTOPRIGHT (" + tx + ", " + ty + ")");
						break;
					case SolidType.NOTTOPLEFT:
						System.out.println("Before: NOTTOPLEFT (" + tx + ", " + ty + ")");
						break;
					case SolidType.FULL:
						System.out.println("Before: FULL (" + tx + ", " + ty + ")");
						break;
					}*/

					if (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.BOTTOM || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.BOTTOMRIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.BOTTOMLEFT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.NOTTOPRIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.NOTTOPLEFT) {
						ty = (int) (((target.getY() / 8.0) + ((2 * target.getY() + level.getHeight()) / 16.0)) / 2.0 - 1.5);
						if (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOPRIGHTDIAGONAL || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOPLEFTDIAGONAL)
							tx = (int) (((target.getX() / 8.0) + ((2 * target.getX() + level.getWidth()) / 16.0)) / 2.0 - 2.5);
						else if (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.RIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.BOTTOMRIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOPRIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.NOTBOTTOMLEFT)
							tx = (int) (((target.getX() / 8.0) + ((2 * target.getX() + level.getWidth()) / 16.0)) / 2.0 - 1.1);
						else if (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.LEFT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.BOTTOMLEFT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOPLEFT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.NOTBOTTOMLEFT) tx = (int) (((target.getX() / 8.0) + ((2 * target.getX() + level.getWidth()) / 16.0)) / 2.0 - 0);
					} else if (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOP || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.RIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.LEFT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOPRIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOPLEFT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.NOTBOTTOMRIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.NOTBOTTOMLEFT) {
						ty = (int) (((target.getY() / 8.0) + ((2 * target.getY() + level.getHeight()) / 16.0)) / 2.0 - 0.0);
						if (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOPRIGHTDIAGONAL || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOPLEFTDIAGONAL)
							tx = (int) (((target.getX() / 8.0) + ((2 * target.getX() + level.getWidth()) / 16.0)) / 2.0 - 2.5);
						else if (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.RIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.BOTTOMRIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOPRIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.NOTBOTTOMLEFT)
							tx = (int) (((target.getX() / 8.0) + ((2 * target.getX() + level.getWidth()) / 16.0)) / 2.0 - 1.1);
						else if (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.LEFT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.BOTTOMLEFT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOPLEFT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.NOTBOTTOMLEFT) tx = (int) (((target.getX() / 8.0) + ((2 * target.getX() + level.getWidth()) / 16.0)) / 2.0 - 0);
					} else {
						if (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOPRIGHTDIAGONAL || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOPLEFTDIAGONAL)
							tx = (int) (((target.getX() / 8.0) + ((2 * target.getX() + level.getWidth()) / 16.0)) / 2.0 - 2.5);
						else if (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.RIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.BOTTOMRIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOPRIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.NOTBOTTOMLEFT)
							tx = (int) (((target.getX() / 8.0) + ((2 * target.getX() + level.getWidth()) / 16.0)) / 2.0 - 1.1);
						else if (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.LEFT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.BOTTOMLEFT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOPLEFT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.NOTBOTTOMLEFT) tx = (int) (((target.getX() / 8.0) + ((2 * target.getX() + level.getWidth()) / 16.0)) / 2.0 - 0);
						if (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.BOTTOM || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.RIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.LEFT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.BOTTOMRIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.BOTTOMLEFT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.NOTTOPRIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.NOTTOPLEFT)
							ty = (int) (((target.getY() / 8.0) + ((2 * target.getY() + level.getHeight()) / 16.0)) / 2.0 - 1.5);
						else if (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOP || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.RIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.LEFT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOPRIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.TOPLEFT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.NOTBOTTOMRIGHT || level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.NOTBOTTOMLEFT) ty = (int) (((target.getY() / 8.0) + ((2 * target.getY() + level.getHeight()) / 16.0)) / 2.0 - 0.0);
					}
					if (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.FULL) {
						tx = (int) (((target.getX() / 8.0) + ((2 * target.getX() + level.getWidth()) / 16.0)) / 2.0 - 1.0);
						ty = (int) (((target.getY() / 8.0) + ((2 * target.getY() + level.getHeight()) / 16.0)) / 2.0 - 1.0);
					}
					if (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] != 0) {
						tx = (int) (((target.getX() / 8.0) + ((2 * target.getX() + level.getWidth()) / 16.0)) / 2.0 - 0.0);
						ty = (int) (((target.getY() / 8.0) + ((2 * target.getY() + level.getHeight()) / 16.0)) / 2.0 - 0.0);
					}
					if (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()] == SolidType.RIGHT) {
						tx = (int) (((target.getX() / 8.0) + ((2 * target.getX() + level.getWidth()) / 16.0)) / 2.0 - 1.0);
						ty = (int) (((target.getY() / 8.0) + ((2 * target.getY() + level.getHeight()) / 16.0)) / 2.0 - 1.0);
					}

					/*switch (level.getCollides()[0][tx / 2 + ty / 2 * level.getWidth()]) {
					case SolidType.NONE:
						System.out.println("After: NONE (" + tx + ", " + ty + ")");
						break;
					case SolidType.TOPLEFT:
						System.out.println("After: TOPLEFT (" + tx + ", " + ty + ")");
						break;
					case SolidType.TOPRIGHT:
						System.out.println("After: TOPRIGHT (" + tx + ", " + ty + ")");
						break;
					case SolidType.TOP:
						System.out.println("After: TOP (" + tx + ", " + ty + ")");
						break;
					case SolidType.BOTTOMLEFT:
						System.out.println("After: BOTTOMLEFT (" + tx + ", " + ty + ")");
						break;
					case SolidType.LEFT:
						System.out.println("After: LEFT (" + tx + ", " + ty + ")");
						break;
					case SolidType.TOPRIGHTDIAGONAL:
						System.out.println("After: TOPRIGHTDIAGONAL (" + tx + ", " + ty + ")");
						break;
					case SolidType.NOTBOTTOMRIGHT:
						System.out.println("After: NOTBOTTOMRIGHT (" + tx + ", " + ty + ")");
						break;
					case SolidType.BOTTOMRIGHT:
						System.out.println("After: BOTTOMRIGHT (" + tx + ", " + ty + ")");
						break;
					case SolidType.TOPLEFTDIAGONAL:
						System.out.println("After: TOPLEFTDIAGONAL (" + tx + ", " + ty + ")");
						break;
					case SolidType.RIGHT:
						System.out.println("After: RIGHT (" + tx + ", " + ty + ")");
						break;
					case SolidType.NOTBOTTOMLEFT:
						System.out.println("After: NOTBOTTOMLEFT (" + tx + ", " + ty + ")");
						break;
					case SolidType.BOTTOM:
						System.out.println("After: BOTTOM (" + tx + ", " + ty + ")");
						break;
					case SolidType.NOTTOPRIGHT:
						System.out.println("After: NOTTOPRIGHT (" + tx + ", " + ty + ")");
						break;
					case SolidType.NOTTOPLEFT:
						System.out.println("After: NOTTOPLEFT (" + tx + ", " + ty + ")");
						break;
					case SolidType.FULL:
						System.out.println("After: FULL (" + tx + ", " + ty + ")");
						break;
					}*/

					path = AStar.findPath(level.getWidth() * 2, level.getHeight() * 2, mx, my, tx, ty, level.getTrueCollidable(), false);
					lastPath = new ArrayList<int[]>(path.size());
					for (int[] item : path) {
						int[] clone = new int[item.length];
						for (int i = 0; i < item.length; i++)
							clone[i] = item[i];
						lastPath.add(clone);
					}
				} else {
					if (lastPath.size() > 2 && (mx != lastmx || my != lastmy)) lastPath.remove(lastPath.size() - 1);
					path = new ArrayList<int[]>(lastPath.size());
					for (int[] item : lastPath) {
						int[] clone = new int[item.length];
						for (int i = 0; i < item.length; i++)
							clone[i] = item[i];
						path.add(clone);
					}

				}
				// System.out.println(tx + ", " + ty + "     " + (target.getX() >> 4) + ", " + (target.getY() >> 4) + "     " + ((target.getX() + level.getWidth()) >> 4) + ", " + ((target.getY() + level.getHeight()) >> 4) + "     " + level.getCollides()[0][tx + ty * level.getWidth()]);

				if (path != null && !path.isEmpty() && path.size() != 1) {
					int[] next = path.get(path.size() - 2);
					if (next[0] > mx)
						right = true;
					else if (next[0] < mx) left = true;
					if (next[1] > my)
						down = true;
					else if (next[1] < my) up = true;
					if (mx / 2 - 1 >= 0 && my / 2 - 1 >= 0 && level.getCollides()[0][(mx / 2 - 1) + (my / 2 - 1) * level.getWidth()] > 0) {
						if (up && !left) {
							right = true;
							done = false;
						}
					}
					if (mx / 2 < level.getWidth() - 2 && my / 2 < level.getHeight() - 1 && level.getCollides()[0][(mx / 2 + 2) + (my / 2 + 1) * level.getWidth()] > 0) {
						if (right && !down) {
							up = true;
							done = false;
						}
					}
					if (mx / 2 < level.getWidth() - 2 && level.getCollides()[0][(mx / 2 + 2) + (my / 2) * level.getWidth()] > 0) {
						if (right && !up) {
							down = true;
							done = false;
						}
					}
					if (my / 2 < level.getHeight() - 2 && level.getCollides()[0][(mx / 2) + (my / 2 + 2) * level.getWidth()] > 0 || mx / 2 > 0 && my / 2 < level.getHeight() - 2 && level.getCollides()[0][(mx / 2 - 1) + (my / 2 + 2) * level.getWidth()] > 0) {
						if (path.size() > 2 && path.get(path.size() - 3)[0] < mx) {
							if (down && !right) {
								left = true;
								done = false;
							}
						} else {
							if (down && !left) {
								right = true;
								done = false;
							}
						}
					}
					if (mx / 2 < level.getWidth() - 1 && my / 2 < level.getHeight() - 2 && level.getCollides()[0][(mx / 2 + 1) + (my / 2 + 2) * level.getWidth()] > 0) {
						if (down && !right) {
							left = true;
							done = false;
						}
					}
					if (mx / 2 < level.getWidth() - 1 && my / 2 > 0 && level.getCollides()[0][(mx / 2 + 1) + (my / 2 - 1) * level.getWidth()] > 0) {
						if (up && !right) {
							left = true;
							done = false;
						}
					}
					if (mx / 2 > 0 && level.getCollides()[0][(mx / 2 - 1) + (my / 2) * level.getWidth()] > 0) {
						if (left && !up) {
							down = true;
							done = false;
						}
					}
					if (mx / 2 < level.getWidth() - 1 && my / 2 < level.getHeight() - 1 && level.getCollides()[0][(mx / 2 + 1) + (my / 2 + 1) * level.getWidth()] > 0) {
						if (up && !right) {
							left = true;
							done = false;
						}
					}
					if (mx / 2 > 0 && my / 2 < level.getHeight() - 1 && level.getCollides()[0][(mx / 2 - 1) + (my / 2 + 1) * level.getWidth()] > 0) {
						if (left && !down) {
							up = true;
							done = false;
						}
					}
					lastmx = mx;
					lastmy = my;

					/*	int dy=0,dx=0;
						if(up)dy--;
						if(down)dy++;
						if(left)dx--;
						if(right)dx++;
						master.move(dx, dy);
					
						int nmx = (int) ((2 * master.getX() / 8.0 + master.getSprite().SIZE_X / 16.0) / 2.0 - 2.0);
						int nmy = (int) ((2 * master.getY() / 8.0 + master.getSprite().SIZE_Y / 16.0) / 2.0 - 2.0);
						
						if (nmx != lastmx || nmy != lastmy)
							lastPath.remove(lastPath.size() - 1);
						lastmx = mx;
						lastmy = my;
					*/}
			} else
				first = true;

			if (left == false && right == false && up == false && down == false) ctrl = true;
		} else {
			ctrl = true;
			first = true;
		}
	}
}
