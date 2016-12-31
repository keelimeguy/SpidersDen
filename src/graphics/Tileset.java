package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tileset {

	protected Sprite[] tiles;

	public static Tileset tilesetGroundReal = new Tileset("/Landscape/Textures/tileset_ground_real.png", 16, 32, 4, 6);
	public static Tileset tilesetForest = new Tileset("/Landscape/Textures/tileset_forest.png", 8, 40, 6, 8);

	public Tileset(String path, int tileSize, int numGroups, int tileGroupWidth, int tileGroupHeight) {
		try {
			BufferedImage image = ImageIO.read(Tileset.class.getResource(path));
			tiles = new Sprite[numGroups * tileGroupWidth * tileGroupHeight];
			for (int i = 0; i < tiles.length; i++) {
				tiles[i] = new Sprite(tileSize, 0);

				// System.out.println("test " + i);
				int w = ((i % tileGroupWidth)) * tileSize;
				int h = ((int) Math.floor(i / tileGroupWidth)) * tileSize;
				// System.out.println(w + ", " + h);
				image.getRGB(w, h, tileSize, tileSize, tiles[i].pixels, 0, tileSize);
				tiles[i] = new Sprite(16, 16, tiles[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Sprite[] getTiles() {
		return tiles;
	}
}
