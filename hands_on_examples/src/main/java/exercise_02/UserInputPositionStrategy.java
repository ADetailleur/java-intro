package exercise_02;

import java.util.Collection;

public class UserInputPositionStrategy implements FindNextPositionStrategy {

  private Position position;
  private UserInput userInput;

  public UserInputPositionStrategy(Position position, UserInput userInput) {
    this.position = position;
    this.userInput = userInput;
  }
  
  @Override
  public Position findNextPosition(Collection<GameBoardElement> elements) {
    
    int x = position.getX();
    int y = position.getY();
    
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
