package com.rpwz.game;

import com.badlogic.gdx.math.Vector2;

public class Pacman {
	
	public static final int DIR_UP = 1;
	public static final int DIR_RIGHT = 2;
	public static final int DIR_DOWN = 3;
	public static final int DIR_LEFT = 4;
	public static final int DIR_STILL = 0;
	private static final int moveSpeed = 10;
	
	private Vector2 position;
	
	public Pacman(int x,int y) {
		position = new Vector2(x,y);
	}
	public Vector2 getPosition() {
		return position;
	}
	public void movement(int dir) {
		switch(dir) {
		case DIR_UP:
			position.y += moveSpeed;
			break;
		case DIR_RIGHT:
			position.x += moveSpeed;
			break;
		case DIR_DOWN:
			position.y -= moveSpeed;
			break;
		case DIR_LEFT:
			position.x -= moveSpeed;
			break;
		}
	}
	public void update(float delta) {
	
	}
}
