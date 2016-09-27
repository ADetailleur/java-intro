package example_07.alliance;

import java.awt.*;
import java.util.Collection;

import example_07.gameboard.GameBoardElement;
import example_07.gameboard.Position;
import example_07.gameboard.UserControlled;
import example_07.positionfindstrategies.UserInput;
import example_07.positionfindstrategies.UserInputPositionStrategy;
import example_07.utils.ImageLoader;

/**
 * This is the hero of the game.
 */
public class Protagonist extends RebelAllianceMember implements UserControlled {

	/*
	 * Icon by http://www.artua.com/, retrieved here:
	 * http://www.iconarchive.com/show/star-wars-icons-by-artua.html
	 */
	private static Image icon = new ImageLoader().loadIcon("protagonist.png");

	private static final int INITIAL_POWER = 30;

	public Protagonist(Position position) {
		super(position);
		setPower(INITIAL_POWER);
	}

	@Override
	public Image getImage() {
		return icon;
	}

	@Override
	public Position calculateNextPosition(Collection<GameBoardElement> elements) {
		return null;
	}

	@Override
	public Position calculateNextPositionByUserInput(UserInput userInput) {
		return new UserInputPositionStrategy(userInput).findNextPosition(getCurrentPosition(), null);
	}

}
