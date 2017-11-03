package com.rpwz.game;

import com.badlogic.gdx.math.Vector2;

public class Pacman {
	
	public static final int DIR_STILL = 0;
	public static final int DIR_UP = 1;
	public static final int DIR_RIGHT = 2;
	public static final int DIR_DOWN = 3;
	public static final int DIR_LEFT = 4;

	private static final int MOVE_SPEED = 10;
	
	private static final int [][] DIR_OFFSETS = new int[][] {
		{0,0},
		{0,-1},
		{1,0},
		{0,1},
		{-1,0}
	};
	
	private Vector2 position;
	
	public Pacman(int x,int y) {
		position = new Vector2(x,y);
	}
	public Vector2 getPosition() {
		return position;
	}
	public void movement(int dir) {
		position.x += MOVE_SPEED * DIR_OFFSETS[dir][0];
		position.y += MOVE_SPEED * DIR_OFFSETS[dir][1];
	}
	public void update(float delta) {
	
	}
}
