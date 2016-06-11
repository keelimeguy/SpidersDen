package input.ai;

import java.util.ArrayList;

import level.Level;
import level.tile.SolidType;
import entity.Entity;
import entity.mob.Mob;

public class SpiderAI extends ChaseAI {
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
				ArrayList<int[]> path = AStar.findPath(level.getWidth() * 2, level.getHeight() * 2, mx, my, tx, ty, level.getTrueCollidable(), false);

				//System.out.println(tx + ", " + ty + "     " + (target.getX() >> 4) + ", " + (target.getY() >> 4) + "     " + ((target.getX() + level.getWidth()) >> 4) + ", " + ((target.getY() + level.getHeight()) >> 4) + "     " + level.getCollides()[0][tx + ty * level.getWidth()]);

				if (path != null && !path.isEmpty() && path.size() != 1) {
					int[] next = path.get(path.size() - 2);
					if (next[0] > mx)
						right = true;
					else if (next[0] < mx) left = true;
					if (next[1] > my)
						down = true;
					else if (next[1] < my) up = true;
					if (mx / 2 > 0 && mx / 2 > 0 && level.getCollides()[0][(mx / 2 - 1) + (my / 2 - 1) * level.getWidth()] > 0) {
						if (up && !left) right = true;
					}
					if (mx / 2 < level.getWidth() - 2 && my / 2 < level.getHeight() - 1 && level.getCollides()[0][(mx / 2 + 2) + (my / 2 + 1) * level.getWidth()] > 0) {
						if (right && !down) up = true;
					}
					if (mx / 2 < level.getWidth() - 2 && level.getCollides()[0][(mx / 2 + 2) + (my / 2) * level.getWidth()] > 0) {
						if (right && !up) down = true;
					}
					if (my / 2 < level.getHeight() - 2 && level.getCollides()[0][(mx / 2) + (my / 2 + 2) * level.getWidth()] > 0 || mx / 2 > 0 && my / 2 < level.getHeight() - 2 && level.getCollides()[0][(mx / 2 - 1) + (my / 2 + 2) * level.getWidth()] > 0) {
						if (path.size() > 2 && path.get(path.size() - 3)[0] < mx) {
							if (down && !right) left = true;
						} else {
							if (down && !left) right = true;
						}
					}
					if (mx / 2 < level.getWidth() - 1 && my / 2 < level.getHeight() - 2 && level.getCollides()[0][(mx / 2 + 1) + (my / 2 + 2) * level.getWidth()] > 0) {
						if (down && !right) left = true;
					}
					if (mx / 2 < level.getWidth() - 1 && my / 2 > 0 && level.getCollides()[0][(mx / 2 + 1) + (my / 2 - 1) * level.getWidth()] > 0) {
						if (up && !right) left = true;
					}
					if (mx / 2 > 0 && level.getCollides()[0][(mx / 2 - 1) + (my / 2) * level.getWidth()] > 0) {
						if (left && !up) down = true;
					}
					if (mx / 2 < level.getWidth() - 1 && my / 2 < level.getHeight() - 1 && level.getCollides()[0][(mx / 2 + 1) + (my / 2 + 1) * level.getWidth()] > 0) {
						if (up && !right) left = true;
					}
					if (mx / 2 > 0 && my / 2 < level.getHeight() - 1 && level.getCollides()[0][(mx / 2 - 1) + (my / 2 + 1) * level.getWidth()] > 0) {
						if (left && !down) up = true;
					}
				}
			}
			if (left == false && right == false && up == false && down == false) ctrl = true;
		} else
			ctrl = true;
	}
}
