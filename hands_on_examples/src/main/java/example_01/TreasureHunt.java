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
	
	private Image grass = getImageFrom("planetCute/grass_block.png");
	private Image dirt = getImageFrom("planetCute/dirt_block.png");
	private Image rock = getImageFrom("planetCute/rock.png");
	private Image gem = getImageFrom("planetCute/gem_orange.png");
	private Image character = getImageFrom("planetCute/character_boy.png");
	
	
	
	
	
	


	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane stackPane = new StackPane();
		
		GridPane background = createGridPane();
		initializeBackground(background);
		stackPane.getChildren().add(background);
		
		GridPane foreground = createGridPane();
		initializeForeground(foreground);
		stackPane.getChildren().add(foreground);
		
		Scene scene = new Scene(stackPane, 600, 600);
		primaryStage.setTitle("Treasure Hunt");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	


	private GridPane createGridPane() {
		GridPane gridpane = new GridPane();
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setVgap(-86);
		gridpane.setHgap(0);
		return gridpane;
	}

	private void initializeBackground(GridPane background) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				background.add(new ImageView(grass), j, i);
			}
		}	
	}
	
	private void initializeForeground(GridPane foreground) {
		foreground.add(new ImageView(rock), 0, 0);
	}

	public static void main(String[] args) {
        launch(args);
    }
	
	private Image getImageFrom(String path) {
		return new Image(getClass().getClassLoader().getResource(path).toString());
	}
 
}
