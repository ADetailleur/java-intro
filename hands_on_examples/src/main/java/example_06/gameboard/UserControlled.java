package example_06.gameboard;

import example_06.positionfindstrategies.UserInput;

public interface UserControlled {

  Position calculateNextPositionByUserInput(UserInput userInput);
  
}
