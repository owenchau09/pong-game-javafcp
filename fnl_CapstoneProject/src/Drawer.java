
//import java.awt.Color;
import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.JPanel;
//import javax.swing.Timer;

public class Drawer extends JPanel //implements ActionListener
{
	
	private Paddle p1;
	
	public Drawer()
	{
		p1 = new Paddle(300, 300, 100, 100);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		p1.draw(g);
	}



}
