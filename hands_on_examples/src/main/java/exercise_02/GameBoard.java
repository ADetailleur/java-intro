package exercise_02;

import java.util.*;

/**
 * The game board holds information about all game board elements.
 */
public class GameBoard {

  Map<Position, GameBoardElement> elements = new HashMap<Position, GameBoardElement>();

  public GameBoard(int horizontalFields, int verticalFields) {
  }

  public void addElement(GameBoardElement gameBoardElement) {
    elements.put(gameBoardElement.getCurrentPosition(), gameBoardElement);
  }

  public Collection<GameBoardElement> getElements() {
    return elements.values();
  }
}
