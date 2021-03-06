package com.rpwz.game;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

public class Pacman {
	

	private static final int [][] DIR_OFFSETS = new int[][] {
		{0,0},
		{0,-1},
		{1,0},
		{0,1},
		{-1,0}
	};
	private static final int MOVE_SPEED = 5;
	
	
	public static final int DIR_STILL = 0;
	public static final int DIR_UP = 1;
	public static final int DIR_RIGHT = 2;
	public static final int DIR_DOWN = 3;
	public static final int DIR_LEFT = 4;

	private int currentDir;
	private int nextDir;
	
	private Vector2 position;
	private Maze maze;
	private World world;
	private List<DotEattenListener> listeners;
	
	
	public interface DotEattenListener{
		void notifyDotEatten();
	}
	
	private void notifyDotEattenListeners() {
		for(DotEattenListener l:listeners) {
			l.notifyDotEatten();
		}
	}
	
	public void registerDotEattenLister(DotEattenListener l) {
		listeners.add(l);
	}
	
	public Pacman(int x,int y,World world) {
		this.position = new Vector2(x,y);
		
		this.currentDir = DIR_STILL;
		this.nextDir = DIR_STILL;
		
		this.world = world;
		this.maze = this.world.getMaze();
		
		listeners = new LinkedList<DotEattenListener>();
	}

	private int getRow() {
		return ((int)position.y)/WorldRenderer.BLOCK_SIZE;
	}
	private int getColum() {
		return ((int)position.x)/WorldRenderer.BLOCK_SIZE;
	}
	
	private void movement(int dir) {
		position.x += MOVE_SPEED * DIR_OFFSETS[dir][0];
		position.y += MOVE_SPEED * DIR_OFFSETS[dir][1];
	}
	
	private void eatDot() {
		int row = getRow();
		int col = getColum();
		if(maze.hasDotAt(row, col)) {
			maze.removeDotAt(row,col);
			notifyDotEattenListeners();
		}
	}
	
	private boolean canMoveInDirection(int dir) {
		int nextColum = getColum()+DIR_OFFSETS[dir][0];
		int nextRow = getRow()+DIR_OFFSETS[dir][1];
		
		if(maze.hasWallAt(nextRow, nextColum)) {
			return false;
		}else{
			return true;
		}
	}
	
	public void setNextDirection(int dir) {
		this.nextDir = dir;
	}
	public Vector2 getPosition() {
		return position;
	}
	
	public boolean isAtCenter() {
		int blockSize = WorldRenderer.BLOCK_SIZE;
		return ((((int)position.x - blockSize/2) % blockSize) == 0) &&
                ((((int)position.y - blockSize/2) % blockSize) == 0);
	}
	
	public void update(float delta) {
		if(isAtCenter()) {
			this.eatDot();
			if(this.canMoveInDirection(nextDir)) {
				this.currentDir = this.nextDir;
			}else {
				this.currentDir = DIR_STILL;
			}
			
		}
		movement(this.currentDir);
	}
}
