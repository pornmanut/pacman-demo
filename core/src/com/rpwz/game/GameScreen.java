package com.rpwz.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter{
	

	private World world;
	private WorldRenderer worldRenderer;

	public GameScreen(PacmanGame pacmanGame) {
		world = new World(pacmanGame);
		worldRenderer = new WorldRenderer(pacmanGame,world);
	}
	
	private void clear() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	private void updatePacmanDirection() {
		Pacman pacman = world.getPacman();
		if(Gdx.input.isKeyPressed(Keys.UP)) {
			pacman.setNextDirection(Pacman.DIR_UP);
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			pacman.setNextDirection(Pacman.DIR_LEFT);
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			pacman.setNextDirection(Pacman.DIR_DOWN);
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			pacman.setNextDirection(Pacman.DIR_RIGHT);
		}
	}
	
	private void update(float delta) {
		updatePacmanDirection();
		world.update(delta);
	}
	
	@Override
	public void render(float delta) {
		this.update(delta);
		
		this.clear();		
		
		worldRenderer.render(delta);
	}
}
