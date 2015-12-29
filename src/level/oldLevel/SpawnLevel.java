package level.oldLevel;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import level.tile.Block;

public class SpawnLevel extends OldLevel {

	/**
	 * Creates a level from a path
	 * @param path : The file path to the image that the level will be loaded from
	 */
	public SpawnLevel(String path) {
		super(path);
	}

	/**
	 * Load the level from a resource path
	 * @param path : The file path to the image that the level will be loaded from
	 */
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Generate the level based on the loaded image
	 */
	protected void generateLevel() {
	}

	public Block getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Block.voidTile;
		if (tiles[x + y * width] == TileColor.SPAWN_FLOOR) return Block.voidTile;
		if (tiles[x + y * width] == TileColor.SPAWN_GRASS) return Block.voidTile;
		if (tiles[x + y * width] == TileColor.SPAWN_HEDGE) return Block.voidTile;
		if (tiles[x + y * width] == TileColor.SPAWN_BRICK) return Block.voidTile;
		if (tiles[x + y * width] == TileColor.SPAWN_MULTI_BRICK) return Block.voidTile;
		if (tiles[x + y * width] == TileColor.SPAWN_WATER) return Block.voidTile;
		return Block.voidTile;
	}

}
