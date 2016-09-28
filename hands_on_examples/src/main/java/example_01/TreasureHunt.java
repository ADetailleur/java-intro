package example_01;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreasureHunt extends Application {

	//---- Fields
	
	private int width = 7;
	private int height = 7;
	
	private GameBoard gameBoard = new GameBoard(width, height);
	
	private BoardItem placeholder = new BoardItem("planetCute/placeholder.png");
	private BoardItem grass = new BoardItem("planetCute/grass_block.png");
	private BoardItem dirt = new BoardItem("planetCute/dirt_block.png");
	private BoardItem rock = new BoardItem("planetCute/rock.png");
	private BoardItem gem = new BoardItem("planetCute/gem_orange.png");
	private BoardItem character = new BoardItem("planetCute/character_boy.png");

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
        move();
	}
	


	private void initializeGameBoard() {
		gameBoard.addAt(rock, 2, 3);
		gameBoard.addAt(gem, 0, 4);
		gameBoard.addAt(character, 4, 0);
				
	}
	
	private void move() {
		
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
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				underground.add(new ImageView(dirt.getSprite()), j, i);
			}
		}	
	}

	public void initializeBackgroundIn(GridPane background) {
		// We pave the background with grass
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				background.add(new ImageView(grass.getSprite()), j, i);
			}
		}	
	}
	
	public void paintForegroundIn(GridPane gridPane) {
		gridPane.getChildren().clear();
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				gridPane.add(new ImageView(placeholder.getSprite()), j, i);
			}
		}
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
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
	
	private Image getImageFrom(String path) {
		return new Image(getClass().getClassLoader().getResource(path).toString());
	}
 
}
