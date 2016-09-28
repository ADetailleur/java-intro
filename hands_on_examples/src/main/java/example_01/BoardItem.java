package example_01;

import javafx.scene.image.Image;

class BoardItem {
	
	Image sprite;
	GameBoard gameBoard;
	
	BoardItem(GameBoard gameBoard, String spritePath) {
		this.gameBoard = gameBoard;
		sprite = getImageFrom(spritePath);
	}

	Image getSprite() {
		return sprite;
	}
	
	Image getImageFrom(String path) {
		return new Image(getClass().getClassLoader().getResource(path).toString());
	}
	
	GameBoard getGameBoard() {
		return gameBoard;
	}

}
