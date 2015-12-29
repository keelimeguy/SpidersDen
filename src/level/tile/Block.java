package level.tile;

import graphics.Screen;
import graphics.Sprite;

import java.awt.Rectangle;

public class Block extends Rectangle {
	public static Block voidTile = new BasicTile(Sprite.voidSprite, false);

	public int ResId = -1;
	public int groundId = -1;
	public Sprite sprite;

	public Block(Sprite sprite) {
		this.sprite = sprite;
	}

	public Block(int x, int y, int width, int height, int groundId, int ResId, Sprite sprite) {
		setBounds(x, y, width, height);
		this.ResId = ResId;
		this.groundId = groundId;
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {
	}

	public void update(int anim) {

	}

	public boolean solid() {
		return false;
	}
}
