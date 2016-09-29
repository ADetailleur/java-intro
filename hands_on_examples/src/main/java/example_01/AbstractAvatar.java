package example_01;

import javafx.scene.image.Image;

abstract class AbstractAvatar extends BoardItem {
	
	//---- Fields
	
	Direction[] directions = new Direction[] { Direction.TOP, Direction.RIGHT, Direction.BOTTOM, Direction.LEFT };
	Image[] sprites;
	int direction = 0;
	
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
	
	//---- Constructor
	
	AbstractAvatar(GameBoard gameBoard, String upSprite, String downSprite, String leftSprite, String rightSprite) {
		super(gameBoard, upSprite);
		sprites = new Image[] {getImageFrom(upSprite), getImageFrom(rightSprite), getImageFrom(downSprite), getImageFrom(leftSprite)};
	}
	
	//---- Methods

	abstract void move();

	
	



	

	
	

	boolean isObstacleAhead() {
		return isObstacleInDirection(direction);
	}



	boolean isObstacleRight() {
		return isObstacleInDirection(direction + 1 % directions.length);
	}



	boolean isObstacleLeft() {
		return isObstacleInDirection(direction - 1 % directions.length);
	}
	
	boolean isObstacleInDirection(int direction) {
		switch (directions[direction]) {
		case TOP:
			return gameBoard.isObstacleNorthOf(this);
		case RIGHT:
			return gameBoard.isObstacleEastOf(this);
		case BOTTOM:
			return gameBoard.isObstacleSouthOf(this);
		case LEFT:
			return gameBoard.isObstacleWesthOf(this);
		default:
			throw new IllegalArgumentException("No known direction");
		}
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
		switch (directions[direction]) {
		case TOP:
			gameBoard.moveNorth(this);
		case RIGHT:
			gameBoard.moveEast(this);
		case BOTTOM:
			gameBoard.moveSouth(this);
		case LEFT:
			gameBoard.moveWest(this);
		}
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


	
	@Override
	Image getSprite() {
		return sprites[direction];
	}
	
	
	void finishMove() {
		getGameBoard().redraw();
	}
	
}
