package level.tile;

import graphics.Screen;
import graphics.Sprite;
import graphics.Tileset;

public class BasicTile extends Block {

	protected int solidType = SolidType.NONE;

	/**
	 * Creates a new BasicTile.
	 * @param sprite : The sprite of the tile.
	 * @param solidType : How the player will collide with the tile.
	 */
	public BasicTile(Sprite sprite, int solidType) {
		super(sprite);
		this.solidType = solidType;
	}

	public BasicTile(Sprite sprite) {
		super(sprite);
	}

	public BasicTile(int x, int y, int width, int height, int groundId, int resId, Tileset tileset) {
		super(x, y, width, height, groundId, resId, Sprite.voidSprite);

		if (groundId < tileset.getTiles().length) sprite = tileset.getTiles()[groundId];
		solidType = resId;
	}

	public void render(int x, int y, Screen screen) {
		// Render in pixel precision not tile precision
		screen.renderTile(x << 4, y << 4, this);
	}

	public boolean solid() {
		return solidType > 0;
	}

	public int solidType() {
		return solidType;
	}
}
