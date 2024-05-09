package testing_workspace;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//main class
public class PongTest 
{

	private static int WINDOW_WIDTH = 1200, WINDOW_HEIGHT = 900;
	
 	public static void main(String[] args) {
		JFrame window = new JFrame("Pong Game Remix");
		window.setBounds(150, 50, 1280, 750); 
		window.setBounds(150, 50, WINDOW_WIDTH+15, WINDOW_HEIGHT+32); 
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Drawer panel = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT);
		window.addKeyListener(panel);
		window.add(panel);
		window.setVisible(true);
		
		//timer so that every 30 ms action occurs
		Timer timer = new Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        panel.run();
		        panel.repaint();
			}
		});
		timer.start();
		
		
	}
	
}
