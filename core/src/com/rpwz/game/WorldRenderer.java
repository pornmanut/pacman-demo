package com.rpwz.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private PacmanGame pacmanGame;
	private Texture pacmanImg;
	private SpriteBatch batch;
	private World world;
	public WorldRenderer(PacmanGame pacmanGame,World world) {
		
		this.pacmanGame = pacmanGame;
		
		this.batch = this.pacmanGame.batch;
		this.world = world;
		pacmanImg = new Texture("pacman.png");
	}
	public void render(float delta) {
		batch.begin();
		Vector2 pos = world.getPacman().getPosition();
		batch.draw(pacmanImg,pos.x,pos.y);
		batch.end();
	}
}