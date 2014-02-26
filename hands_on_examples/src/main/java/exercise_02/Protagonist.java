package exercise_02;

import java.awt.*;

/**
 * This is the hero of the game.
 */
public class Protagonist implements GameBoardElement {

	private Position position;

	public Protagonist(Position position) {
		this.position = position;
	}

	@Override
	public Position getCurrentPosition() {
		return position;
	}

	@Override
	public Image getImage() {
		/*
		 * Icon by http://www.artua.com/, retrieved here:
		 * http://www.iconarchive.com/show/star-wars-icons-by-artua.html
		 */
		return new ImageLoader().loadIcon("protagonist.png");
	}

}
