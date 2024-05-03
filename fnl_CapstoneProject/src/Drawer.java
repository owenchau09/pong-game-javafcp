
import java.awt.Color;
import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.JPanel;
//import javax.swing.Timer;

public class Drawer extends JPanel //implements ActionListener
{
	
	Paddle p1 = new Paddle();
	
	public Drawer()
	{
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		p1.draw(g);
	}



}
