package game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import entity.mob.Mob;
import entity.mob.Player;
import entity.mob.Spider;
import entity.ui.TextField;
import entity.ui.uicontrol.DialogueController;
import entity.ui.uicontrol.MenuController;
import graphics.Screen;
import graphics.Sprite;
import input.Keyboard;
import input.Mouse;
import input.ai.SpiderAI;
import level.Level;
import level.LevelData;
import level.SpiderSpawner;
import sound.LoopStart;
import sound.MusicPlayer;
import sound.SoundPlayer;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public final static int width = 900 / 2;
	public final static int height = width / 16 * 9;
	public final static int scale = 2; // The game will be scaled up by this factor, so the actual window width and height will be the above values times this value
	public static String title = "Spider's Den";

	private int anim = 0;//, speed = 20, step = 0;

	private Thread thread;
	private JFrame frame;
	private DialogueController dialogueField;
	private TextField textField;
	private MenuController menuController;
	private Keyboard key;
	private Level level;
	private Mob player;
	private boolean running = false, paused = false;

	private Screen screen;
	private static MusicPlayer snd;
	@SuppressWarnings("unused")
	private static SoundPlayer noise;
	// The image which will be drawn in the game window
	private BufferedImage image = new BufferedImage(width * scale, height * scale, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	/**
	 * Initiates the necessary variables of the game
	 */
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		screen = new Screen(width, height, scale);
		frame = new JFrame();
		key = new Keyboard();
		level = LevelData.fire;

		dialogueField = new DialogueController(0, 0, width, height);
		dialogueField.setKeyboard(key);

		menuController = new MenuController();
		menuController.setKeyboard(key);

		define();

		snd = new MusicPlayer();
		noise = new SoundPlayer();

		addKeyListener(key);

		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}

	private void define() {
		player = new Player(3 << 4, 3 << 4, key);
		level.empty();
		level.addEnemySpawner(new SpiderSpawner(new Spider(0, 0, new SpiderAI(level, null, player)), level, 300));
		player.init(level);
		level.init(this);
		level.addPoints(-level.getScore());
	}

	/**
	 * Returns the height of the window with scaling.
	 * @return The width as an int value
	 */
	public int getWindowWidth() {
		return frame.getContentPane().getWidth();
	}

	/**
	 * Returns the height of the window with scaling.
	 * @return The height as an int value
	 */
	public int getWindowHeight() {
		return frame.getContentPane().getHeight();
	}

	public Screen getScreen() {
		return screen;
	}

	public Mob getPlayer() {
		return player;
	}

	public MusicPlayer getSound() {
		return snd;
	}

	public TextField getTextField() {
		return textField;
	}

	public DialogueController getDialogueController() {
		return dialogueField;
	}

	public boolean mouseInBounds(int x, int y, int sizeX, int sizeY) {
		return Mouse.getX() / screen.getScale() > x * getWindowWidth() / (screen.getWidth() * screen.getScale()) && Mouse.getX() / screen.getScale() < (sizeX + x) * getWindowWidth() / (screen.getWidth() * screen.getScale()) && Mouse.getY() / screen.getScale() > y * getWindowHeight() / (screen.getHeight() * screen.getScale()) && Mouse.getY() / screen.getScale() < (sizeY + y) * getWindowHeight() / (screen.getHeight() * screen.getScale());
	}

	/**
	 * Starts the game thread
	 */
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
		snd.start();
	}

	/**
	 * Stops the game thread
	 */
	public synchronized void stop() {
		running = false;
		try {
			snd.reset();
			snd.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void pause(boolean paused) {
		if (level.isGameOver()) {
			this.paused = true;
			return;
		}
		this.paused = paused;
		if (!paused) {
			dialogueField.sendDialogue("Score:\n" + level.getScore(), null);
		}
	}

	public boolean isPaused() {
		return paused;
	}

	/**
	 * Runs the game
	 */
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0, updates = 0;

		String audioFilePath = "/Music/funky.wav";
		snd.playMusic(audioFilePath, LoopStart.FUNKY, -1);

		requestFocus();

		// The game loop
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			// Limit delay recovery to half a second
			if (delta >= 30) delta = 30;

			// Update 60 times a second
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			Graphics g = getGraphics();
			paint(g);
			frames++;

			// Keep track of and display the game's ups and fps every second
			if (System.currentTimeMillis() - timer >= 1000) {
				timer += 1000;
				frame.setTitle(title + " | ups: " + updates + ", fps: " + frames);
				updates = 0;
				frames = 0;
			}
		}

		// If we get out of the game loop stop the game
		stop();
	}

	/**
	 * Update the game
	 */
	public void update() {
		if (anim < 7500)
			anim++;
		else
			anim = 0;

		/*if (anim % speed == speed - 1) step++;

		if (key.shift && step >= 1 && !paused) {
			step = anim = 0;
			define();
		}*/

		if (key.n1) level.setLight(0);
		if (key.n2) level.setLight(1);
		if (key.n3) level.setLight(2);
		if (key.n4) level.setLight(3);
		if (key.n5) level.setLight(4);

		int xScroll = player.getX() - screen.getWidth() / 2;
		int yScroll = player.getY() - screen.getHeight() / 2;
		key.update();
		if (!paused) {
			player.update(this);
			level.update(xScroll, yScroll, this);
		}
		dialogueField.update(this);
		menuController.update(this);
	}

	/**
	 * Render the game
	 */

	public void update(Graphics g) {
	}

	public void paint(Graphics g) {
		// Clear the screen to black before rendering
		screen.clear(0);

		int xScroll = player.getX() - screen.getWidth() / 2;
		int yScroll = player.getY() - screen.getHeight() / 2;

		// Render the level with the given screen offset
		level.renderUnder(xScroll, yScroll, screen);

		//screen.renderBackground(Sprite.spawnMap, -screen.getWidth() / 2, -screen.getHeight() / 2);

		level.renderOver(xScroll, yScroll, screen);

		// Render the player
		player.render(screen);

		level.renderTop(xScroll, yScroll, screen);
		player.renderTop(screen);

		if (Sprite.fogOfWar[level.getLight()] != null) screen.renderSpritePreserve(Sprite.fogOfWar[level.getLight()], player.getX() - Sprite.fogOfWar[level.getLight()].SIZE_X / (2 * scale), player.getY() - Sprite.fogOfWar[level.getLight()].SIZE_Y / (2 * scale));

		screen.renderBoxFix(0, 0, width, height / 8, 0xff000000);
		screen.renderBoxFix(0, 0, width / 8, height, 0xff000000);
		screen.renderBoxFix(width - (int) (width / 8), 0, width / 8, height, 0xff000000);

		dialogueField.render(screen);
		menuController.render(screen);

		// Copy the screen pixels to the image to be drawn
		System.arraycopy(screen.getPixels(), 0, pixels, 0, pixels.length);

		// Draw the image
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
	}

	/**
	 * Start of the program
	 * @param args : Unused default arguments
	 */
	public static void main(String[] args) {
		System.setProperty("sun.awt.noerasebackground", "true");
		// Create the game
		Game game = new Game();
		game.frame.setResizable(true);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		// Start the game
		game.start();
	}
}
