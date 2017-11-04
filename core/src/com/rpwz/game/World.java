package com.rpwz.game;

public class World {
	private Pacman pacman;
	private Maze maze;
	private int score;
	
	public World(PacmanGame pacmanGame){
		this.maze = new Maze();
		this.pacman = new Pacman(60,60,this);
		this.score = 0;
		registerDotEattenListener();
	}
	
	private void registerDotEattenListener() {
		pacman.registerDotEattenLister(new Pacman.DotEattenListener() {
			
			@Override
			public void notifyDotEatten() {
				increaseScore();
				
			}
		});
	}
	public void increaseScore() {
		score += 1;
	}
	
	public Pacman getPacman() {
		return pacman;
	}
	public Maze getMaze() {
		return maze;
	}
	public int getScore() {
		return score;
	}
	public void update(float delta) {
		pacman.update(delta);
	}
}
