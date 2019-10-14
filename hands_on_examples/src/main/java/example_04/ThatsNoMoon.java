package example_04;

import java.awt.Graphics2D;
import java.awt.Image;

public class ThatsNoMoon extends MoonBase {

  Image icon = loadIcon();

  int iconCoordinateX = 100;
  int iconCoordinateY = 50;

  /**
   * This method is periodically called. You can manipulate the x and y
   * coordinates. See what happens if you do that and start the program.
   */
  public void updateValues() {

    /*
     * Add code to update the coordinates of the icon, for example like this:
     *    iconCoordinateX = iconCoordinateX + 1;
     * 
     * or, in the short version which is equivalent: 
     *    iconCoordinateX += 1;
     */

	  
    
    
    
    
    
    
    
    
    
    
    
    /*
     * Some additional help:
     * 
     * Get the width (and analogous, the height) of the icon with this call:
     *    icon.getWidth(null)
     * 
     * Get the width (and analogous, the height) of the window with this call:
     *    getWidth()
     * 
     * Oh, and introduce a variable 'speed' instead of the constant number. Put
     * it up to the coordinate definitions.
     */

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
     * More help:
     * 
     * Use a branch to let the moon change direction at the border. This could
     * look as follows. (Certainly you need to replace the textual boolean
     * condition with real code!)
     * 
     *    if (<coordinates are larger than the window size>) { 
     *      speed = - speed; 
     *    }
     */

    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
     * Even more help:
     * 
     * For acceleration, also change the speed variable:
     * 
     *    speed = speed + 1; // This would be the acceleration 
     *    iconCoordinateY = iconCoordinateY + speed;
     */

    
    
    
    
    
    
  }











  
  // You can safely ignore the following method for now. :)

  @Override
  protected void drawImageOn(Graphics2D g2) {
    g2.drawImage(icon, iconCoordinateX, iconCoordinateY, null);
  }
  
  private static final long serialVersionUID = 1L;
  
  public static void main(String[] args) {
		start();
	}

}
