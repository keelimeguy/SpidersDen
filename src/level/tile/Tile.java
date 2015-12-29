package level.tile;

import graphics.Screen;
import graphics.Sprite;
import graphics.Tileset;

public class Tile extends BasicTile {
	/**
	 * Creates a new BasicTile.
	 * @param sprite : The sprite of the tile.
	 * @param isSolid : True if the tile will be solid, false otherwise.
	 */
	public Tile(Sprite sprite, boolean isSolid) {
		super(sprite);
		this.isSolid = isSolid;
	}

	public Tile(Sprite sprite) {
		super(sprite);
	}

	public Tile(int x, int y, int width, int height, int groundId, int resId, Tileset tileset) {
		super(x, y, width, height, groundId, resId, tileset);

		if (groundId < tileset.tiles.length) sprite = tileset.tiles[groundId];
		if (resId > 0) isSolid = true;
	}

	public void render(int x, int y, Screen screen) {
		// Render in pixel precision not tile precision
		screen.renderTileOver(x << 4, y << 4, this);
	}

	public boolean solid() {
		return isSolid;
	}
}
