package entity.ui.uicontrol;

import entity.ui.Border;
import entity.ui.Menu;
import game.Game;
import graphics.Sprite;

public class SettingsMenu extends Menu {
	protected final static String[] options = new String[] { "" };

	public SettingsMenu(int x, int y, int width, int height) {
		super(x, y, new Sprite(1, 1, 0xccff0000), new Border(width, height, new Sprite(1, 1, 0x88ffff00), new Sprite(1, 1, 0x88ffffff), new Sprite(1, 1, 0x8800ffff), new Sprite(1, 1, 0x8800ff00), 5), options);
	}

	public void click(Game game, String option) {
		super.click(game, option);
		if (option.equals("")) {
		}
	}
}
