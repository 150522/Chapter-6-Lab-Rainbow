// Chapter 6 Question 19
// Bernard Jiang

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rainbow extends JPanel
{
  private Color skyColor = Color.CYAN; // Declare the private field skyColor that generates the color of the background

  public Rainbow()
  {
    setBackground(skyColor); //Sets the Background to the color of the sky
  }

  // Draws the rainbow
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int width = getWidth(); //Defines the width of the window as an integer
    int height = getHeight(); //Defines the height of the window as an integer

    int xCenter = width/2; //The horizontal position of the center of the rings
    int yCenter = (3 * height)/4; //The vertical position of the center of the rings
 
    int largeRadius = width/4; //The radius of the largest semi-circle is 1/4 of the the width.
    int smallRadius = height/4; //The radius of the smallest semi-circle is 1/4 of the height.
    int mediumRadius = (int)Math.sqrt((smallRadius * largeRadius));
    //The radius of the middle semi-circle is the geometric mean of the largest and smallest semi-circles.
    
    // Draws the largest semi-circle
    g.setColor(Color.RED);
    g.fillArc(xCenter - largeRadius, yCenter - largeRadius, 2 * largeRadius, 2 * largeRadius, 0, 180);
    
    //Draws the middle semi-circle
    g.setColor(Color.GREEN);
    g.fillArc(xCenter - mediumRadius, yCenter - mediumRadius, 2 * mediumRadius, 2 * mediumRadius, 0, 180);
    
    //Draws the smallest semi-circle
    g.setColor(Color.MAGENTA);
    g.fillArc(xCenter - smallRadius, yCenter - smallRadius, 2 * smallRadius, 2 * smallRadius, 0, 180);
    
    /* The radius of the sky colored semi-circle in the middle.
     * It is calculated in a way that makes the width of the middle ring the arithmetic mean of the outermost and innermost ring.
     * The width of the largest ring is largeRadius - mediumRadius.
     * The width of the smallest ring is smallRadius - smallerRadius.
     * The width of the middle ring is mediumRadius - smallRadius.
     * The arithmetic mean of the largest ring and the smallest ring can be found by:
     * ((largeRadius - mediumRadius) + (smallRadius - smallerRadius))/2
     * Setting this equal to mediumRadius - smallRadius and solving for smaller radius gives the radius of the sky-colored semi-circle.
     */
    int smallerRadius = 3 * (smallRadius - mediumRadius) + largeRadius;
    
    // Draws the sky-color semi-circle
    g.setColor(skyColor);
    g.fillArc(xCenter - smallerRadius, yCenter - smallerRadius, 2 * smallerRadius, 2 * smallerRadius, 0, 180);
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Rainbow"); //Generates a window titled Rainbow
    w.setBounds(300, 300, 300, 200); //The location and dimensions of the window
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Tells the computer what to do when the window is closed
    Container c = w.getContentPane();
    c.add(new Rainbow());
    w.setVisible(true);
  }
}
