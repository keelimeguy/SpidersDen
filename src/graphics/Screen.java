package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import entity.projectile.Projectile;
import entity.ui.FontLibrary;
import level.tile.Block;

public class Screen {

	private BufferedImage image;
	private int width, height, scale;
	private int[] pixels;
	private int[] imagePixels;

	private int xOffset, yOffset;

	/**
	 * Creates a screen of a given width and height
	 * @param width : Width of the screen
	 * @param height : Height of the screen
	 */
	public Screen(int width, int height, int scale) {
		this.width = width;
		this.height = height;
		this.scale = scale;
		pixels = new int[width * height * scale * scale];
		image = new BufferedImage(width * scale, height * scale, BufferedImage.TYPE_INT_RGB);
		imagePixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
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

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getScale() {
		return scale;
	}

	public int[] getPixels() {
		return pixels;
	}

	public int getXOffset() {
		return xOffset;
	}

	public int getYOffset() {
		return yOffset;
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
				for (int scaleOffY = 0; scaleOffY < scale; scaleOffY++) {
					for (int scaleOffX = 0; scaleOffX < scale; scaleOffX++) {
						pixels[(xa * scale + scaleOffX) + (ya * scale + scaleOffY) * width * scale] = tile.sprite.pixels[x + y * tile.sprite.SIZE_X];
					}
				}
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
				for (int scaleOffY = 0; scaleOffY < scale; scaleOffY++) {
					for (int scaleOffX = 0; scaleOffX < scale; scaleOffX++) {
						setPixel(tile.sprite.pixels[x + y * tile.sprite.SIZE_X], xa * scale + scaleOffX, ya * scale + scaleOffY);
					}
				}
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
				for (int scaleOffY = 0; scaleOffY < scale; scaleOffY++) {
					for (int scaleOffX = 0; scaleOffX < scale; scaleOffX++) {
						setPixel(p.getSprite().pixels[x + y * p.getSpriteSizeX()], xa * scale + scaleOffX, ya * scale + scaleOffY);
					}
				}
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

				for (int scaleOffY = 0; scaleOffY < scale; scaleOffY++) {
					for (int scaleOffX = 0; scaleOffX < scale; scaleOffX++) {
						setPixel(sprite.pixels[xs + ys * sprite.SIZE_X], xa * scale + scaleOffX, ya * scale + scaleOffY);
					}
				}
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

				for (int scaleOffY = 0; scaleOffY < scale; scaleOffY++) {
					for (int scaleOffX = 0; scaleOffX < scale; scaleOffX++) {
						setPixel(sprite.pixels[xs + ys * sprite.SIZE_X], xa * scale + scaleOffX, ya * scale + scaleOffY);
					}
				}
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
				for (int scaleOffY = 0; scaleOffY < scale; scaleOffY++) {
					for (int scaleOffX = 0; scaleOffX < scale; scaleOffX++) {
						setPixel(sprite.pixels[x + y * sprite.SIZE_X], xa * scale + scaleOffX, ya * scale + scaleOffY);
					}
				}
			}
		}
	}

	public void renderSpritePreserve(Sprite sprite, int xp, int yp) {
		xp -= xOffset;
		yp -= yOffset;

		for (int y = 0; y < sprite.SIZE_Y; y++) {
			int ya = y + yp * scale;
			for (int x = 0; x < sprite.SIZE_X; x++) {
				int xa = x + xp * scale;
				if (xa >= width * scale || ya < 0 || ya >= height * scale) break;
				if (xa < 0) continue;
				setPixel(sprite.pixels[x + y * sprite.SIZE_X], xa, ya);
			}
		}
	}

	public void renderSpriteFix(Sprite sprite, int xp, int yp) {
		for (int y = 0; y < sprite.SIZE_Y; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE_X; x++) {
				int xa = x + xp;
				if (xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) continue;
				for (int scaleOffY = 0; scaleOffY < scale; scaleOffY++) {
					for (int scaleOffX = 0; scaleOffX < scale; scaleOffX++) {
						setPixel(sprite.pixels[x + y * sprite.SIZE_X], xa * scale + scaleOffX, ya * scale + scaleOffY);
					}
				}
			}
		}
	}

	public void renderText(String text, int xp, int yp, String fontName, float size, int color) {
		xp -= xOffset;
		yp -= yOffset;

		System.arraycopy(pixels, 0, imagePixels, 0, imagePixels.length);

		Graphics2D g = (Graphics2D) image.getGraphics();

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Font font = FontLibrary.getFont(fontName);
		font = font.deriveFont(size);
		g.setFont(font);
		g.setColor(new Color(color));

		g.drawString(text, xp * scale, yp * scale);

		System.arraycopy(imagePixels, 0, pixels, 0, pixels.length);

		g.dispose();
	}

	public void renderTextFix(String text, int xp, int yp, String fontName, float size, int color) {
		System.arraycopy(pixels, 0, imagePixels, 0, imagePixels.length);

		Graphics2D g = (Graphics2D) image.getGraphics();

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Font font = FontLibrary.getFont(fontName);
		font = font.deriveFont(size);

		g.setFont(font);
		g.setColor(new Color(color));

		g.drawString(text, xp * scale, yp * scale);

		System.arraycopy(imagePixels, 0, pixels, 0, pixels.length);

		g.dispose();
	}

	public void renderTextCenter(String text, int xp, int yp, int width, int height, String fontName, float size, int color) {
		xp -= xOffset;
		yp -= yOffset;

		System.arraycopy(pixels, 0, imagePixels, 0, imagePixels.length);

		Graphics2D g = (Graphics2D) image.getGraphics();

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Font font = FontLibrary.getFont(fontName);
		font = font.deriveFont(size);

		FontMetrics metrics = g.getFontMetrics(font);
		int x = xp * scale + (width * scale - metrics.stringWidth(text)) / 2;
		int y = yp * scale + ((height * scale - metrics.getHeight()) / 2) + metrics.getAscent();

		g.setFont(font);
		g.setColor(new Color(color));

		g.drawString(text, x, y);

		System.arraycopy(imagePixels, 0, pixels, 0, pixels.length);

		g.dispose();
	}

	public void renderTextCenterFix(String text, int xp, int yp, int width, int height, String fontName, float size, int color) {

		System.arraycopy(pixels, 0, imagePixels, 0, imagePixels.length);

		Graphics2D g = (Graphics2D) image.getGraphics();

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Font font = FontLibrary.getFont(fontName);
		font = font.deriveFont(size);

		FontMetrics metrics = g.getFontMetrics(font);
		int x = xp * scale + (width * scale - metrics.stringWidth(text)) / 2;
		int y = yp * scale + ((height * scale - metrics.getHeight()) / 2) + metrics.getAscent();

		g.setFont(font);
		g.setColor(new Color(color));

		g.drawString(text, x, y);

		System.arraycopy(imagePixels, 0, pixels, 0, pixels.length);

		g.dispose();
	}

	public void renderBox(int xp, int yp, int width, int height, int color) {
		// Updates the position given the screen offset
		yp -= yOffset;
		xp -= xOffset;

		for (int y = 0; y < height * scale; y++) {
			int ya = y + yp * scale;
			for (int x = 0; x < width * scale; x++) {
				int xa = x + xp * scale;
				if (xa >= this.width * scale || ya < 0 || ya >= this.height * scale) break;
				if (xa < 0) continue;
				pixels[xa + ya * this.width * scale] = color;
			}
		}
	}

	public void renderBoxFix(int xp, int yp, int width, int height, int color) {
		for (int y = 0; y < height * scale; y++) {
			int ya = y + yp * scale;
			for (int x = 0; x < width * scale; x++) {
				int xa = x + xp * scale;
				if (xa >= this.width * scale || ya < 0 || ya >= this.height * scale) break;
				if (xa < 0) continue;
				pixels[xa + ya * this.width * scale] = color;
			}
		}
	}

	public void setPixel(int col, int xa, int ya) {
		// If the color is 0xFF00FF don't render that pixel
		if (xa + ya * width * scale >= pixels.length || xa + ya * width * scale < 0) return;
		if (col != 0xffff00ff && (col | 0x11ffffff) == 0xffffffff)
			pixels[xa + ya * width * scale] = col;

		else if (col != 0xffff00ff && (col | 0x00ffffff) != 0x00ffffff) {

			float alpha = (col & 0xff000000) | 0x11000000;
			float r = (col & 0xff0000) | 0x110000;
			float g = (col & 0xff00) | 0x1100;
			float b = (col & 0xff) | 0x11;

			float oldcol = pixels[xa + ya * width * scale];
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

			pixels[xa + ya * width * scale] = 0xff000000 | ((newr << 16)) | ((newg << 8)) | ((newb));

		}
	}

	public void setPixelScale(int col, int xa, int ya) {
		for (int scaleOffY = 0; scaleOffY < scale; scaleOffY++) {
			for (int scaleOffX = 0; scaleOffX < scale; scaleOffX++) {
				setPixel(col, xa * scale + scaleOffX, ya * scale + scaleOffY);
			}
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
