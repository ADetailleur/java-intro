package example_01;

import java.util.Random;

class Avatar extends AbstractAvatar {
	
	/**
	 * Add your commands in this method inside the curly braces { .. }:
	 * 
	 *  void turnLeft();
	 *	void turnRight();
	 *	void moveForwards();
	 *	
	 *	boolean isObstacleLeft();
	 *	boolean isObstacleRight();
	 *	boolean isObstacleAhead();
	 *  boolean hasGem();
	 *
	 *
	 * The game performs this 'move' method once before evaluating the outcome.
	 *
	 */
	void move() {

		// Write your movement program here! For example, start with a step forwards:
		Random coinToss = new Random();
		while (!hasGem()) {

			boolean coinHead = coinToss.nextBoolean();

			if (coinHead) {
				turnRight();
			}
			else {
				turnLeft();
			}
			moveForwards();
		}



		

		
		
		
		
		
	}
	
	
	
	/**
	 * The return value of this method determines the break between each operation (e.g. 'turnLeft()') in the move method. 
	 * If it's too slow for you, set a shorter value, e.g. 200.
	 */
	@Override
	long getSleepTimeInMilliSeconds() {
		return 50;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Ignore below.
	 */
	Avatar(GameBoard gameBoard) {
		super(gameBoard, "planetCute/character_up.png", "planetCute/character_down.png", "planetCute/character_left.png", "planetCute/character_right.png");
	}

}
