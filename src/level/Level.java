package level;

import entity.Entity;
import entity.projectile.Projectile;
import game.Game;
import graphics.Screen;
import graphics.Tileset;

import java.util.ArrayList;
import java.util.List;

import level.tile.AnimatedTile;
import level.tile.BasicTile;
import level.tile.Block;
import level.tile.SolidType;

public class Level {

	protected final int FRAMES;
	protected int width, height, curFrame = 0, anim = 0, speed = 20, step = 1;
	protected int[][] tiles, tilesOver, tilesTop, collides, collidable, trueCollidable;
	protected Tileset tileset;

	protected List<EnemySpawner> enemySpawner = new ArrayList<EnemySpawner>();
	protected List<Entity> entities = new ArrayList<Entity>();
	protected List<Projectile> projectiles = new ArrayList<Projectile>();

	public Level(int[][] tiles, int[][] tilesOver, int[][] tilesTop, int[][] collides, int width, int height, Tileset tileset) {
		FRAMES = tilesOver.length;
		this.width = width;
		this.height = height;
		this.tiles = tiles;
		this.tilesOver = tilesOver;
		this.tilesTop = tilesTop;
		this.collides = collides;
		this.tileset = tileset;
		setCollidable();
		setTrueCollidable();
		//generateGraph();
	}

	/**
	 * Creates a new level
	 * @param width : The width of the level (in tile units)
	 * @param height : The height of the level (in tile units)
	 */
	public Level(int width, int height) {
		FRAMES = 1;
		this.width = width;
		this.height = height;
		tiles = new int[1][width * height];
		generateLevel();
		setCollidable();
		setTrueCollidable();
		//generateGraph();
	}

	/**
	 * Creates a level from a resource path
	 * @param path : File path to the image of the level
	 */
	public Level(String path) {
		FRAMES = 1;
		loadLevel(path);
		generateLevel();
		setCollidable();
		setTrueCollidable();
		//generateGraph();
	}

	protected void generateLevel() {
	}

	protected void loadLevel(String path) {
		//URL location = Level.class.getProtectionDomain().getCodeSource().getLocation();
		//File file = new File(location.getFile() + path);
	}

	/**
	 * Gets the projectile list for the level and returns it.
	 * @return A List<Projectile> object, containing the projectiles that have been added into the level
	 */
	public List<Projectile> getProjectiles() {
		return projectiles;
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	protected void setTrueCollidable() {
		ArrayList<int[]> collidable = new ArrayList<int[]>();
		this.trueCollidable = null;
		for (int y = 0; y < 2 * height; y += 2)
			for (int x = 0; x < 2 * width; x += 2) {
				int collideType = collides[0][x / 2 + y / 2 * width];
				if (collideType == SolidType.FULL || collideType == SolidType.LEFT || collideType == SolidType.TOPLEFT || collideType == SolidType.TOPLEFTDIAGONAL || collideType == SolidType.TOP || collideType == SolidType.NOTBOTTOMRIGHT || collideType == SolidType.NOTBOTTOMLEFT || collideType == SolidType.NOTTOPRIGHT) {
					collidable.add(new int[] { x, y });
				}
				if (collideType == SolidType.FULL || collideType == SolidType.RIGHT || collideType == SolidType.TOPRIGHT || collideType == SolidType.TOPRIGHTDIAGONAL || collideType == SolidType.TOP || collideType == SolidType.NOTBOTTOMRIGHT || collideType == SolidType.NOTBOTTOMLEFT || collideType == SolidType.NOTTOPLEFT) {
					collidable.add(new int[] { x + 1, y });
				}
				if (collideType == SolidType.FULL || collideType == SolidType.LEFT || collideType == SolidType.BOTTOMLEFT || collideType == SolidType.TOPRIGHTDIAGONAL || collideType == SolidType.BOTTOM || collideType == SolidType.NOTBOTTOMRIGHT || collideType == SolidType.NOTTOPRIGHT || collideType == SolidType.NOTTOPLEFT) {
					collidable.add(new int[] { x, y + 1 });
				}
				if (collideType == SolidType.FULL || collideType == SolidType.RIGHT || collideType == SolidType.BOTTOMRIGHT || collideType == SolidType.TOPLEFTDIAGONAL || collideType == SolidType.BOTTOM || collideType == SolidType.NOTBOTTOMLEFT || collideType == SolidType.NOTTOPLEFT || collideType == SolidType.NOTTOPRIGHT) {
					collidable.add(new int[] { x + 1, y + 1 });
				}
				this.trueCollidable = new int[collidable.size()][2];
			}
		for (int i = 0; i < collidable.size(); i++) {
			int[] row = collidable.get(i);
			this.trueCollidable[i] = new int[] { row[0], row[1] };
		}
	}

	public int[][] getTrueCollidable() {
		return trueCollidable;
	}

	protected void setCollidable() {
		ArrayList<int[]> collidable = new ArrayList<int[]>();
		this.collidable = null;
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++) {
				int collideType = collides[0][x + y * width];
				if (collideType != SolidType.NONE) {// || collideType == SolidType.TOPLEFTDIAGONAL || collideType == SolidType.TOPRIGHTDIAGONAL || collideType == SolidType.NOTBOTTOMLEFT || collideType == SolidType.NOTBOTTOMRIGHT || collideType == SolidType.NOTTOPLEFT || collideType == SolidType.NOTTOPRIGHT) {
					collidable.add(new int[] { x, y });
				}
				this.collidable = new int[collidable.size()][2];
			}
		for (int i = 0; i < collidable.size(); i++) {
			int[] row = collidable.get(i);
			this.collidable[i] = new int[] { row[0], row[1] };
		}
	}

	public int[][] getCollidable() {
		return collidable;
	}

	public int[][] getCollides() {
		return collides;
	}

	/**
	 * Updates the level by updating every entity within the level.
	 */
	public void update(int xScroll, int yScroll, Game game) {

		// Increase the animation step, but don't let it increase indefinitely
		if (anim < 7500)
			anim++;
		else
			anim = 0;

		if (anim % speed == speed - 1) curFrame += step;
		if (curFrame >= FRAMES) {
			step = -step;
			anim = 0;
			if (FRAMES != 1)
				curFrame = FRAMES - 2;
			else
				curFrame = FRAMES - 1;
		} else if (curFrame < 0) {
			step = -step;
			if (FRAMES != 1)
				curFrame = 1;
			else
				curFrame = 0;
		}

		for (EnemySpawner spawner : enemySpawner)
			spawner.update(game.getPlayer());

		// Determine the corner pins, i.e. the (x,y) values of the tiles in the corners of the viewable screen
		// (In tile units not pixels)
		int x0 = xScroll >> 4;
		int x1 = ((xScroll + game.getScreen().getWidth()) >> 4) + 1;
		int y0 = yScroll >> 4;
		int y1 = ((yScroll + game.getScreen().getHeight()) >> 4) + 1;

		// Renders all the tiles in the viewable screen at their (x,y) positions
		// (In tile units not pixels)
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).update();
				if (getTileOver(x, y) != null) getTileOver(x, y).update();
				if (getTileTop(x, y) != null) getTileTop(x, y).update();
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update(game);
		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update(game);
		}
	}

	protected void time() {
	}

	/**
	 * Renders all the tiles on the screen
	 * @param xScroll : The scroll offset of the screen in the x direction (in pixels)
	 * @param yScroll : The scroll offset of the screen in the y direction (in pixels)
	 * @param screen : The screen to render to
	 */
	public void renderUnder(int xScroll, int yScroll, Screen screen) {

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
	}

	public void renderOver(int xScroll, int yScroll, Screen screen) {

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
				if (getTileOver(x, y) != null) getTileOver(x, y).render(x, y, screen);
			}
		}
	}

	public void renderTop(int xScroll, int yScroll, Screen screen) {

		// Tells the screen how much it is to be offset
		screen.setOffset(xScroll, yScroll);

		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}

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
				if (getTileTop(x, y) != null) getTileTop(x, y).render(x, y, screen);
			}
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
		e.init(this);
	}

	/**
	 * Adds a projectile to the level, separate from other entities
	 * @param p : The projectile to be added.
	 */
	public void addProjectile(Projectile p) {
		projectiles.add(p);
		p.init(this);
	}

	public void addEnemySpawner(EnemySpawner spawner) {
		enemySpawner.add(spawner);
	}

	public void empty() {
		entities.clear();
		projectiles.clear();
		enemySpawner.clear();
	}

	/**
	 * Gets the tile that is at the given position
	 * @param x : The x coordinate of the tile (in tile units)
	 * @param y : The y coordinate of the tile (in tile units)
	 * @return The tile at the given location in the tiles array
	 */
	public Block getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Block.voidTile;
		return new BasicTile(x, y, 16, 16, tiles[0][x + y * width], collides[0][x + y * width], tileset);
	}

	public Block getTileOver(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height || tilesOver[0][x + y * width] < 0) return null;
		return new AnimatedTile(x, y, 16, 16, tilesOver, collides, tileset, width, curFrame);
		//return new BasicTile(x, y, 16, 16, tiles[0][x + y * width], collides[0][x + y * width], tileset);
	}

	public Block getTileTop(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height || tilesTop[0][x + y * width] < 0) return null;
		//return new BasicTile(x, y, 16, 16, tiles[0][x + y * width], collides[0][x + y * width], tileset);
		return new AnimatedTile(x, y, 16, 16, tilesTop, collides, tileset, width, curFrame);
	}
}
