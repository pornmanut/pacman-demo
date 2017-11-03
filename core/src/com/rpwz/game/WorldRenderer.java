package com.rpwz.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	public static final int BLOCK_SIZE = 40;
	private PacmanGame pacmanGame;
	private Texture pacmanImg;
	private SpriteBatch batch;
	private World world;
	private MazeRenderer mazeRenderer;
	
	public WorldRenderer(PacmanGame pacmanGame,World world) {
		
		this.pacmanGame = pacmanGame;
		this.batch = this.pacmanGame.batch;
		this.world = world;
		pacmanImg = new Texture("pacman.png");
		
		this.mazeRenderer = new MazeRenderer(pacmanGame.batch,world.getMaze());
	}
	public void render(float delta) {
		mazeRenderer.render();
		
		
		Vector2 pos = world.getPacman().getPosition();
		batch.begin();
		batch.draw(pacmanImg,pos.x-BLOCK_SIZE/2,PacmanGame.HEIGHT-pos.y-BLOCK_SIZE/2);
		batch.end();
	}
}
