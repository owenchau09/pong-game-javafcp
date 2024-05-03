package test;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
   This class demos collision detection through pixel colors on a BufferedImage.
   
   This strategy can be useful to detect collisions between objects that are especially weirdly
   shaped.

   @author  Shelby
 */
public class SimpleWindow extends JPanel implements KeyListener
{
  // TODO Your Instance Variables Here
  private Rectangle player;
  private MovingImage weirdShape;
  
  private boolean collision;

  public SimpleWindow () {
	  super();
	  player = new Rectangle(0,0,50,50);
	  weirdShape = new MovingImage("squiggle.gif",0,0,640,460);
	  
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method
                              //   to paint the background

    int width = getWidth();
    int height = getHeight();
    
    weirdShape.draw(g, this);
    
    g.setColor(Color.ORANGE);
    g.fillRect(player.x, player.y, player.width, player.height);

    if (collision) {
    	g.setColor(Color.BLACK);
    	g.setFont(new Font("SansSerif",Font.BOLD,30));
    	FontMetrics fm = g.getFontMetrics();
    	String s = "A collision occurred with the squiggle!";
    	g.drawString(s, width/2 - fm.stringWidth(s)/2, height/2);
    }
    
  }
  
  public void checkCollision() {
	  BufferedImage pic = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB); // Make a new image that I can draw on
	  Graphics g = pic.getGraphics(); // This Graphics will draw on to the image
	  g.setColor(Color.WHITE); 
	  g.fillRect(0, 0, pic.getWidth(), pic.getHeight()); // Make the whole image white
	  weirdShape.draw(g, this); // Draw the squiggle on the image
	  collision = false;
	  for (int i = player.x; i < player.x + player.width; i++ ) {   // Look at every pixel coordinate in the rectangle
		  for (int j = player.y; j < player.y + player.height; j++ ) {
			  if (pic.getRGB(i, j) != Color.WHITE.getRGB()) {  // If that pixel is not white 
				  collision = true;  // There was a collision!
			  }
		  }  
	  }
  }
  
  @Override
  public void keyPressed(KeyEvent arg0) {
  	int code = arg0.getKeyCode();
  	if (code == KeyEvent.VK_UP) {
  		player.y-=5;
  	} else if (code == KeyEvent.VK_DOWN) {
  		player.y+=5;
  	} else if (code == KeyEvent.VK_LEFT) {
  		player.x-=5;
  	} else if (code == KeyEvent.VK_RIGHT) {
  		player.x+=5;
  	}
  	stayOnWindow(player);
  	checkCollision();
  	repaint();
  }

  @Override
  public void keyReleased(KeyEvent arg0) {
  	// TODO Auto-generated method stub
  	
  }

  @Override
  public void keyTyped(KeyEvent arg0) {
  	// TODO Auto-generated method stub
  	
  }
  
  public void stayOnWindow(Rectangle r) {
	  r.x = Math.max(r.x, 0);
	  r.y = Math.max(r.y, 0);
	  r.x = Math.min(r.x, getWidth()-r.width);
	  r.y = Math.min(r.y, getHeight()-r.height);
  }



  public static void main(String[] args)
  {
    JFrame w = new JFrame("Simple Window");
    w.setBounds(100, 100, 640, 480);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    SimpleWindow panel = new SimpleWindow();
    w.addKeyListener(panel);
    panel.setBackground(Color.WHITE);
    Container c = w.getContentPane();
    c.add(panel);
    w.setResizable(true);
    w.setVisible(true);
    
    JOptionPane.showMessageDialog(w, "Press UP,DOWN,LEFT, or RIGHT!");
  }
  
  
}


