package game;

import graphics.Screen;
import input.Keyboard;
import input.Mouse;
import input.ai.SpiderAI;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import level.Level;
import level.LevelData;
import sound.LoopStart;
import sound.MusicPlayer;
import sound.SoundPlayer;
import entity.mob.Mob;
import entity.mob.Player;
import entity.mob.Spider;

public class GameTest extends Game implements Runnable {
	private static final long serialVersionUID = 1L;

	private static int width = 300;
	private static int height = width / 16 * 9;
	private static int scale = 3; // The game will be scaled up by this factor, so the actual window width and height will be the above values times this value
	private static String title = "2DGame";

	private int anim = 0, speed = 20, step = 0;

	private Thread thread;
	private JFrame frame;
	private Keyboard key;
	private Level level;
	private Mob player;
	private boolean running = false;

	private Screen screen;
	private static MusicPlayer snd;
	private static SoundPlayer noise;

	// The image which will be drawn in the game window
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	/**
	 * Initiates the necessary variables of the game
	 */
	public GameTest() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		level = LevelData.fire;

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
		player.init(level);
		level.add(new Spider(8 << 4, 7 << 4, new SpiderAI(level, null, player)));
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
		requestFocus();

		String audioFilePath = "/Res/Music/child.wav";
		snd.playMusic(audioFilePath, LoopStart.CHILD, -1);

		// The game loop
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

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
		if (key.shift && step >= 1) {
			if (level == LevelData.test) {
				String audioFilePath = "/Res/Music/epic.wav";
				snd.reset();
				snd.playMusic(audioFilePath, LoopStart.EPIC, -1);
				level = LevelData.fire;
			} else if (level == LevelData.fire) {
				String audioFilePath = "/Res/Music/funky.wav";
				snd.reset();
				snd.playMusic(audioFilePath, LoopStart.FUNKY, -1);
				level = LevelData.water;
			} else if (level == LevelData.water) {
				String audioFilePath = "/Res/Music/child.wav";
				snd.reset();
				snd.playMusic(audioFilePath, LoopStart.CHILD, -1);
				level = LevelData.test;
			}
			step = anim = 0;
			define();
		}
		int xScroll = player.x - screen.getWidth() / 2;
		int yScroll = player.y - screen.getHeight() / 2;
		key.update();
		player.update(this);
		//level.addEnemies();
		level.update(xScroll, yScroll, this);
	}

	/**
	 * Render the game
	 */

	public void update(Graphics g) {
	}

	public void paint(Graphics g) {
		// Clear the screen to black before rendering
		screen.clear(0);

		int xScroll = player.x - screen.getWidth() / 2;
		int yScroll = player.y - screen.getHeight() / 2;

		// Render the level with the given screen offset
		level.renderUnder(xScroll, yScroll, screen);

		//screen.renderBackground(Sprite.spawnMap, -screen.getWidth() / 2, -screen.getHeight() / 2);

		level.renderOver(xScroll, yScroll, screen);

		// Render the player
		player.render(screen);

		level.renderTop(xScroll, yScroll, screen);

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
		GameTest game = new GameTest();
		game.frame.setResizable(true);
		game.frame.setTitle(GameTest.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		// Start the game
		game.start();
	}
}
