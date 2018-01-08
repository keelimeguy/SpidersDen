package entity.ui;

import java.awt.event.MouseEvent;
import game.Game;
import graphics.Screen;
import graphics.Sprite;
import input.Mouse;

public class MenuElement extends TextField {
	protected Menu parent = null;
	protected boolean clickable = true, press = false, clicked = false, hover = false;
	protected int baseColor, hoverColor;
	protected Sprite clickSprite, baseSprite;
	protected String name;

	public MenuElement(int x, int y, Sprite sprite, Border border, String name, Menu menu) {
		super(x, y, sprite, border);
		baseColor = 0xffffff;
		hoverColor = 0xffff00;
		baseSprite = this.sprite;
		clickSprite = this.sprite;
		parent = menu;
		setText(name);
	}

	public MenuElement(int x, int y, Sprite sprite, Border border, Sprite clickSprite, String name, Menu menu) {
		super(x, y, sprite, border);
		baseColor = 0xffffff;
		hoverColor = 0xffff00;
		baseSprite = this.sprite;
		this.clickSprite = new Sprite(width - borderLeftWidth - borderRightWidth, height - borderTopWidth - borderBottomWidth, clickSprite);
		parent = menu;
		setText(name);
	}

	public void setHoverColor(int hoverColor) {
		this.hoverColor = hoverColor;
	}

	public void setText(String text) {
		super.setText(text);
		this.name = text;
	}

	public void click(Game game) {
		parent.click(game, name);
	}

	public void update(Game game) {
		if (hidden) return;
		super.update(game);
		MouseEvent e = Mouse.getEvent();
		if (e != null && game.mouseEventInBounds(x + borderLeftWidth, this.y + borderTopWidth, sprite.SIZE_X, sprite.SIZE_Y, e)) {
			Mouse.clearEvent();
			click(game);
			clicked = false;
			press = false;
		} else if (game.mouseInBounds(x + borderLeftWidth, y + borderTopWidth, sprite.SIZE_X, sprite.SIZE_Y)) {
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
		if (e == null) {
			if (Mouse.getB() == -1) {
				clicked = false;
				press = false;
			} else
				press = true;
		}

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
		if (!visible) return;
		super.render(screen);
	}
}
