package level.tile;

import graphics.Screen;
import graphics.Sprite;
import graphics.Tileset;

public class BasicTile extends Block {

	protected boolean isSolid = false;

	/**
	 * Creates a new BasicTile.
	 * @param sprite : The sprite of the tile.
	 * @param isSolid : True if the tile will be solid, false otherwise.
	 */
	public BasicTile(Sprite sprite, boolean isSolid) {
		super(sprite);
		this.isSolid = isSolid;
	}

	public BasicTile(Sprite sprite) {
		super(sprite);
	}

	public BasicTile(int x, int y, int width, int height, int groundId, int resId, Tileset tileset) {
		super(x, y, width, height, groundId, resId, Sprite.voidSprite);

		if (groundId < tileset.tiles.length) sprite = tileset.tiles[groundId];
		if (resId > 0) isSolid = true;
	}

	public void render(int x, int y, Screen screen) {
		// Render in pixel precision not tile precision
		screen.renderTile(x << 4, y << 4, this);
	}

	public boolean solid() {
		return isSolid;
	}
}
