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
	
	public Pacman(int x,int y) {
		position = new Vector2(x,y);
		this.currentDir = DIR_STILL;
		this.nextDir = DIR_STILL;
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
			this.currentDir = this.nextDir;
		}
		movement(this.currentDir);
	}
}
