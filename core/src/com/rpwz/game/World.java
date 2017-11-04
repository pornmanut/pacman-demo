package com.rpwz.game;

public class World {
	private Pacman pacman;
	private Maze maze;
	
	public World(PacmanGame pacmanGame){
		this.pacman = new Pacman(60,60);
		this.maze = new Maze();
	}
	public void update(float delta) {
		pacman.update(delta);
	}
	
	public Pacman getPacman() {
		return pacman;
	}
	public Maze getMaze() {
		return maze;
	}
}
