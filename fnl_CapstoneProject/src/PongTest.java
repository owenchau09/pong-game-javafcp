import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//main class
public class PongTest 
{
	private static JTextField display;

 	public static void main(String[] args) {
		JFrame mainwindow = new JFrame("Pong Game Remix");
		mainwindow.setResizable(false);
		mainwindow.setBounds(150, 50, 1280, 750); 
		mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Drawer panel = new Drawer();
		mainwindow.addKeyListener(panel);
		mainwindow.add(panel);
		JButton newButton = new JButton("Player vs Cpu");
		
		
		mainwindow.add(newButton);
		
		mainwindow.setVisible(true);
		
		//timer so that every 30 ms action occurs
		Timer timer = new Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        panel.run();
		        panel.repaint();
			}
		});
		timer.start();
		
		JFrame cpuWindow = new JFrame("Player vs Cpu");
		cpuWindow.setResizable(false);
		cpuWindow.setBounds(150, 50, 1280, 750); 
		cpuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Drawer secondPanel = new Drawer();
		cpuWindow.addKeyListener(panel);
		cpuWindow.add(panel);
		cpuWindow.setVisible(false);
		
		Timer timer1 = new Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				mainwindow.setVisible(false);
				cpuWindow.setVisible(true);
			}
		});
 	
 	}
}
		        
			

		
	    

		
		
	
	

