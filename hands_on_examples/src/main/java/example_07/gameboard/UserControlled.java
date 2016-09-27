package example_07.gameboard;

import example_07.positionfindstrategies.UserInput;

public interface UserControlled {

  Position calculateNextPositionByUserInput(UserInput userInput);
  
}
