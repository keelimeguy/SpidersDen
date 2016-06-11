package level.tile;

import graphics.Screen;
import graphics.Sprite;
import graphics.Tileset;

public class Tile extends BasicTile {
	/**
	 * Creates a new BasicTile.
	 * @param sprite : The sprite of the tile.
	 * @param solidType : How the player will collide with the tile.
	 */
	public Tile(Sprite sprite, int solidType) {
		super(sprite);
		this.solidType = solidType;
	}

	public Tile(Sprite sprite) {
		super(sprite);
	}

	public Tile(int x, int y, int width, int height, int groundId, int resId, Tileset tileset) {
		super(x, y, width, height, groundId, resId, tileset);

		if (groundId < tileset.getTiles().length) sprite = tileset.getTiles()[groundId];
		solidType = resId;
	}

	public void render(int x, int y, Screen screen) {
		// Render in pixel precision not tile precision
		screen.renderTileOver(x << 4, y << 4, this);
	}

	public boolean solid() {
		return solidType > 0;
	}

	public int solidType() {
		return solidType;
	}
}
