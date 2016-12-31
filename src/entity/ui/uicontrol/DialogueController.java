package entity.ui.uicontrol;

import entity.Entity;
import entity.ui.Border;
import entity.ui.TextField;
import game.Game;
import graphics.Screen;
import graphics.Sprite;
import input.Keyboard;

public class DialogueController extends Entity {
	public static final String TEXT_SEPARATOR = "\\|";
	protected Keyboard key;
	protected TextField textbar;
	protected String[] text;
	protected Sprite portrait;
	protected int width, height;
	protected int portraitX, portraitY, portraitWidth, portraitHeight;
	protected int curLine, anim = 0, speed = 20, step = 0;
	protected boolean done;

	public DialogueController(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.portraitX = x + 2 * width / 3;
		this.portraitY = y + 2 * height / 8;
		this.portraitWidth = width / 3;
		this.portraitHeight = 5 * height / 8;
		textbar = new TextField(x, y + 7 * height / 8, new Sprite(1, 1, 0xff000000), new Border(width, height - (int) (7 * height / 8), 0xff000000, 0));
		portrait = null;
		text = null;
		curLine = -1;
		done = true;
	}

	public void setKeyboard(Keyboard key) {
		this.key = key;
	}

	public void sendDialogue(String text, Sprite portrait) {
		//if (!done) System.out.println("WARNING: DialogueController is not done.");
		if (portrait != null)
			this.portrait = new Sprite(portraitWidth, portraitHeight, portrait);
		else
			portrait = null;
		if (text != null)
			this.text = text.split(TEXT_SEPARATOR);
		else
			this.text = null;
		curLine = 0;
		done = false;
	}

	public void update(Game game) {
		if (hidden) return;
		textbar.update(game);

		if (anim < 5 * speed)
			anim++;
		else
			anim = 0;

		if (anim % speed == speed - 1) step = 1;

		/*if (!done) {
			if (key.space && step >= 1) {
				curLine++;
				step = anim = 0;
			}
			if (curLine >= text.length) {
				curLine = -1;
				done = true;
				text = null;
				portrait = null;
				textbar.setText("");
			}
		}*/

		if (!done) {
			textbar.setText(text[curLine]);
		}
	}

	public void render(Screen screen) {
		if (hidden) return;
		if (!visible) return;
		textbar.render(screen);
		if (portrait != null) screen.renderSpriteFix(portrait, portraitX, portraitY);
	}
}
