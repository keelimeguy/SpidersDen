package entity;

import game.Game;
import graphics.Screen;

import java.util.Random;

import level.Level;

public abstract class Entity {

	protected int x, y;
	protected boolean removed = false, hidden = false, visible = true;
	protected Level level;

	public void update(Game game) {
		if (hidden) return;
	}

	public void render(Screen screen) {
		if (hidden) return;
		if (!visible) return;
	}
	
	public void renderTop(Screen screen) {
		if (hidden) return;
		if (!visible) return;
	}

	/**
	 * Removes the entity from the level
	 */
	public void remove() {
		level = null;
		removed = true;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void show() {
		hidden = false;
		visible = true;
	}

	public void hide() {
		hidden = true;
		visible = false;
	}
	
	public void turnInvisbile() {
		visible = false;
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
		removed = false;
		this.level = level;
	}
}
