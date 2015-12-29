package graphics;

import level.tile.Block;
import entity.projectile.Projectile;

public class Screen {

	public int width, height;
	public int[] pixels;

	public int xOffset, yOffset;

	/**
	 * Creates a screen of a given width and height
	 * @param width : Width of the screen
	 * @param height : Height of the screen
	 */
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	/**
	 * Clears the screen to the given color
	 * @param color : Color to clear the screen
	 */
	public void clear(int color) {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}

	/**
	 * Renders a given tile on the screen
	 * @param xp : The x coordinate of the tile (in tile units)
	 * @param yp : The y coordinate of the tile (in tile units)
	 * @param tile : The tile to render
	 */
	public void renderTile(int xp, int yp, Block tile) {

		// Updates the position given the screen offset
		yp -= yOffset;
		xp -= xOffset;

		// Draws the tile pixels to the screen at the appropriate position
		for (int y = 0; y < tile.sprite.SIZE_Y; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE_X; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE_X || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE_X];
			}
		}
	}

	public void renderTileOver(int xp, int yp, Block tile) {

		// Updates the position given the screen offset
		yp -= yOffset;
		xp -= xOffset;

		// Draws the tile pixels to the screen at the appropriate position
		for (int y = 0; y < tile.sprite.SIZE_Y; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE_X; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE_X || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				setPixel(tile.sprite.pixels[x + y * tile.sprite.SIZE_X], xa, ya);
			}
		}
	}

	/**
	 * Renders a given sprite on the screen
	 * @param xp : The x coordinate of the tile (in tile units)
	 * @param yp : The y coordinate of the tile (in tile units)
	 * @param tile : The tile to render
	 */
	public void renderProjectile(int xp, int yp, Projectile p) {

		// Updates the position given the screen offset
		yp -= yOffset;
		xp -= xOffset;

		// Draws the tile pixels to the screen at the appropriate position
		for (int y = 0; y < p.getSpriteSizeY(); y++) {
			int ya = y + yp;
			for (int x = 0; x < p.getSpriteSizeX(); x++) {
				int xa = x + xp;
				if (xa < -p.getSpriteSizeX() || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				setPixel(p.getSprite().pixels[x + y * p.getSpriteSizeX()], xa, ya);
			}
		}
	}

	/**
	 * Renders the player sprite 
	 * @param xp : The x coordinate of the player (in tile units)
	 * @param yp : The y coordinate of the player (in tile units)
	 * @param sprite : The sprite to render
	 * @param flip : How to flip the sprite (none = 0, horizontal = 1, vertical = 2, both ways = 3)
	 */
	public void renderPlayer(int xp, int yp, Sprite sprite, int flip) {

		// Updates the position given the screen offset
		yp -= yOffset;
		xp -= xOffset;

		for (int y = 0; y < sprite.SIZE_Y; y++) {
			int ya = y + yp, ys = y;

			// Flip vertical
			if (flip > 1) ys = sprite.SIZE_Y - 1 - y;

			for (int x = 0; x < sprite.SIZE_X; x++) {
				int xa = x + xp, xs = x;

				// Flip horizontal
				if (flip == 1 || flip == 3) xs = sprite.SIZE_X - 1 - x;

				if (xa < -sprite.SIZE_X || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) continue;

				setPixel(sprite.pixels[xs + ys * sprite.SIZE_X], xa, ya);
			}
		}
	}
	
	public void renderMob(int xp, int yp, Sprite sprite, int flip) {

		// Updates the position given the screen offset
		yp -= yOffset;
		xp -= xOffset;

		for (int y = 0; y < sprite.SIZE_Y; y++) {
			int ya = y + yp, ys = y;

			// Flip vertical
			if (flip > 1) ys = sprite.SIZE_Y - 1 - y;

			for (int x = 0; x < sprite.SIZE_X; x++) {
				int xa = x + xp, xs = x;

				// Flip horizontal
				if (flip == 1 || flip == 3) xs = sprite.SIZE_X - 1 - x;

				if (xa < -sprite.SIZE_X || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) continue;

				setPixel(sprite.pixels[xs + ys * sprite.SIZE_X], xa, ya);
			}
		}
	}

	public void renderSprite(Sprite sprite, int xp, int yp) {
		xp -= xOffset;
		yp -= yOffset;

		for (int y = 0; y < sprite.SIZE_Y; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE_X; x++) {
				int xa = x + xp;
				if (xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) continue;
				setPixel(sprite.pixels[x + y * sprite.SIZE_X], xa, ya);
			}
		}
	}

	public void setPixel(int col, int xa, int ya) {
		// If the color is 0xFF00FF don't render that pixel
		if (col != 0xffff00ff && (col | 0x11ffffff) == 0xffffffff)
			pixels[xa + ya * width] = col;

		else if (col != 0xffff00ff && (col | 0x00ffffff) != 0x00ffffff) {

			float alpha = (col & 0xff000000) | 0x11000000;
			float r = (col & 0xff0000) | 0x110000;
			float g = (col & 0xff00) | 0x1100;
			float b = (col & 0xff) | 0x11;

			float oldcol = pixels[xa + ya * width];
			float oldr = ((int) oldcol & 0xff0000) | 0x110000;
			float oldg = ((int) oldcol & 0xff00) | 0x1100;
			float oldb = ((int) oldcol & 0xff) | 0x11;

			alpha = ((int) alpha >> 24) & 0xff;
			r = (int) r >> 16;
			g = (int) g >> 8;
			oldr = (int) oldr >> 16;
			oldg = (int) oldg >> 8;

			alpha /= 255;

			//System.out.println(alpha + ", " + Integer.toHexString((int) r) + ", " + Integer.toHexString((int) g) + ", " + Integer.toHexString((int) b));

			int newr = (int) (alpha * r + (1 - alpha) * oldr);
			int newg = (int) (alpha * g + (1 - alpha) * oldg);
			int newb = (int) (alpha * b + (1 - alpha) * oldb);

			//System.out.println(Integer.toHexString((int) newr) + ", " + Integer.toHexString((int) newg) + ", " + Integer.toHexString((int) newb));

			pixels[xa + ya * width] = 0xff000000 | ((newr << 16)) | ((newg << 8)) | ((newb));

		}
	}

	/**
	 * Sets the screen offset
	 * @param xOffset : The x offset of the screen
	 * @param yOffset : The y offset of the screen
	 */
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
