package example_01;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class GameBoard {
	
	

	private List<BoardItem> items = new ArrayList<>();
	private BoardItem[][] board;
	private int width;
	private int height;
	
	public GameBoard(int width, int height) {
		this.width = width;
		this.height = height;
		board = new BoardItem[width][height];
	}
	
	public void addAt(BoardItem boardItem, int x, int y) {
		boardItem.setGameBoard(this);
		items.add(boardItem);
		board[x][y] = boardItem;
	}
	
	public BoardItem getItemFor(int x, int y) {
		return board[x][y];
	}
	


}
