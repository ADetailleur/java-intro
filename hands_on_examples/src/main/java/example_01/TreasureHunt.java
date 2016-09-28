package example_01;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreasureHunt extends Application {

	//---- Fields
	
	private GameBoard gameBoard = new GameBoard(5, 5);
	
	private BoardItem placeholder = new BoardItem("planetCute/placeholder.png");
	private BoardItem grass = new BoardItem("planetCute/grass_block.png");
	private BoardItem dirt = new BoardItem("planetCute/dirt_block.png");
	private BoardItem rock = new BoardItem("planetCute/rock.png");
	private BoardItem gem = new BoardItem("planetCute/gem_orange.png");
	private BoardItem character = new BoardItem("planetCute/character_boy.png");

	private GridPane background;
	private GridPane foreground;
	
	
	
	
	
	


	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane stackPane = new StackPane();
		
		background = createGridPane();
		initializeBackground(background);
		stackPane.getChildren().add(background);
		
		foreground = createGridPane();
		foreground.setTranslateY(-36);
		stackPane.getChildren().add(foreground);
		
		Scene scene = new Scene(stackPane, 600, 600);
		primaryStage.setTitle("Treasure Hunt");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        initializeGameBoard();
	}
	


	private void initializeGameBoard() {
		gameBoard.addAt(rock, 2, 3);
		gameBoard.addAt(gem, 0, 4);
		gameBoard.addAt(character, 4, 0);
		paintForeground();		
	}



	private GridPane createGridPane() {
		GridPane gridpane = new GridPane();
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setVgap(-86);
		gridpane.setHgap(0);		
		return gridpane;
	}

	private void initializeBackground(GridPane background) {
		// We pave the background with grass
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				background.add(new ImageView(grass.getSprite()), j, i);
			}
		}	
	}
	
	private void paintForeground() {
		foreground.getChildren().clear();
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				foreground.add(new ImageView(placeholder.getSprite()), j, i);
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				BoardItem boardItem = gameBoard.getItemFor(j, i);
				if (boardItem != null) {
					foreground.add(new ImageView(boardItem.getSprite()), j, i);
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
