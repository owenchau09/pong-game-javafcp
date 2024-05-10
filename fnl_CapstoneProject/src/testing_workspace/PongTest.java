package testing_workspace;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
//main class
public class PongTest extends JPanel implements ActionListener//, KeyListener
{
//	private static final String JButton = null;
	private static JTextField display;
	
	private static int WINDOW_WIDTH = 800, WINDOW_HEIGHT = 600;
	JPanel bottomPanel = new JPanel(new BorderLayout());
	JPanel topPanel = new JPanel(new BorderLayout());
	static JPanel welcomeScreen;
	static JFrame mainWindow;
	static JButton clickMe;
	static JPanel scoreBoard = new JPanel();
	static Drawer panel;
	
	public static void main(String[] args)
	{
		
		mainWindow = new JFrame("Pong Game Remix");
		clickMe = new JButton("Press to play against a cpu");
		mainWindow.setBounds(150, 50, WINDOW_WIDTH+15, WINDOW_HEIGHT+32);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT);
		mainWindow.setVisible(true);
		welcomeScreen = new JPanel();
		welcomeScreen.setBackground(Color.GREEN);
		welcomeScreen.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		JLabel label = new JLabel("Hello and welcome to the Pong Game Remix!");
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
					}
				});
		mainWindow.add(welcomeScreen);
		welcomeScreen.add(clickMe);
		Timer timer = new Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        panel.run();
		        panel.repaint();
			}
		});
		timer.start();
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}

		       
			
		
	   
		
		
	
	

