package graphics;

import game.Game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import level.Level;

public class Tileset {

	public Sprite[] tiles;

	public static Tileset tilesetGroundReal = new Tileset("/Res/Landscape/Textures/tileset_ground_real.png", 16, 32, 4, 6);
	public static Tileset tilesetForest = new Tileset("/Res/Landscape/Textures/tileset_forest.png", 8, 40, 6, 8);

	public Tileset(String path, int tileSize, int numGroups, int tileGroupWidth, int tileGroupHeight) {
		try {
			URL location = Game.class.getProtectionDomain().getCodeSource().getLocation();
			File file = new File(location.getFile());
			BufferedImage image = ImageIO.read(new File(file.getParentFile() + path));
			//BufferedImage image = ImageIO.read(Game.class.getResource(path));
			tiles = new Sprite[numGroups * tileGroupWidth * tileGroupHeight];
			for (int i = 0; i < tiles.length; i++) {
				tiles[i] = new Sprite(tileSize, 0);

				//System.out.println("test " + i);
				int w = ((i % tileGroupWidth)) * tileSize;
				int h = ((int) Math.floor(i / tileGroupWidth)) * tileSize;
				System.out.println(w + ", " + h);
				image.getRGB(w, h, tileSize, tileSize, tiles[i].pixels, 0, tileSize);
				tiles[i] = new Sprite(16, 16, tiles[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
