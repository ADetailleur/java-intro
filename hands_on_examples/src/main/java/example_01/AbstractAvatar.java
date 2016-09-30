package example_01;

import javafx.application.Platform;
import javafx.scene.image.Image;

abstract class AbstractAvatar extends BoardItem implements Runnable {
	
	//---- Fields
	
	Direction[] directions = new Direction[] { Direction.TOP, Direction.RIGHT, Direction.BOTTOM, Direction.LEFT };
	Image[] sprites;
	int direction = 0;
	private Gem gem;
	
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

	@Override
	public void run() {
		move();
	}
	
	abstract void move();

	boolean isObstacleAhead() {
		boolean result = isObstacleInDirection(direction);
		log("Is obstacle ahead: " + result);
		return result;
	}

	boolean isObstacleRight() {
		boolean result = isObstacleInDirection(direction + 1 % directions.length);
		log("Is obstacle right: " + result);
		return result;
	}

	boolean isObstacleLeft() {
		boolean result = isObstacleInDirection(direction - 1 % directions.length);
		log("Is obstacle left: " + result);
		return result;
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
		log("Move backwards");
		moveInDirection(-1);
		finishMove();
	}

	void moveForwards() {
		log("Move forwards");
		moveInDirection(1);
		finishMove();
	}
	
	void moveInDirection(int steps) {
		switch (directions[direction]) {
		case TOP:
			gameBoard.moveNorth((Avatar) this);
			break;
		case RIGHT:
			gameBoard.moveEast((Avatar) this);
			break;
		case BOTTOM:
			gameBoard.moveSouth((Avatar) this);
			break;
		case LEFT:
			gameBoard.moveWest((Avatar) this);
			break;
		}
	}

	void turnLeft() {
		log("Turn left");
		updateDirectionBy(-1);
		finishMove();
	}

	void turnRight() {
		log("Turn right");
		updateDirectionBy(+1);
		finishMove();
	}
	
	void pickUp(Gem gem) {
		this.gem = gem;
		log("Picked up gem");
	}
	
	void log(String message) {
		System.out.println(message);
	}
	
	void updateDirectionBy(int directionDelta) {
		direction = Math.floorMod(direction + directionDelta, directions.length);
	}
	
	@Override
	Image getSprite() {
		return sprites[direction];
	}
	
	void finishMove() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Platform.runLater(() -> getGameBoard().redraw()); 
	}
	
}
