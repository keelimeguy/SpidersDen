package entity.ui.uicontrol;

import entity.ui.Border;
import entity.ui.Menu;
import game.Game;
import graphics.Sprite;

public class InventoryMenu extends Menu {
	protected final static String[] options = new String[] { "", "", "", "", "", "", "", "" };

	public InventoryMenu(int x, int y, int width, int height) {
		super(x, y, new Sprite(1, 1, 0xccff0000), new Border(width, height, null, new Sprite(1, 1, 0x88ffffff), null, null, 0, 30, 0, 0), options);
	}

	public void click(Game game, String option) {
		super.click(game, option);
		if (!option.equals("")) {

		}
	}

	/*public void update(Game game) {
		if (hidden) return;
		super.update(game);
	}
	
	public void render(Screen screen) {
		if (hidden) return;
		if (!visible) return;
		super.render(screen);
	}*/
}
