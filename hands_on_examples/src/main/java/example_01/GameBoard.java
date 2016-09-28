package example_01;

import java.util.ArrayList;
import java.util.List;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;



public class GameBoard {
	
	

	private List<BoardItem> items = new ArrayList<>();
	private BoardItem[][] board;
	private TreasureHunt treasureHunt;
	private Avatar avatar;
	
	public GameBoard(TreasureHunt treasureHunt, int width, int height) {
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
	
	public void moveAvatarTo(Avatar avatar, int x, int y) {
		
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

	public void setAvatarAt(Avatar avatar, int x, int y) {
		this.avatar = avatar;
		addAt(avatar, x, y);
	}
	


}
