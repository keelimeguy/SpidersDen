package level.tile;

import graphics.Screen;
import graphics.Sprite;
import graphics.Tileset;

/**
 * My class for tiles with an animated sprite
 */
public class AnimatedTile extends Tile {

	private static final long serialVersionUID = 1L;
	protected int curFrame = 0;
	protected int[] solidType;
	protected Sprite[] sprites;

	/**
	 * Creates a new BasicTile.
	 * @param sprite : The sprite of the tile.
	 * @param solidType : How the player will collide with the tile.
	 */
	public AnimatedTile(Sprite[] sprites, int[] solidFrames) {
		super(sprites[0]);
		this.solidType = solidFrames;
		this.sprites = sprites;
	}

	public AnimatedTile(Sprite[] sprites) {
		super(sprites[0]);
		solidType = new int[sprites.length];
		for (int i = 0; i < sprites.length; i++)
			solidType[i] = -1;
		this.sprites = sprites;
	}

	public AnimatedTile(int x, int y, int width, int height, int[][] groundId, int[][] resId, Tileset tileset, int arrWidth, int curFrame) {
		super(x, y, width, height, groundId[0][x + y * arrWidth], resId[0][x + y * arrWidth], tileset);
		sprites = new Sprite[groundId.length];
		for (int i = 0; i < groundId.length; i++) {
			if (groundId[i][x + y * arrWidth] < tileset.getTiles().length) sprites[i] = tileset.getTiles()[groundId[i][x + y * arrWidth]];
		}
		solidType = new int[resId.length];
		for (int i = 0; i < resId.length; i++)
			solidType[i] = resId[i][x + y * arrWidth];
		this.curFrame = curFrame % sprites.length;
		sprite = sprites[curFrame];
	}

	public void render(int x, int y, Screen screen) {

		// Render in pixel precision not tile precision
		screen.renderTileOver(x << 4, y << 4, this);
	}

	public void update() {

	}

	public boolean solid() {
		return solidType[curFrame] > 0;
	}

	public int solidType() {
		return solidType[curFrame];
	}
}
