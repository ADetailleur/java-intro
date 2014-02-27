package exercise_02;



public class Game extends GameBase {

  private int horizontalFields = 18;
  private int verticalFields = 12;
  
  public Game() {
    initializeGameBoard(horizontalFields, verticalFields);
  }


  /**
	 * Here we prepare the game board by adding all game players (aka elements).
	 */
	public void configureGame() {
		
	  GameBoard gameBoard = getGameBoard();
	  
	  gameBoard.addElement(new Antagonist(new Position(3, 4)));
		
		gameBoard.addElement(new Robot(new Position(8, 2)));
		gameBoard.addElement(new Robot(new Position(6, 5)));
		gameBoard.addElement(new Robot(new Position(17, 10)));
		
		// Add protagonist
		// TODO
		
	}

	/**
	 * This is called every turn. 
	 */
	public void moveElements() {
		print("Turn");

	}
	
	
	/**
	 * We can use this to display the game result in any way.
	 */
	public void displayFinalResult() {
		
		// TODO
		
	}
	
	
	
	
	
	
	
	
	
	
	
	private static final long serialVersionUID = 1L;

}
