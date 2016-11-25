package entity.ui;

import entity.Entity;
import game.Game;
import graphics.Screen;
import graphics.Sprite;

public class Frame extends Entity {
	protected Sprite sprite;
	protected Border border;
	protected int width, height;
	protected int borderWidth;

	public Frame(int x, int y, Sprite sprite, Border border) {
		this.x = x;
		this.y = y;
		border.setX(x);
		border.setY(y);
		width = border.getWidth();
		height = border.getHeight();
		borderWidth = border.getBorderWidth();
		this.sprite = new Sprite(width - 2 * borderWidth, height - 2 * borderWidth, sprite);
		this.border = border;
	}

	public void update(Game game) {
		if (hidden) return;
	}

	public void render(Screen screen) {
		if (hidden) return;
		border.render(screen);
		screen.renderSpriteFix(sprite, x + borderWidth, y + borderWidth);

	}
}
