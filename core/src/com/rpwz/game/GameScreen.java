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
	
	private void update(float delta) {
		if(Gdx.input.isKeyPressed(Keys.UP)) {
			world.getPacman().movement(Pacman.DIR_UP);
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			world.getPacman().movement(Pacman.DIR_LEFT);
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			world.getPacman().movement(Pacman.DIR_DOWN);
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			world.getPacman().movement(Pacman.DIR_RIGHT);
		}
	}
	
	@Override
	public void render(float delta) {
		this.update(delta);
		
		this.clear();		
		
		worldRenderer.render(delta);
	}
}
