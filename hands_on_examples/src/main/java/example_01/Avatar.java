package example_01;

import javafx.scene.image.Image;

class Avatar extends BoardItem {
	
	/**
	 * Add your commands in this method:
	 */
	void move() {
		
		turnLeft();
		turnRight();
		moveForwards();
		moveBackwards();
		
		isObstacleLeft();
		isObstacleRight();
		isObstacleAhead();
		
		
	}

	
	



	// Ignore the below stuff.
	
	enum Direction { 
		TOP(0), RIGHT(1), BOTTOM(2), LEFT(3);
		
		private int id;
		
		private Direction(int id) {
			this.id = id;
		}
		int id() {
			return id;
		}
		
	}
	
	Direction[] directions = new Direction[] { Direction.TOP, Direction.RIGHT, Direction.BOTTOM, Direction.LEFT };
	Image[] sprites;
	
	int direction = 0;



	void isObstacleAhead() {
		// TODO Auto-generated method stub
		
	}



	void isObstacleRight() {
		// TODO Auto-generated method stub
		
	}



	void isObstacleLeft() {
		// TODO Auto-generated method stub

	}

	void moveBackwards() {
		moveInDirection(-1);
		finishMove();
	}

	void moveForwards() {
		moveInDirection(1);
		finishMove();
	}
	
	void moveInDirection(int steps) {
		
		// TODO
	}

	void turnLeft() {
		updateDirectionBy(-1);
		finishMove();
	}

	void turnRight() {
		updateDirectionBy(+1);
		finishMove();
	}
	
	void updateDirectionBy(int directionDelta) {
		direction = (direction + directionDelta) % directions.length;
	}

	Avatar(GameBoard gameBoard, String upSprite, String downSprite, String leftSprite, String rightSprite) {
		super(gameBoard, upSprite);
		sprites = new Image[] {getImageFrom(upSprite), getImageFrom(rightSprite), getImageFrom(downSprite), getImageFrom(leftSprite)};
	}
	
	@Override
	Image getSprite() {
		return sprites[direction];
	}
	
	
	void finishMove() {
		getGameBoard().redraw();
	}
	
}
