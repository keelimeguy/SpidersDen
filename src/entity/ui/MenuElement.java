package entity.ui;

import game.Game;
import graphics.Screen;
import graphics.Sprite;
import input.Mouse;

public class MenuElement extends TextField {
	protected boolean clickable = true, press = false, clicked = false, hover = false;
	protected int baseColor, hoverColor;
	protected Sprite clickSprite, baseSprite;

	public MenuElement(int x, int y, Sprite sprite, Border border) {
		super(x, y, sprite, border);
		baseColor = 0xffffff;
		hoverColor = 0xffff00;
		baseSprite = this.sprite;
		clickSprite = this.sprite;
	}

	public MenuElement(int x, int y, Sprite sprite, Border border, Sprite clickSprite) {
		super(x, y, sprite, border);
		baseColor = 0xffffff;
		hoverColor = 0xffff00;
		baseSprite = this.sprite;
		this.clickSprite = new Sprite(width - 2 * borderWidth, height - 2 * borderWidth, clickSprite);
	}

	public void setHoverColor(int hoverColor) {
		this.hoverColor = hoverColor;
	}

	public void click(Game game) {
		game.getTextField().setText(text[0]);
	}

	public void update(Game game) {
		if (hidden) return;
		super.update(game);
		if (game.mouseInBounds(x, y, sprite.SIZE_X, sprite.SIZE_Y)) {
			hover = true;
			if (Mouse.getB() == 1 && clickable && !press) {
				clicked = true;
				press = true;
			}
			if (Mouse.getB() == -1 && clicked == true) {
				click(game);
				clicked = false;
			}
			if (clicked && sprite == baseSprite) {
				sprite = clickSprite;
			}
		} else {
			hover = false;
			if (sprite == clickSprite) sprite = baseSprite;
		}
		if (Mouse.getB() == -1) {
			clicked = false;
			press = false;
		} else
			press = true;

		if (hover) {
			color = hoverColor;
		} else {
			color = baseColor;
		}

		if (!clicked && sprite == clickSprite) {
			sprite = baseSprite;
		}
	}

	public void render(Screen screen) {
		if (hidden) return;
		super.render(screen);
	}

}
