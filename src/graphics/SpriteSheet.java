package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	protected String path;
	public final int SIZE_X, SIZE_Y;
	protected final int[] pixels;

	public static SpriteSheet flame = new SpriteSheet("/Sprites/flame.png", 384, 256);
	public static SpriteSheet spiderAtk = new SpriteSheet("/Sprites/spider_atk.png", 1024, 768);
	public static SpriteSheet spiderWalk = new SpriteSheet("/Sprites/spider_walk.png", 1280, 768);
	public static SpriteSheet spiderDeath = new SpriteSheet("/Sprites/spider_death.png", 1024, 192);
	public static SpriteSheet devil = new SpriteSheet("/Sprites/devil_sm.png", 96, 96);
	public static SpriteSheet brainBeast = new SpriteSheet("/Sprites/brain_beast.png", 192, 288);
	public static SpriteSheet fireball = new SpriteSheet("/Sprites/fireball_lg.bmp", 300, 60);

	/**
	 * Creates a sprite sheet from a resource path
	 * @param path : File path to image to create sprite sheet from
	 * @param size : Square size of the image to create sprite sheet from
	 */
	public SpriteSheet(String path, int sizex, int sizey) {
		this.path = path;
		SIZE_X = sizex;
		SIZE_Y = sizey;
		pixels = new int[SIZE_X * SIZE_Y];
		load();
	}

	/**
	 * Loads a sprite sheet from the image pointed to by the path
	 */
	protected void load() {

		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
