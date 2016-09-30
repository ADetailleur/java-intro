package example_01;

class Avatar extends AbstractAvatar {
	
	/**
	 * Add your commands in this method inside the curly braces { .. }:
	 * 
	 *  turnLeft();
	 *	turnRight();
	 *	moveForwards();
	 *	moveBackwards();
	 *	
	 *	isObstacleLeft();
	 *	isObstacleRight();
	 *	isObstacleAhead();
	 *
	 */
	void move() {
		
		turnLeft();
		turnLeft();
		moveForwards();
		moveForwards();
		turnRight();
		moveForwards();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Ignore below.
	 */
	Avatar(GameBoard gameBoard, String upSprite, String downSprite, String leftSprite, String rightSprite) {
		super(gameBoard, upSprite, downSprite, leftSprite, rightSprite);
	}

}
