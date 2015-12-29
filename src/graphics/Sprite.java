package graphics;

import game.Game;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import level.Level;

public class Sprite {

	public final int SIZE_X, SIZE_Y;
	protected int x, y;
	public int[] pixels;
	protected SpriteSheet sheet;
	protected String path;

	public static Sprite voidSprite = new Sprite(16, 0x1b87e0);

	// Projectile sprites
	public static Sprite fireball_base = new Sprite(60, 0, 0, SpriteSheet.fireball);
	public static Sprite fireball_small = new Sprite(30, 30, fireball_base);
	public static Sprite[] fireball = roll(fireball_small, 12);

	//public static Sprite fireball = new Sprite(60, 0, 0, SpriteSheet.fireball);

	// Spawn level sprites
	public static Sprite spawnMap_base = new Sprite(1600, 0, 0, SpriteSheet.map);
	public static Sprite spawnMap = new Sprite(800, 800, spawnMap_base);

	/**
	 * Creates a sprite from a sprite sheet
	 * @param size : Square size of the sprite (in pixels)
	 * @param x : The x coordinate of the sprite in the sprite sheet (in size units)
	 * @param y : The y coordinate of the sprite in the sprite sheet (in size units)
	 * @param sheet : The sprite sheet to take the sprite image from
	 */
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE_X = SIZE_Y = size;
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		pixels = new int[SIZE_X * SIZE_Y];
		load();
	}

	public Sprite(int sizex, int sizey, int x, int y, SpriteSheet sheet) {
		SIZE_X = sizex;
		SIZE_Y = sizey;
		this.x = x * sizex;
		this.y = y * sizey;
		this.sheet = sheet;
		pixels = new int[SIZE_X * SIZE_Y];
		load();
	}

	/**
	 * Creates a sprite of a given color
	 * @param size : Square size of the sprite (in pixels)
	 * @param color : The color to fill the sprite
	 */
	public Sprite(int size, int color) {
		SIZE_X = SIZE_Y = size;
		pixels = new int[SIZE_X * SIZE_Y];
		setColor(color);
	}

	public Sprite(int sizex, int sizey, int color) {
		SIZE_X = sizex;
		SIZE_Y = sizey;
		pixels = new int[SIZE_X * SIZE_Y];
		setColor(color);
	}

	/**
	 * Creates a sprite from a resource path
	 * @param sizeX : Horizontal size of the sprite (in pixels)
	 * @param sizeY : Vertical size of the sprite (in pixels)
	 * @param path : The path source to take the sprite image from
	 */
	public Sprite(int sizex, int sizey, String path) {
		SIZE_X = sizex;
		SIZE_Y = sizey;
		this.path = path;
		pixels = new int[SIZE_X * SIZE_Y];
		loadFromPath();
	}

	public Sprite(int sizex, int sizey, Sprite sprite) {
		SIZE_X = sizex;
		SIZE_Y = sizey;
		pixels = resizeSprite(sprite, sizex, sizey);
	}

	protected int[] resizeSprite(Sprite sprite, int sizex, int sizey) {
		int[] data = getData(sprite);
		int[] newData = new int[sizex * sizey * 4];
		double scalex = (double) sizex / (double) sprite.SIZE_X;
		double scaley = (double) sizey / (double) sprite.SIZE_Y;
		for (int y = 0; y < sprite.SIZE_Y * scaley; y++)
			for (int x = 0; x < sprite.SIZE_X * scalex; x++) {
				int pxl = y * sizex * 4 + x * 4;
				int near = (int) (y / scaley) * (int) (sizex / scalex) * 4 + (int) (x / scalex) * 4;
				for (int i = 0; i < 4; i++)
					newData[pxl + i] = data[near + i];
			}

		return getPixelsFromData(newData, sizex, sizey);
	}

	protected int[] getData(Sprite sprite) {
		int[] data = new int[sprite.SIZE_X * sprite.SIZE_Y * 4];
		for (int y = 0; y < sprite.SIZE_Y; y++)
			for (int x = 0; x < sprite.SIZE_X; x++) {
				int col = sprite.pixels[x + y * sprite.SIZE_X];
				Color c = new Color(col, true);
				int a = c.getAlpha();
				int r = c.getRed();
				int g = c.getGreen();
				int b = c.getBlue();
				data[y * 4 * sprite.SIZE_X + x * 4] = a;
				data[y * 4 * sprite.SIZE_X + x * 4 + 1] = r;
				data[y * 4 * sprite.SIZE_X + x * 4 + 2] = g;
				data[y * 4 * sprite.SIZE_X + x * 4 + 3] = b;
			}
		return data;
	}

	protected int[] getPixelsFromData(int[] data, int sizex, int sizey) {
		int[] pixels = new int[sizex * sizey];
		for (int y = 0; y < sizey; y++)
			for (int x = 0; x < sizex; x++)
				pixels[y * sizex + x] = (new Color(data[y * sizex * 4 + x * 4 + 1], data[y * sizex * 4 + x * 4 + 2], data[y * sizex * 4 + x * 4 + 3], data[y * sizex * 4 + x * 4]).hashCode());
		return pixels;
	}

	protected static Sprite rotateSprite(Sprite s, double angle) {
		Sprite sprite = new Sprite(s.SIZE_X, s.SIZE_Y, 0);
		sprite.pixels = rotate(s.pixels, s.SIZE_X, s.SIZE_Y, angle);
		return sprite;
	}

	protected static Sprite[] roll(Sprite sprite, int angleStep) {
		Sprite[] sprites = new Sprite[360 / angleStep];
		for (int k = 0; k < 360 / angleStep; k++) {
			sprites[k] = new Sprite(sprite.SIZE_X, sprite.SIZE_Y, 0);
			sprites[k].pixels = rotate(sprite.pixels, sprite.SIZE_X, sprite.SIZE_Y, angleStep * k);
		}
		return sprites;
	}

	protected static int[] rotate(int[] pixels, int width, int height, double angle) {
		int[] result = new int[width * height];

		double nx_x = rotX(-angle, 1.0, 0.0);
		double nx_y = rotY(-angle, 1.0, 0.0);
		double ny_x = rotX(-angle, 0.0, 1.0);
		double ny_y = rotY(-angle, 0.0, 1.0);

		double x0 = rotX(-angle, -width / 2.0, -height / 2.0) + width / 2.0;
		double y0 = rotY(-angle, -width / 2.0, -height / 2.0) + height / 2.0;

		for (int y = 0; y < height; y++) {
			double x1 = x0;
			double y1 = y0;
			for (int x = 0; x < width; x++) {
				int xx = (int) x1;
				int yy = (int) y1;
				int col = 0;
				if (xx < 0 || xx >= width || yy < 0 || yy >= height) {
					col = 0xffff00ff;
				} else {
					col = pixels[xx + yy * width];

				}
				result[x + y * width] = col;
				x1 += nx_x;
				y1 += nx_y;
			}
			x0 += ny_x;
			y0 += ny_y;
		}

		return result;
	}

	protected static double rotX(double angle, double x, double y) {
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		return x * cos + y * -sin;
	}

	protected static double rotY(double angle, double x, double y) {
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		return x * sin + y * cos;
	}

	/**
	 * Fills the sprite with a color
	 * @param color : The color to fill the sprite
	 */
	protected void setColor(int color) {
		for (int i = 0; i < SIZE_X * SIZE_Y; i++) {
			pixels[i] = color;
		}
	}

	/**
	 * Loads the sprite from its sprite sheet
	 */
	protected void load() {
		for (int y = 0; y < SIZE_Y; y++) {
			for (int x = 0; x < SIZE_X; x++) {
				pixels[x + y * SIZE_X] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE_X];
			}
		}
	}

	/**
	 * Loads the sprite from its path
	 */
	protected void loadFromPath() {
		try {
			URL location = Game.class.getProtectionDomain().getCodeSource().getLocation();
			File file = new File(location.getFile());
			BufferedImage image = ImageIO.read(new File(file.getParentFile() + path));
			//BufferedImage image = ImageIO.read(Game.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
