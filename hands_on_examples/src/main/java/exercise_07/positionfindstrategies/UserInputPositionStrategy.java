package exercise_07.positionfindstrategies;

import java.util.Collection;

import exercise_07.gameboard.FindNextPositionStrategy;
import exercise_07.gameboard.GameBoardElement;
import exercise_07.gameboard.Position;

public class UserInputPositionStrategy implements FindNextPositionStrategy {

  private UserInput userInput;

  public UserInputPositionStrategy(UserInput userInput) {
    this.userInput = userInput;
  }
  
  @Override
  public Position findNextPosition(Position ownPosition, Collection<GameBoardElement> allElements) {
    
    int x = ownPosition.getX();
    int y = ownPosition.getY();
    
    if (userInput == UserInput.UP) {
      y -= 1;
    }
    
    if (userInput == UserInput.DOWN) {
      y += 1;
    }
    
    if (userInput == UserInput.LEFT) {
      x -= 1;
    }
    
    if (userInput == UserInput.RIGHT) {
      x += 1;
    }
    
    return new Position(x, y);
  }

}
