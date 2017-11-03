package com.rpwz.game;

public class World {
	private Pacman pacman;
	private Maze maze;
	
	public World(PacmanGame pacmanGame){
		this.pacman = new Pacman(100,100);
		this.maze = new Maze();
	}
	
	
	public Pacman getPacman() {
		return pacman;
	}
	public Maze getMaze() {
		return maze;
	}
}
