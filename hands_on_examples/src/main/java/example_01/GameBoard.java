package example_01;

public class GameBoard {

	private BoardItem[][] board;
	
	public GameBoard(int width, int height) {
		board = new BoardItem[width][height];
	}
	
	public void addAt(BoardItem boardItem, int x, int y) {
		boardItem.setGameBoard(this);
		board[x][y] = boardItem;
	}
	
	public BoardItem getItemFor(int x, int y) {
		return board[x][y];
	}

}
