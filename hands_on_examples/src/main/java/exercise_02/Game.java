package exercise_02;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JPanel;

public class Game extends Exercise03Base {

	GameBoard gameboard = new GameBoard(getHorizontalFields(), getVerticalFields());

	/**
	 * Here we prepare the game board by adding all game players (aka elements).
	 */
	public void configureGame() {
		
		gameboard.addElement(new Protagonist(new Position(3, 4)));
		
		gameboard.addElement(new Robot(new Position(8, 2)));
		gameboard.addElement(new Robot(new Position(6, 5)));
		gameboard.addElement(new Robot(new Position(17, 10)));
		
		// Add antagonist
		// TODO
		
	}

	/**
	 * This is called every turn. 
	 */
	public void makeTurn() {
		print("Turn");

	}
	
	
	/**
	 * We can use this to display the game result in any way.
	 */
	private void displayFinalResult() {
		
		// TODO
		
	}
	
	
	
	
	
	
	
	
	
	
	


}
