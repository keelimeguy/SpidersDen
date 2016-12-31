package entity.ui;

import entity.Entity;
import game.Game;
import graphics.Screen;
import graphics.Sprite;

public class Border extends Entity {
	protected int width, height;
	protected int borderTopWidth, borderBottomWidth, borderLeftWidth, borderRightWidth;
	protected Sprite top, bottom, left, right;

	public Border(int width, int height, int color, int borderWidth) {
		x = 0;
		y = 0;
		this.width = width;
		this.height = height;
		this.borderTopWidth = borderWidth;
		this.borderBottomWidth = borderWidth;
		this.borderLeftWidth = borderWidth;
		this.borderRightWidth = borderWidth;
		if (borderWidth != 0) {
			this.top = new Sprite(width, borderWidth, color);
			this.bottom = new Sprite(width, borderWidth, color);
			this.left = new Sprite(borderWidth, height - 2 * borderWidth, color);
			this.right = new Sprite(borderWidth, height - 2 * borderWidth, color);
		} else {
			this.top = null;
			this.bottom = null;
			this.left = null;
			this.right = null;
		}
	}

	public Border(int width, int height, Sprite top, Sprite bottom, Sprite left, Sprite right, int borderWidth) {
		x = 0;
		y = 0;
		this.width = width;
		this.height = height;
		this.borderTopWidth = borderWidth;
		this.borderBottomWidth = borderWidth;
		this.borderLeftWidth = borderWidth;
		this.borderRightWidth = borderWidth;
		if (top != null && borderWidth != 0)
			this.top = new Sprite(width, borderWidth, top);
		else
			this.top = null;
		if (bottom != null && borderWidth != 0)
			this.bottom = new Sprite(width, borderWidth, bottom);
		else
			this.bottom = null;
		if (left != null && borderWidth != 0)
			this.left = new Sprite(borderWidth, height - 2 * borderWidth, left);
		else
			this.left = null;
		if (right != null && borderWidth != 0)
			this.right = new Sprite(borderWidth, height - 2 * borderWidth, right);
		else
			this.right = null;
	}

	public Border(int width, int height, Sprite top, Sprite bottom, Sprite left, Sprite right, int borderTopWidth, int borderBottomWidth, int borderLeftWidth, int borderRightWidth) {
		x = 0;
		y = 0;
		this.width = width;
		this.height = height;
		this.borderTopWidth = borderTopWidth;
		this.borderBottomWidth = borderBottomWidth;
		this.borderLeftWidth = borderLeftWidth;
		this.borderRightWidth = borderRightWidth;
		if (top != null && borderTopWidth != 0)
			this.top = new Sprite(width, borderTopWidth, top);
		else
			this.top = null;
		if (bottom != null && borderBottomWidth != 0)
			this.bottom = new Sprite(width, borderBottomWidth, bottom);
		else
			this.bottom = null;
		if (left != null && borderLeftWidth != 0)
			this.left = new Sprite(borderLeftWidth, height - borderTopWidth - borderBottomWidth, left);
		else
			this.left = null;
		if (right != null && borderRightWidth != 0)
			this.right = new Sprite(borderRightWidth, height - borderTopWidth - borderBottomWidth, right);
		else
			this.right = null;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getBorderTopWidth() {
		return borderTopWidth;
	}

	public int getBorderBottomWidth() {
		return borderBottomWidth;
	}

	public int getBorderLeftWidth() {
		return borderLeftWidth;
	}

	public int getBorderRightWidth() {
		return borderRightWidth;
	}

	public void update(Game game) {
		if (hidden) return;
	}

	public void render(Screen screen) {
		if (hidden) return;
		if (!visible) return;
		if (top != null) screen.renderSpriteFix(top, x, y);
		if (bottom != null) screen.renderSpriteFix(bottom, x, y + height - borderBottomWidth);
		if (left != null) screen.renderSpriteFix(left, x, y + borderTopWidth);
		if (right != null) screen.renderSpriteFix(right, x + width - borderRightWidth, y + borderTopWidth);

	}
}
