package exercise_03.utils;

import java.awt.Image;

import javax.imageio.ImageIO;

/**
 * A helper class which loads an image into a image object.
 */
public class ImageLoader {

	/**
	 * Loads the icon and returns an images which is paintable by the drawImage method.
	 * 
	 * @return loaded icon, or null if there were problems loading it.
	 */
	public Image loadIcon(String fileName) {
		try {
			/*
			 * Icon by http://www.artua.com/, retrieved here:
			 * http://www.iconarchive.com/show/star-wars-icons-by-artua.html
			 */
      return ImageIO.read(getClass().getClassLoader().getResource(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
