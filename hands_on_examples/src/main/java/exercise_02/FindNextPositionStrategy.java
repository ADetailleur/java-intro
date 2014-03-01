package exercise_02;

import java.util.Collection;

public interface FindNextPositionStrategy {

  Position findNextPosition(Collection<GameBoardElement> elements);
  
}
