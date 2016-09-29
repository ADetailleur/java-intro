package example_01;

import java.util.ArrayList;
import java.util.List;

import example_01.GameBoard.Position;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;


class GameBoard {

	List<BoardItem> items = new ArrayList<>();
	BoardItem[][] board;
	AbstractTreasureHunt treasureHunt;
	AbstractAvatar avatar;
	int width;
	int height;
	
	GameBoard(AbstractTreasureHunt treasureHunt, int width, int height) {
		this.treasureHunt = treasureHunt;
		this.width = width;
		this.height = height;
		board = new BoardItem[width][height];
	}
	
	void addAt(BoardItem boardItem, Position position) {
		addAt(boardItem, position.x, position.y);
	}
	
	void addAt(BoardItem boardItem, int x, int y) {
		items.add(boardItem);
		board[x][y] = boardItem;
	}
	
	void remove(BoardItem boardItem) {
		Position position = getPositionOf(boardItem);
		board[position.x][position.y] = null;
		items.remove(boardItem);
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
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		treasureHunt.redraw();
		
//		Task<Void> sleeper = new Task<Void>() {
//			@Override
//			protected Void call() throws Exception {
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//				}
//				return null;
//			}
//		};
//
//		sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//			@Override
//			public void handle(WorkerStateEvent event) {
//				treasureHunt.redraw();
//			}
//		});
//		new Thread(sleeper).start();

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
				if (board[i][j] != null && board[i][j] == boardItem) {
					return new Position(i, j);
				}
			}
		}
		return null;
	}
	
	void moveNorth(BoardItem boardItem) {
		moveBy(boardItem, 0, -1);
	}
	
	void moveEast(BoardItem boardItem) {
		moveBy(boardItem, 1, 0);
	}
	
	void moveSouth(BoardItem boardItem) {
		moveBy(boardItem, 0, 1);
	}
	
	void moveWest(BoardItem boardItem) {
		moveBy(boardItem, -1, 0);
	}
	
	void moveBy(BoardItem boardItem, int xTrans, int yTrans) {
		Position position = getPositionOf(boardItem);
		Position newPosition = position.translateBy(xTrans, yTrans);
		if (isValid(newPosition)) {
			remove(boardItem);
			addAt(boardItem, newPosition);
		}
	}
	
	boolean isValid(Position position) {
		return 0 <= position.x && position.x < width && 0 <= position.y && position.y < height;
	}

	class Position {
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		final int x;
		final int y;
		
		Position translateBy(int xTrans, int yTrans) {
			return new Position(x + xTrans,  y + yTrans);
		}
	}

}
