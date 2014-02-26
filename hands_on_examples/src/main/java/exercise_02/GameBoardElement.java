package exercise_02;

import java.awt.*;

/**
 * The game board element interface...
 */
public interface GameBoardElement {

	/**
	 * @return the current position of this game board element.
	 */
	Position getCurrentPosition();

	/**
	 * @return the avatar image of this game board element.
	 */
	Image getImage();

}
