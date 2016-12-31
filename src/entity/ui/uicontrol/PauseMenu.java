package entity.ui.uicontrol;

import entity.ui.Border;
import entity.ui.Menu;
import game.Game;
import graphics.Sprite;
import sound.LoopStart;

public class PauseMenu extends Menu {
	protected final static String[] options = new String[] { "Resume", "About", "Settings", "Quit" };

	public PauseMenu(int x, int y, int width, int height) {
		super(x, y, new Sprite(1, 1, 0xccff0000), new Border(width, height, 0, 0), options);
	}

	public void click(Game game, String option) {
		super.click(game, option);
		if (option.equals("Resume")) {
			game.pause(false);
			hide();
		} else if (option.equals("Inventory")) {
			hide();
			MenuController.inventory.show();
		} else if (option.equals("Settings")) {
			game.getDialogueController().sendDialogue("Changing song..", null);
			if (game.getSound().getPath().equals("/Music/funky.wav")) {
				game.getSound().reset();
				game.getSound().playMusic("/Music/epic.wav", LoopStart.EPIC, -1);
			} else if (game.getSound().getPath().equals("/Music/epic.wav")) {
				game.getSound().reset();
				game.getSound().playMusic("/Music/child.wav", LoopStart.CHILD, -1);
			} else if (game.getSound().getPath().equals("/Music/child.wav")) {
				game.getSound().reset();
				game.getSound().playMusic("/Music/varied_funky.wav", 0, -1);
			} else if (game.getSound().getPath().equals("/Music/varied_funky.wav")) {
				game.getSound().reset();
				game.getSound().playMusic("/Music/spooky.wav", 0, -1);
			} else if (game.getSound().getPath().equals("/Music/spooky.wav")) {
				game.getSound().reset();
				game.getSound().playMusic("/Music/funky.wav", 0, -1);
			}
		} else if (option.equals("Quit")) {
			System.exit(0);
		} else if (option.equals("About")) {
			game.getDialogueController().sendDialogue("This is a personal project by Keelin Wheeler.\nIt is not for sale or distribution.\nFigure out how to play on your own :P", null);
		}
	}
}
