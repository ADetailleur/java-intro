package example_04;

import java.awt.Graphics2D;
import java.awt.Image;

public class ThatsNoMoon extends MoonBase {

  Image icon = loadIcon();
  int verticalSpeed = 0;
  int horizontalSpeed = 0;

  boolean rightDirection = true;
  boolean downDirection = false;

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

	  // Get heights and width
      int iconWidth = icon.getWidth(null);
      int windowWidth = getWidth();
      int windowHeight = getHeight();

      // Make sure icon is within bounds

      if (iconCoordinateY > windowHeight || iconCoordinateY < 0) {
        downDirection = !downDirection;
      }


      // increase speed
      if (downDirection) {
        verticalSpeed = verticalSpeed - 1;
      }
      else {
        verticalSpeed = verticalSpeed + 1;
      }



      // update movement
      iconCoordinateX += horizontalSpeed;
      iconCoordinateY += verticalSpeed;






    
    
    
    
    
    
    
    
    
    
    
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
  
  public static void main(String[] args) {
		start();
	}

}
