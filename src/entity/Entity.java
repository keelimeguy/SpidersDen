package entity;

import game.Game;
import graphics.Screen;

import java.util.Random;

import level.Level;

public abstract class Entity {

	protected int x, y;
	protected boolean removed = false;
	protected Level level;
	protected final Random random = new Random();

	public void update(Game game) {
	}

	public void render(Screen screen) {
	}

	/**
	 * Removes the entity from the level
	 */
	public void remove() {
		removed = true;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/**
	 * Determines if the entity is removed
	 * @return
	 * True if the entity is removed, false otherwise
	 */
	public boolean isRemoved() {
		return removed;
	}

	/**
	 * Initiate the current level for the entity
	 * @param level : The level where the entity will be present
	 * 
	 */
	public void init(Level level) {
		this.level = level;
	}
}
