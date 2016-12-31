package entity.ui;

import entity.Entity;
import game.Game;
import graphics.Screen;
import graphics.Sprite;

public class Frame extends Entity {
	protected Sprite sprite;
	protected Border border;
	protected int width, height;
	protected int borderTopWidth, borderBottomWidth, borderLeftWidth, borderRightWidth;

	public Frame(int x, int y, Sprite sprite, Border border) {
		this.x = x;
		this.y = y;
		border.setX(x);
		border.setY(y);
		width = border.getWidth();
		height = border.getHeight();
		borderTopWidth = border.getBorderTopWidth();
		borderBottomWidth = border.getBorderBottomWidth();
		borderLeftWidth = border.getBorderLeftWidth();
		borderRightWidth = border.getBorderRightWidth();
		this.sprite = new Sprite(width - borderLeftWidth - borderRightWidth, height - borderTopWidth - borderBottomWidth, sprite);
		this.border = border;
	}

	public void update(Game game) {
		if (hidden) return;
	}

	public void render(Screen screen) {
		if (hidden) return;
		if (!visible) return;
		border.render(screen);
		screen.renderSpriteFix(sprite, x + borderLeftWidth, y + borderTopWidth);

	}
}
