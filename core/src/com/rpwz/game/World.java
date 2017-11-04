package com.rpwz.game;

public class World {
	private Pacman pacman;
	private Maze maze;
	
	public World(PacmanGame pacmanGame){
		this.maze = new Maze();
		this.pacman = new Pacman(60,60,this.maze);
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
