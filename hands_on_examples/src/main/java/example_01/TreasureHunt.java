package example_01;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreasureHunt extends Application {

	//---- Fields
	
	private static final int WIDTH = 7;
	private static final int HEIGHT = 7;
	
	private GameBoard gameBoard = new GameBoard(this, WIDTH, HEIGHT);
	
	private BoardItem placeholder = new BoardItem(gameBoard, "planetCute/placeholder.png");
	private BoardItem grass = new BoardItem(gameBoard, "planetCute/grass_block.png");
	private BoardItem dirt = new BoardItem(gameBoard, "planetCute/dirt_block.png");
	private BoardItem rock = new Rock(gameBoard);
	private BoardItem gem = new BoardItem(gameBoard, "planetCute/gem_orange.png");
	
	private Avatar avatar = new Avatar(gameBoard, "planetCute/character_boy.png", "planetCute/character_boy.png", "planetCute/character_boy.png", "planetCute/character_boy.png");

	private GridPane foreground;
	
	
	//---- Methods

	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane stackPane = new StackPane();
		
		GridPane underground = createGridPane();
		initializeUndergroundIn(underground);
		stackPane.getChildren().add(underground);
		
		GridPane ground = createGridPane();
		ground.setTranslateY(-41);
		initializeBackgroundIn(ground);
		stackPane.getChildren().add(ground);
		
		foreground = createGridPane();
		foreground.setTranslateY(-82);
		stackPane.getChildren().add(foreground);
		
		Scene scene = new Scene(stackPane, 840, 840);
		primaryStage.setTitle("Treasure Hunt");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        initializeGameBoard();
        
        startMovement();
	}
	


	private void initializeGameBoard() {
		gameBoard.addAt(rock, 2, 3);
		gameBoard.addAt(gem, 0, 4);
		gameBoard.setAvatarAt(avatar, 4, 0);
		
		redraw();
	}
	
	private void startMovement() {
		gameBoard.startMovement();
	}
	
	public void redraw() {
		paintForegroundIn(foreground);
	}

	private GridPane createGridPane() {
		GridPane gridpane = new GridPane();
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setVgap(-86);
		gridpane.setHgap(0);		
		return gridpane;
	}
	
	public void initializeUndergroundIn(GridPane underground) {
		// We pave the background with grass
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				underground.add(new ImageView(dirt.getSprite()), j, i);
			}
		}	
	}

	public void initializeBackgroundIn(GridPane background) {
		// We pave the background with grass
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				background.add(new ImageView(grass.getSprite()), j, i);
			}
		}	
	}
	
	public void paintForegroundIn(GridPane gridPane) {
		gridPane.getChildren().clear();
		
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				gridPane.add(new ImageView(placeholder.getSprite()), j, i);
			}
		}
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				BoardItem boardItem = gameBoard.getItemFor(j, i);
				if (boardItem != null) {
					gridPane.add(new ImageView(boardItem.getSprite()), j, i);
				}
			}
		}	
	}
	
	public static void main(String[] args) {
        launch(args);
    }
 
}
