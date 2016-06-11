package graphics;

import game.Game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import level.Level;

public class SpriteSheet {

	protected String path;
	public final int SIZE_X, SIZE_Y;
	protected final int[] pixels;

	public static SpriteSheet map = new SpriteSheet("/Res/Maps/citybackground.bmp", 1600, 1600);
	public static SpriteSheet flame = new SpriteSheet("/Res/Sprites/flame.png", 384, 256);
	public static SpriteSheet spiderAtk = new SpriteSheet("/Res/Sprites/spider_atk.png", 1024, 768);
	public static SpriteSheet spiderWalk = new SpriteSheet("/Res/Sprites/spider_walk.png", 1280, 768);
	public static SpriteSheet spiderDeath = new SpriteSheet("/Res/Sprites/spider_death.png", 1024, 192);
	public static SpriteSheet devil = new SpriteSheet("/Res/Sprites/devil_sm.png", 96, 96);
	public static SpriteSheet brainBeast = new SpriteSheet("/Res/Sprites/brain_beast.png", 192, 288);
	public static SpriteSheet fireball = new SpriteSheet("/Res/Sprites/fireball_lg.bmp", 300, 60);

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
