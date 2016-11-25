package input.ai;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AStar {
	public static final int DIAGONAL_COST = 14;
	public static final int V_H_COST = 10;
	private static int[][] oldBlocked;

	static class Cell {
		int heuristicCost = 0; //Heuristic cost
		int finalCost = 0; //G+H
		int i, j;
		Cell parent;

		Cell(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "[" + this.i + ", " + this.j + "]";
		}
	}

	//Blocked cells are just null Cell values in grid
	static Cell[][] grid = new Cell[5][5];

	static PriorityQueue<Cell> open;

	static boolean closed[][];
	static int startI, startJ;
	static int endI, endJ;

	public static void setBlocked(int i, int j) {
		grid[i][j] = null;
	}

	public static void setStartCell(int i, int j) {
		startI = i;
		startJ = j;
	}

	public static void setEndCell(int i, int j) {
		endI = i;
		endJ = j;
	}

	static void checkAndUpdateCost(Cell current, Cell t, int cost) {
		if (t == null || closed[t.i][t.j]) return;
		int t_final_cost = t.heuristicCost + cost;

		boolean inOpen = open.contains(t);
		if (!inOpen || t_final_cost < t.finalCost) {
			t.finalCost = t_final_cost;
			t.parent = current;
			if (!inOpen) open.add(t);
		}
	}

	public static void AStar() {

		//add the start location to open list.
		if (grid[startI][startJ] == null) return;
		open.add(grid[startI][startJ]);

		Cell current;

		while (true) {
			current = open.poll();
			if (current == null) break;
			closed[current.i][current.j] = true;

			if (endI < 0 || endJ < 0 || current.equals(grid[endI][endJ])) {
				return;
			}

			Cell t;
			if (current.i - 1 >= 0) {
				t = grid[current.i - 1][current.j];
				checkAndUpdateCost(current, t, current.finalCost + V_H_COST);

				if (current.j - 1 >= 0) {
					t = grid[current.i - 1][current.j - 1];
					checkAndUpdateCost(current, t, current.finalCost + DIAGONAL_COST);
				}

				if (current.j + 1 < grid[0].length) {
					t = grid[current.i - 1][current.j + 1];
					checkAndUpdateCost(current, t, current.finalCost + DIAGONAL_COST);
				}
			}

			if (current.j - 1 >= 0) {
				t = grid[current.i][current.j - 1];
				checkAndUpdateCost(current, t, current.finalCost + V_H_COST);
			}

			if (current.j + 1 < grid[0].length) {
				t = grid[current.i][current.j + 1];
				checkAndUpdateCost(current, t, current.finalCost + V_H_COST);
			}

			if (current.i + 1 < grid.length) {
				t = grid[current.i + 1][current.j];
				checkAndUpdateCost(current, t, current.finalCost + V_H_COST);

				if (current.j - 1 >= 0) {
					t = grid[current.i + 1][current.j - 1];
					checkAndUpdateCost(current, t, current.finalCost + DIAGONAL_COST);
				}

				if (current.j + 1 < grid[0].length) {
					t = grid[current.i + 1][current.j + 1];
					checkAndUpdateCost(current, t, current.finalCost + DIAGONAL_COST);
				}
			}
		}
	}

	/*
	Params :
	tCase = test case No.
	width, height = Board's dimensions
	startX, startY = start location's height and height coordinates
	endX, endY = end location's x and height coordinates
	int[][] blocked = array containing inaccessible cell coordinates
	*/
	public static ArrayList<int[]> findPath(int width, int height, int startX, int startY, int endX, int endY, int[][] blocked, boolean cutCorners) {
		boolean repeat = false;
		if (blocked == oldBlocked)
			repeat = true;
		else
			oldBlocked = blocked;

		//Reset
		if (!repeat) grid = new Cell[width][height];
		closed = new boolean[width][height];
		open = new PriorityQueue<>(new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				return c1.finalCost < c2.finalCost ? -1 : c1.finalCost > c2.finalCost ? 1 : 0;
			}
		});
		//Set start postartXtion
		setStartCell(startX, startY); //Setting to 0,0 by default. Will be useful for the UI part

		//Set End Location
		setEndCell(endX, endY);

		for (int i = 0; i < width; ++i) {
			for (int j = 0; j < height; ++j) {
				if (!repeat || i == startX && j == startY) grid[i][j] = new Cell(i, j);
				if (repeat && grid[i][j] != null || !repeat || i == startX && j == startY) grid[i][j].heuristicCost = Math.abs(i - endI) + Math.abs(j - endJ);
				//System.out.print(grid[i][j].heuristicCost+" ");
			}
			//System.out.println();
		}

		grid[startX][startY].finalCost = 0;

		/*
		  Set blocked cells. Simply set the cell values to null
		  for blocked cells.
		*/
		if (!repeat) for (int i = 0; i < blocked.length; ++i) {
			if (blocked[i][0] == startX && blocked[i][1] == startY) return null;
			setBlocked(blocked[i][0], blocked[i][1]);
		}

		if (!cutCorners && !repeat) adjustGridCorners(width, height);

		//Display initial map
		/*System.out.println("Grid: ");
		for (int j = startY - 10; j < startY + 10; ++j) {
			for (int i = startX - 10; i < startX + 10; ++i) {
				if (i >= 0 && i < width && j >= 0 && j < height) {
					if (i == startX && j == startY)
						System.out.print("SO  "); //Source
					else if (i == endX && j == endY)
						System.out.print("DE  "); //Destination
					else if (grid[i][j] != null)
						System.out.printf("%-3d ", 0);
					else
						System.out.print("BL  ");
				}
			}
			System.out.println();
		}
		System.out.println();
		*/
		AStar();
		/*System.out.println("\nScores for cells: ");
		for (int j = 0; j < height; ++j) {
			for (int i = 0; i < width; ++i) {
				if (grid[i][j] != null)
					System.out.printf("%-3d ", grid[i][j].finalCost);
				else
					System.out.print("BL  ");
			}
			System.out.println();
		}
		System.out.println();
		*/
		ArrayList<int[]> path = new ArrayList<int[]>();
		if (endI >= 0 && endJ >= 0 && endI < closed.length && endJ < closed[0].length) if (closed[endI][endJ]) {
			//Trace back the path 
			//System.out.println("Path: ");
			Cell current = grid[endI][endJ];
			//System.out.print(current);
			path.add(new int[] { current.i, current.j });
			while (current.parent != null) {
				//System.out.print(" <- " + current.parent);
				path.add(new int[] { current.parent.i, current.parent.j });
				current = current.parent;
			}
			//System.out.println();
		} else
			System.out.println("No possible path");

		return path;
	}

	static void adjustGridCorners(int width, int height) {
		int[][] map = new int[width][height];
		for (int j = 1; j < height; j++)
			for (int i = 0; i < width; i++) {
				if (i > 0 && grid[i][j] == null && grid[i - 1][j] != null && grid[i][j - 1] != null) {
					map[i][j] = 1;
				}
				if (i < width - 1 && grid[i][j] == null && grid[i + 1][j] != null && grid[i][j - 1] != null) {
					map[i][j] = 2;
				}
				if (i > 0 && j < height - 1 && grid[i][j] == null && grid[i - 1][j] != null && grid[i][j + 1] != null) {
					map[i][j] = 3;
				}
				if (i < width - 1 && j < height - 1 && grid[i][j] == null && grid[i + 1][j] != null && grid[i][j + 1] != null) {
					map[i][j] = 4;
				}
			}
		for (int j = 1; j < height; j++)
			for (int i = 0; i < width; i++) {
				switch (map[i][j]) {
				case 1:
					setBlocked(i - 1, j);
					setBlocked(i, j - 1);
					break;
				case 2:
					setBlocked(i + 1, j);
					setBlocked(i, j - 1);
					break;
				case 3:
					setBlocked(i - 1, j);
					setBlocked(i, j + 1);
					break;
				case 4:
					setBlocked(i + 1, j);
					setBlocked(i, j + 1);
					break;
				}
			}
	}
}