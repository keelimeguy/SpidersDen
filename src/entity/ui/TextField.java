package entity.ui;

import game.Game;
import graphics.Screen;
import graphics.Sprite;

public class TextField extends Frame {
	public static final String LINE_SEPARATOR = "\n";
	protected String[] text;
	protected int size, color, lines;
	public static final int padding = 3;

	public TextField(int x, int y, Sprite sprite, Border border) {
		super(x, y, sprite, border);
		lines = 2;
		size = 6;
		color = 0xffffff;
		text = new String[lines];
		for (int i = 0; i < lines; i++)
			text[i] = "";
	}

	public void setText(String text) {
		if (lines == 1) {
			this.text[0] = text;
			return;
		}
		for (int i = 0; i < lines; i++)
			this.text[i] = "";
		String[] str = text.split(LINE_SEPARATOR);
		this.text[0] = str[0];
		int acum = 0;
		for (int i = 1; i < lines; i++) {
			if (str.length > i - 1) acum += str[i - 1].length() + LINE_SEPARATOR.length();
			if (str.length > i) this.text[i] = str[i];
		}
		if (acum < text.length()) this.text[lines - 1] = text.substring(acum);
	}

	public String getText() {
		String str = "";
		for (String txt : text)
			str += txt + LINE_SEPARATOR;
		str.substring(0, str.length() - LINE_SEPARATOR.length());
		return str;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}

	public void update(Game game) {
		if (hidden) return;
		super.update(game);
	}

	public void render(Screen screen) {
		if (hidden) return;
		super.render(screen);
		for (int i = 0; i < lines; i++) {
			screen.renderTextFix(text[i], x + borderWidth + padding, y + borderWidth + (11 + 12 * i) * size / 12 + padding + i * 2 * padding / 3, FontLibrary.standard, size * screen.getScale(), color);
		}
	}

}
