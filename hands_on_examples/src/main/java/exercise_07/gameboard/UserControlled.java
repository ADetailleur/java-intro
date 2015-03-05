package exercise_07.gameboard;

import exercise_07.positionfindstrategies.UserInput;

public interface UserControlled {

  Position calculateNextPositionByUserInput(UserInput userInput);
  
}
