package entity.ui;

import entity.Entity;
import game.Game;
import graphics.Screen;

public class StatusBar extends Entity {
	protected int width, height;
	protected double maxValue, value;
	protected int fillColor, emptyColor, borderColor;
	protected boolean border, horizontal;

	public StatusBar(int x, int y, int width, int height, double maxValue, boolean border, boolean horizontal) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.maxValue = maxValue;
		this.border = border;
		this.horizontal = horizontal;
		value = 0;
		setColors(0xdd00ff00, 0xddff0000, 0xdd000000);
	}

	public void setValue(double value) {
		if (value < 0)
			this.value = 0;
		else if (value > maxValue)
			this.value = maxValue;
		else
			this.value = value;
	}

	public void setColors(int fillColor, int emptyColor, int borderColor) {
		this.fillColor = fillColor;
		this.emptyColor = emptyColor;
		this.borderColor = borderColor;
	}

	public void update(Game game) {
		if (hidden) return;
	}

	public void render(Screen screen) {
		if (hidden) return;
		if (!visible) return;
		int adj = 0, fill;
		if (border) {
			screen.renderBox(x, y, width, height, borderColor);
			adj = 1;
		}
		if (horizontal) {
			fill = (int) (value / maxValue * (width - 2.0 * adj));
			screen.renderBox(x + adj, y + adj, fill, height - 2 * adj, fillColor);
			screen.renderBox(x + adj + fill, y + adj, width - 2 * adj - fill, height - 2 * adj, emptyColor);
		} else {
			fill = (int) (value / maxValue * (height - 2.0 * adj));
			screen.renderBox(x + adj, y + adj, width - 2 * adj, fill, fillColor);
			screen.renderBox(x + adj, y + adj + fill, width - 2 * adj, height - 2 * adj - fill, emptyColor);
		}
	}
}
