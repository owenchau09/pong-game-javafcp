
/*
 * Author: Ed Taylor
 * Date:   04/28/2019
 * 
 * GUI Primer
 * 
 * This code creates a Jpanel and draws a basic shape and graphics image
 * with various scaling options.
 * 
 * Each experiment is delineated with *****.  Comment, uncomment each experiment
 * and explore how the code effects the scale
 * 
 */

import java.awt.*;
import javax.swing.*;

public class CustomPanel extends JPanel
{
   // fields
   private Image tree = new ImageIcon("tree.gif").getImage();
   
   // methods
   public void paint(Graphics g) {
   
      super.paintComponent(g);
 
      // ***** experiment 1: no shape scale, no position change
      // draw basic shape on the panel
      g.setColor(Color.RED);
      g.fillRect(200, 150, 400,300);
      
      //draw image on the panel
      g.drawImage(tree, 200, 150, this);
      // *****
      
//      //***** experiment 2: no shape scale, relative position at center of window
//      int xCenter = getWidth() / 2;
//      int yCenter = getHeight() / 2; 
//      
//      g.setColor(Color.RED);
//      g.fillRect(xCenter-200, yCenter-150, 400,300);
//    
//      //draw image on the panel
//      g.drawImage(tree, xCenter-200, yCenter-150, this);
//      // *****
      
//      // ***** experiment 3: shape scale, relative position scale using brute force transformational algebra
//      
//      int width = getWidth();
//      int height = getHeight();
//      
//      int xCenter = width / 2;
//      int yCenter = height / 2;
//      
//      double xRatio = width/800.0;
//      double yRatio = height/600.0;
//      
//        int newWidth = (int) (400 * xRatio);
//      int newHeight = (int) (300 * yRatio);
//      int newCenterx = xCenter - newWidth/2;
//      int newCentery = yCenter - newHeight/2;
//      
//      //System.out.println("width: "  + width +
//      //                   "|height: "  + height +
//      //                   "|xRatio: "  + xRatio +
//      //                   "|yRatio: " + yRatio + 
//      //                   "|newWidth: " + newWidth + 
//      //                   "|newHeight: " + newHeight +
//      //                   "|newCenterx: " + newCenterx +
//      //                   "|newCentery: " + newCentery + "\n");
//      
//      // draw shape on the panel with scaled position and size
//      g.setColor(Color.RED);
//      g.fillRect(newCenterx, newCentery, newWidth, newHeight);
//      
//      // draw image on the panel with scaled position and size
//      g.drawImage(tree, newCenterx, newCentery,newWidth, newHeight, this);
//      //*****
      
//    // ***** experiment 4: shape scale, relative position scale using Graphics2D
//      
//    int width = getWidth();
//    int height = getHeight();
//    
//    double xRatio = width/800.0;
//    double yRatio = height/600.0;
//      
//    Graphics2D g2 = (Graphics2D)g;
//    g2.scale(xRatio,yRatio);
//    
//    // draw basic shape on the panel
//    g2.setColor(Color.RED);
//    g2.fillRect(200, 150, 400,300);
//  
//    //draw image on the panel
//    g2.drawImage(tree, 200, 150, this);
//    //*****

        
   }
   
  
   

}
