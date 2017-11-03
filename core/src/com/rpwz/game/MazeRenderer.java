package com.rpwz.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MazeRenderer {
	private Maze maze;
	private SpriteBatch batch;
	private Texture wallImage;
	private Texture dotImage;
	
	public MazeRenderer(SpriteBatch batch,Maze maze) {
		this.maze = maze;
		this.batch = batch;
		
		this.wallImage = new Texture("wall.png");
		this.dotImage = new Texture("dot.png");
	}
	
	public void render() {
		
	}

}
