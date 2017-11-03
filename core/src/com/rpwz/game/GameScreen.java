package com.rpwz.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter{
	private PacmanGame pacmanGame;
	private Texture pacmanImg;
	
	private int x;
	private int y;
	
	public GameScreen(PacmanGame pacmanGame) {
		this.pacmanGame = pacmanGame ;
		this.x = 100;
		this.y = 100;
		pacmanImg =new Texture("pacman.png");
	}
	public void clear() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	private void update(float delta) {
		x += 5;
	}
	@Override
	public void render(float delta) {
		this.update(delta);
		this.clear();		
		SpriteBatch batch = pacmanGame.batch;
		batch.begin();
		batch.draw(pacmanImg,x,y);
		batch.end();
	}
}
