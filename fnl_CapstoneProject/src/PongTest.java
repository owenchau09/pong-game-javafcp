import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
//main class
public class PongTest extends JPanel implements ActionListener
{	
	private int WINDOW_WIDTH = 800, WINDOW_HEIGHT = 600, y = 1;
	JPanel bottomPanel = new JPanel(new BorderLayout());
	JPanel topPanel = new JPanel(new BorderLayout());
	JPanel welcomeScreen;
	JFrame mainWindow;
	JButton clickMe, clickMe2;
	Drawer panel, panel2;
	
	public PongTest() {
		mainWindow = new JFrame("Pong Game Remix");
		clickMe = new JButton("Press to play against a cpu!");
		clickMe2 = new JButton("Press to play against your friend!");
		mainWindow.setBounds(150, 50, WINDOW_WIDTH+15, WINDOW_HEIGHT+82);
//		mainWindow.setBounds(150, 50, WINDOW_WIDTH, WINDOW_HEIGHT+50);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT);
		panel2 = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, y);
		mainWindow.setVisible(true);
		welcomeScreen = new JPanel();
		welcomeScreen.setBackground(Color.GREEN);
		welcomeScreen.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		JLabel label = new JLabel("Welcome To Pong");
		
		clickMe.setPreferredSize(new Dimension(250, 100));
		clickMe.setBackground(Color.RED);
		clickMe2.setPreferredSize(new Dimension(300, 100));
		clickMe2.setBackground(Color.PINK);
		
		welcomeScreen.add(label);
		
		clickMe.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent l)
					{
						welcomeScreen.setVisible(false);
						mainWindow.remove(welcomeScreen);
						mainWindow.addKeyListener(panel);
						mainWindow.add(panel);
						welcomeScreen.setVisible(true);
						mainWindow.requestFocus();
						
						Timer timer = new Timer(30, new ActionListener() {
							public void actionPerformed(ActionEvent e) {
						        panel.run();
						        panel.repaint();
							}
						});
						timer.setInitialDelay(1000);
						timer.start();
					}
				});
		
		
		clickMe2.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent l)
					{
						welcomeScreen.setVisible(false);
						mainWindow.remove(welcomeScreen);
						mainWindow.addKeyListener(panel2);
						mainWindow.add(panel2);
						welcomeScreen.setVisible(true);
						mainWindow.requestFocus();
						
						Timer timer = new Timer(30, new ActionListener() {
							public void actionPerformed(ActionEvent e) {
						        panel2.run();
						        panel2.repaint();
							}
						});
						timer.setInitialDelay(1000);
						timer.start();
					}
				});
		mainWindow.add(welcomeScreen);

		welcomeScreen.add(clickMe);
		welcomeScreen.add(clickMe2);
	}
	
	
	public static void main(String[] args)
	{
		new PongTest();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}

		       
			
		
	   
		
		
	
	

