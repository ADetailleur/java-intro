package exercise_07;

import exercise_07.alliance.Protagonist;
import exercise_07.alliance.Robot;
import exercise_07.empire.Soldier;
import exercise_07.gameboard.GameBoard;
import exercise_07.gameboard.Position;
import exercise_07.positionfindstrategies.UserInput;

public class NotTheDroidsWeAreLookingFor extends GameBase {
  
  public NotTheDroidsWeAreLookingFor() {
    initializeGameBoardWithFieldSize(18, 12);
  }


  /**
	 * Here we prepare the game board by adding all game players (aka elements).
	 */
	public void configureGame() {
	  GameBoard gameBoard = getGameBoard();
	  
	  gameBoard.add(new Protagonist(new Position(3, 4)));
		gameBoard.add(new Robot(new Position(6, 4)));
		
		gameBoard.add(new Soldier(new Position(12, 6)));
		gameBoard.add(new Soldier(new Position(13, 8)));
		gameBoard.add(new Soldier(new Position(14, 7)));
		
		/*
		 * Add prop:
		 * - Create new class 'Rock' which implements the interface 'GameBoardElement'. 
		 *   Let it use the 'rock.png' icon. You can use the Soldier as example.
		 *   Then, add it to the gameboard.
		 */
		
    /*
     * Add antagonist:
     * - Create new class 'Antagonist' which extends the abstract class 'GalacticEmpireMember'. 
     *   Let it use the 'antagonist.png' icon. You can use the Soldier as example.
     *   Then, add it to the gameboard.
     */
		
	}

	/**
	 * This is called every turn after the user pressed some arrow key.
	 */
	public void makeTurn(UserInput userInput) {
		System.out.println("Turn triggered by user input: " + userInput);
		GameBoard gameBoard = getGameBoard();
		gameBoard.makeTurnWithUserInput(userInput);
	}
	
	
	/** 
	 * Is called at the end of every turn.
	 * 
	 * Implement some way to determine when the game is over. 
	 * I'd propose to check if either the Protagonist or the Antagonist is not existing anymore.
	 */
	@Override
	protected boolean isGameFinished() {
	  return false;
	}
	
	
	 /**
   * We can use this to display the game result in any way.
   */
  public void displayFinalResult() {
    drawText("GAME OVER");
  }
	
	
	private static final long serialVersionUID = 1L;
	
}
