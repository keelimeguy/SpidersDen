package entity.ui.uicontrol;

import entity.Entity;
import entity.ui.Border;
import entity.ui.Menu;
import game.Game;
import graphics.Screen;
import graphics.Sprite;
import input.Keyboard;

public class MenuController extends Entity {
	public static Menu pause = new PauseMenu(2 * Game.width / 6, 2 * Game.height / 9, Game.width - (int) (4 * Game.width / 6), Game.height - (int) (6 * Game.height / 9));
	public static Menu inventory = new InventoryMenu(Game.width / 8, Game.height / 8, Game.width - (int) (4 * Game.width / 6), Game.height - (int) (2 * Game.height / 8));
	public static Menu settings = new SettingsMenu(Game.width / 5, Game.height / 7, Game.width - (int) (2 * Game.width / 5), Game.height - (int) (2 * Game.height / 7));

	protected Keyboard key;
	protected boolean press = false;

	public MenuController() {
		pause.hide();
		inventory.hide();
		settings.hide();
	}

	public void setKeyboard(Keyboard key) {
		this.key = key;
	}

	public void update(Game game) {
		if (hidden) return;
		if (key.enter && !press) {
			press = true;
			if (!game.isPaused()) {
				game.pause(true);
				pause.show();
			} else {
				game.pause(false);
				pause.hide();
				inventory.hide();
				settings.hide();
			}
		} else if (!key.enter) press = false;
		pause.update(game);
		inventory.update(game);
		settings.update(game);
	}

	public void render(Screen screen) {
		if (hidden) return;
		if (!visible) return;
		pause.render(screen);
		inventory.render(screen);
		settings.render(screen);
	}
}
