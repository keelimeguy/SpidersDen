package entity.ui;

import game.Game;
import graphics.Screen;
import graphics.Sprite;

public class TextField extends Frame {
	public static final String LINE_SEPARATOR = "\n";
	protected String[] text;
	protected int size, color, lines, maxLines;
	public static final int padding = 5;

	public TextField(int x, int y, Sprite sprite, Border border) {
		super(x, y, sprite, border);
		maxLines = 3;
		lines = maxLines;
		size = 24;
		color = 0xffffff;
		text = new String[maxLines];
		for (int i = 0; i < maxLines; i++)
			text[i] = "";
	}

	public void setText(String text) {
		if (maxLines == 1) {
			this.text[0] = text;
			lines = 1;
			return;
		}
		for (int i = 0; i < maxLines; i++)
			this.text[i] = "";
		String[] str = text.split(LINE_SEPARATOR);
		this.text[0] = str[0];
		lines = 1;
		int acum = 0;
		for (int i = 1; i < maxLines; i++) {
			if (str.length > i - 1) acum += str[i - 1].length() + LINE_SEPARATOR.length();
			if (str.length > i) {
				this.text[i] = str[i];
				lines++;
			}
			;
		}
		if (acum < text.length()) {
			this.text[maxLines - 1] = text.substring(acum);
			lines = maxLines;
		}
	}

	public String getText() {
		String str = "";
		if (text != null && text.length > 0) {
			for (String txt : text)
				str += txt + LINE_SEPARATOR;
			str.substring(0, str.length() - LINE_SEPARATOR.length());
		}
		return str;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public void setMaxLines(int maxLines) {
		this.maxLines = maxLines;
	}

	public void update(Game game) {
		if (hidden) return;
		super.update(game);
	}

	public void render(Screen screen) {
		if (hidden) return;
		if (!visible) return;
		super.render(screen);
		for (int i = 0; i < lines; i++) {
			screen.renderTextCenterFix(text[i], x, y + i * (height - borderTopWidth - borderBottomWidth - 2 * padding / screen.getScale()) / lines + borderTopWidth + padding / screen.getScale(), width, (height - borderTopWidth - borderBottomWidth - 2 * padding / screen.getScale()) / lines, FontLibrary.standard, (size - (lines - 1) * 3), color);
		}
	}

}
