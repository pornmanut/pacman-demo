package com.rpwz.game;

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
	
	public Pacman(int x,int y,Maze maze) {
		this.position = new Vector2(x,y);
		this.currentDir = DIR_STILL;
		this.nextDir = DIR_STILL;
		this.maze = maze;
	}
	
	private int getRow() {
		return ((int)position.y)/WorldRenderer.BLOCK_SIZE;
	}
	private int getColum() {
		return ((int)position.x)/WorldRenderer.BLOCK_SIZE;
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
	public void movement(int dir) {
		position.x += MOVE_SPEED * DIR_OFFSETS[dir][0];
		position.y += MOVE_SPEED * DIR_OFFSETS[dir][1];
	}
	public void update(float delta) {
		if(isAtCenter()) {
			if(this.canMoveInDirection(nextDir)) {
				this.currentDir = this.nextDir;
			}else {
				this.currentDir = DIR_STILL;
			}
			
		}
		movement(this.currentDir);
	}
}
