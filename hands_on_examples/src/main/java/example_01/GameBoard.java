package example_01;

import java.util.ArrayList;
import java.util.List;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;



public class GameBoard {
	
	

	private List<BoardItem> items = new ArrayList<>();
	private BoardItem[][] board;
	private AbstractTreasureHunt treasureHunt;
	private AbstractAvatar avatar;
	
	public GameBoard(AbstractTreasureHunt treasureHunt, int width, int height) {
		this.treasureHunt = treasureHunt;
		board = new BoardItem[width][height];
	}
	
	public void addAt(BoardItem boardItem, int x, int y) {
		items.add(boardItem);
		board[x][y] = boardItem;
	}
	
	public BoardItem getItemFor(int x, int y) {
		return board[x][y];
	}
	
	public void moveAvatarTo(AbstractAvatar avatar, int x, int y) {
		
	}

	public void startMovement() {
		avatar.move();
	}
	
	public void redraw() {

		Task<Void> sleeper = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
				return null;
			}
		};

		sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent event) {
				treasureHunt.redraw();
			}
		});
		new Thread(sleeper).start();

	}

	public void setAvatarAt(AbstractAvatar avatar, int x, int y) {
		this.avatar = avatar;
		addAt(avatar, x, y);
	}

	boolean isObstacleNorthOf(BoardItem boardItem) {
		return isObstacleTranslatedOf(0, -1, boardItem);
	}

	boolean isObstacleEastOf(BoardItem boardItem) {
		return isObstacleTranslatedOf(1, 0, boardItem);
	}

	boolean isObstacleSouthOf(BoardItem boardItem) {
		return isObstacleTranslatedOf(0, 1, boardItem);
	}

	boolean isObstacleWesthOf(BoardItem boardItem) {
		return isObstacleTranslatedOf(-1, 0, boardItem);
	}
	
	boolean isObstacleTranslatedOf(int xTrans, int yTrans, BoardItem boardItem) {
		Position position = getPositionOf(boardItem);
		BoardItem item = getItemFor(position.x + xTrans, position.y + yTrans);
		return item instanceof Obstacle;
	}

	Position getPositionOf(BoardItem boardItem) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != null) {
					return new Position(i, j);
				}
			}
		}
		return null;
	}
	
	void moveNorth(BoardItem boardItem) {
		// TODO Auto-generated method stub
	}
	
	void moveEast(BoardItem boardItem) {
		// TODO Auto-generated method stub
	}
	
	void moveSouth(BoardItem boardItem) {
		// TODO Auto-generated method stub
	}
	
	void moveWest(BoardItem boardItem) {
		// TODO Auto-generated method stub
	}
	
	class Position {
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		int x;
		int y;
	}

}
