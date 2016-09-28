package example_01;

import javafx.scene.image.Image;

public class BoardItem {
	
	private Image sprite;
	private GameBoard gameBoard;
	
	public BoardItem(String spritePath) {
		sprite = getImageFrom(spritePath);
	}
	
	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public Image getSprite() {
		return sprite;
	}
	
	private Image getImageFrom(String path) {
		return new Image(getClass().getClassLoader().getResource(path).toString());
	}

}
