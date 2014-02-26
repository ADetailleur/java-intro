package exercise_01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JPanel;

class ThatsNoMoon extends JApplet implements Runnable {
	
	Image icon = loadIcon();

	int iconCoordinateX = 100;
	int iconCoordinateY = 50;
	
	/**
	 * This method is periodically called. You can manipulate the x and y coordinates. 
	 * See what happens if you do that and start the program.
	 */
	void updateValues() {
		
		/*
		 * Add code to update the coordinates of the icon, for example like this:
		 * 		iconCoordinateX = iconCoordinateX + 1;
		 * 
		 * or, in the short version which is equivalent:
		 *  	iconCoordinateX += 1;
		 */
		
		
		
		
	
	
	
	
		/*
		 * Some additional help: 
		 * 
		 * Get the width (and analogous, the height) of the icon with this call:
		 *  	icon.getWidth(null)
		 *  
		 *  Get the width (and analogous, the height) of the window with this call:
		 *  	getWidth()
		 *  
		 *  Oh, and introduce a variable 'speed' instead of the constant number. Put it
		 *  up to the coordinate definitions.
		 */
		
		
		
		
		
		
		
		
		
		/*
		 * More help: 
		 * 
		 * Use a branch to let the moon change direction at the border. This could look as follows.
		 * (Certainly you need to replace the textual boolean condition with real code!)
		 * 
		 * 	 if (coordinates are larger than the window size) {
		 * 		speed = - speed;
		 * 	 }
		 */
		
		
	
		
		/*
		 * Even more help: 
		 * 
		 * For acceleration, also change the speed variable:
		 * 
		 *   speed = speed + 1; // This would be the acceleration
		 *   iconCoordinateY = iconCoordinateY + speed;
		 */
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* Below some configuration stuff. Ignore for now. If you're bold, you can play around with it a bit. */

	
	@Override
	public void run() {
		while(true) {
			updateValues();
			repaint();
			sleepMilliseconds(20);
		}
	}
	
	/**
	 * Does the initial configuration of the program window.
	 */
	private void configureWindow() {
		background.setBackground(Color.BLACK);
		setSize(initialWindowWidth, initialWindowHeight);
	}
	
	/**
	 * Lets the thread sleep for the number of milliseconds provided.
	 * 
	 * @param milliseconds how long should I sleep?
	 */
	private void sleepMilliseconds(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void init() {
		super.init();

		background = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				Graphics2D g2 = (Graphics2D) g;
				g2.drawImage(icon, iconCoordinateX, iconCoordinateY, null);
			}
		};
		
		add(background);
		configureWindow();
		
		new Thread(this).start();
	}
	
	/**
	 * Loads the icon and returns an images which is paintable by the drawImage method.
	 * 
	 * @return loaded icon, or null if there were problems loading it.
	 */
	private Image loadIcon() {
		try {
			/*
			 * Icon by http://www.artua.com/, retrieved here:
			 * http://www.iconarchive.com/show/star-wars-icons-by-artua.html
			 */
			return ImageIO.read(new File("icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static final long serialVersionUID = 1L;
	private JPanel background;
	private int initialWindowWidth = 800;
	private int initialWindowHeight = 600;
	
}
