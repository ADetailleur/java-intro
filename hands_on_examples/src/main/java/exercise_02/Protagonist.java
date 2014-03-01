package exercise_02;

import java.awt.*;
import java.util.Collection;

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
  
	private Position position;
	
	
	public Protagonist(Position position) {
		this.position = position;
		setPower(INITIAL_POWER);
	}

	@Override
	public Position getCurrentPosition() {
		return position;
	}
	
	@Override
	public void setPosition(Position position) {
    this.position = position;
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
    return new UserInputPositionStrategy(position, userInput).findNextPosition(null);
  }

}
