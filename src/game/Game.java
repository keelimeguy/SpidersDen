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
import entity.ui.Border;
import entity.ui.Menu;
import entity.ui.TextField;
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

	private static int width = 300;
	private static int height = width / 16 * 9;
	private static int scale = 3; // The game will be scaled up by this factor, so the actual window width and height will be the above values times this value
	private static String title = "2DGame";

	private int anim = 0, speed = 20, step = 0;

	private Thread thread;
	private JFrame frame;
	private TextField textField;
	private Menu menu;
	private Keyboard key;
	private Level level;
	private Mob player;
	private boolean running = false, paused = false, press = false;

	private Screen screen;
	private static MusicPlayer snd;
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

		textField = new TextField(10, 3 * height / 4, new Sprite(1, 1, 0x88ff0000), new Border(width - 20, height / 4 - 10, new Sprite(1, 1, 0x88ffff00), new Sprite(1, 1, 0x88ffffff), new Sprite(1, 1, 0x8800ffff), new Sprite(1, 1, 0x8800ff00), 5));
		textField.setText("First line test.\nSecond line test.\nThird line test.");
		//textField.hide();

		String[] options = { "Option 1", "Option 2", "Option 3", "Option 4", "Option 5" };
		menu = new Menu(width / 5, height / 7, new Sprite(1, 1, 0x88ff0000), new Border(3 * width / 5, 5 * height / 7, new Sprite(1, 1, 0x88ffff00), new Sprite(1, 1, 0x88ffffff), new Sprite(1, 1, 0x8800ffff), new Sprite(1, 1, 0x8800ff00), 5), options);
		menu.hide();

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
		level.addEnemySpawner(new SpiderSpawner(new Spider(0, 0, new SpiderAI(level, null, player)), level, 600));
		player.init(level);
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

	public TextField getTextField() {
		return textField;
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
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			snd.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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

		String audioFilePath = "/Res/Music/funky.wav";
		snd.playMusic(audioFilePath, LoopStart.FUNKY, -1);

		requestFocus();

		// The game loop
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			// Limit delay recovery by half a second
			if (delta > 30) delta = 30;

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

		if (anim % speed == speed - 1) step++;
		if (key.enter && !press) {
			press = true;
			if (!paused) {
				paused = true;
				textField.setText("Pause");
				menu.show();
			} else {
				paused = false;
				textField.setText("Unpause");
				menu.hide();
			}
		} else if (!key.enter) press = false;

		if (key.shift && step >= 1 && !paused) {
			step = anim = 0;
			define();
		}

		int xScroll = player.getX() - screen.getWidth() / 2;
		int yScroll = player.getY() - screen.getHeight() / 2;
		key.update();
		if (!paused) {
			player.update(this);
			level.update(xScroll, yScroll, this);
		}
		textField.update(this);
		menu.update(this);
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

		textField.render(screen);
		menu.render(screen);

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
