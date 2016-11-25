package entity.ui;

import game.Game;
import graphics.Screen;
import graphics.Sprite;

public class Menu extends Frame {
	protected MenuElement[] elements;
	protected int size;

	public Menu(int x, int y, Sprite sprite, Border border, String[] options) {
		super(x, y, sprite, border);
		size = options.length;
		elements = new MenuElement[size];
		for (int i = 0; i < size; i++) {
			elements[i] = new MenuElement(x + borderWidth, y + borderWidth + i * (height - borderWidth * 2) / size, new Sprite(1, 1, 0x22ff33ff), new Border(width - borderWidth * 2, (height - borderWidth * 2) / size, 0xdd000000, 1), new Sprite(1, 1, 0x22117777));
			elements[i].setText(options[i]);
		}
	}

	public void update(Game game) {
		if (hidden) return;
		for (MenuElement element : elements)
			element.update(game);
	}

	public void render(Screen screen) {
		if (hidden) return;
		super.render(screen);
		for (MenuElement element : elements)
			element.render(screen);

	}

}
