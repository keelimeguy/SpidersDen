package level.oldLevel;

import java.util.ArrayList;
import java.util.List;

import level.tile.Block;
import entity.Entity;
import entity.projectile.Projectile;
import game.Game;
import graphics.Screen;

public abstract class OldLevel {

	protected int width, height;
	protected int[] tiles;

	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();

	//public static OldLevel test = new TestLevel();
	public static OldLevel spawn = new SpawnLevel("/levels/spawn.png");

	/**
	 * Creates a new level
	 * @param width : The width of the level (in tile units)
	 * @param height : The height of the level (in tile units)
	 */
	public OldLevel(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}

	/**
	 * Creates a level from a resource path
	 * @param path : File path to the image of the level
	 */
	public OldLevel(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {
	}

	protected void loadLevel(String path) {
	}

	/**
	 * Gets the projectile list for the level and returns it.
	 * @return A List<Projectile> object, containing the projectiles that have been added into the level
	 */
	public List<Projectile> getProjectiles() {
		return projectiles;
	}

	/**
	 * Updates the level by updating every entity within the level.
	 */
	public void update(Game game) {

		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update(game);
		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update(game);
		}
	}

	private void time() {
	}

	/**
	 * Renders all the tiles on the screen
	 * @param xScroll : The scroll offset of the screen in the x direction (in pixels)
	 * @param yScroll : The scroll offset of the screen in the y direction (in pixels)
	 * @param screen : The screen to render to
	 */
	public void render(int xScroll, int yScroll, Screen screen) {

		// Tells the screen how much it is to be offset
		screen.setOffset(xScroll, yScroll);

		// Determine the corner pins, i.e. the (x,y) values of the tiles in the corners of the viewable screen
		// (In tile units not pixels)
		int x0 = xScroll >> 4;
		int x1 = ((xScroll + screen.getWidth()) >> 4) + 1;
		int y0 = yScroll >> 4;
		int y1 = ((yScroll + screen.getHeight()) >> 4) + 1;

		// Renders all the tiles in the viewable screen at their (x,y) positions
		// (In tile units not pixels)
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}

		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
	}

	/**
	 * Adds an entity to the level.
	 * @param e : The entity to be added.
	 */
	public void add(Entity e) {
		entities.add(e);
	}

	/**
	 * Adds a projectile to the level, separate from other entities
	 * @param p : The projectile to be added.
	 */
	public void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	/**
	 * Gets the tile that is at the given position
	 * @param x : The x coordinate of the tile (in tile units)
	 * @param y : The y coordinate of the tile (in tile units)
	 * @return The tile at the given location in the tiles array
	 */
	public Block getTile(int x, int y) {
		return null;
	}
}
