package exercise_02;

import java.awt.Image;

/**
 * The friendly helpers of the protagonist.
 */
public class Robot implements GameBoardElement {

	private Position position;

	public Robot(Position position) {
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
		return new ImageLoader().loadIcon("robot.png");
	}

}
