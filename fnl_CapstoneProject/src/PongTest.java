import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
//main class
public class PongTest extends JPanel implements ActionListener
{	
	private static int WINDOW_WIDTH = 800, WINDOW_HEIGHT = 600;
	JPanel bottomPanel = new JPanel(new BorderLayout());
	JPanel topPanel = new JPanel(new BorderLayout());
	static JPanel welcomeScreen;
	static JFrame mainWindow;
	static JButton clickMe;
//	static JPanel scoreBoard = new JPanel();
	static Drawer panel;
	
	public static void main(String[] args)
	{
		
		mainWindow = new JFrame("Pong Game Remix");
		clickMe = new JButton("Press to play against a cpu");
//		mainWindow.setBounds(150, 50, WINDOW_WIDTH+15, WINDOW_HEIGHT+32);
		mainWindow.setBounds(150, 50, WINDOW_WIDTH, WINDOW_HEIGHT+50);
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
						

//				 		Drawer drawer1 = new Drawer();
//				 		int cpuScore = drawer1.getCpuScore();
//				 		int p1sScore = drawer1.getP1Score();
//				 		
//				 		scoreBoard.setBounds(0, 0, WINDOW_WIDTH, 50);
//				 		
//				 		JPanel p1Score = new JPanel();
//				 		p1Score.setBounds(10, 20, 25, 25);
//				 		p1Score.setBackground(Color.WHITE);
//				 		JLabel actp1Sco = new JLabel("" + p1sScore);
//				 		p1Score.add(actp1Sco);
//				 		scoreBoard.add(p1Score);			 		
//				 		JPanel cpusScore = new JPanel();
//				 		cpusScore.setBounds(40, 20, 25, 25);
//				 		cpusScore.setBackground(Color.WHITE);
//				 		JLabel actSco = new JLabel("" + cpuScore);
//				 		cpusScore.add(actSco);
//				 		scoreBoard.add(cpusScore);
//				 		scoreBoard.setBackground(Color.BLACK);
//				 		mainWindow.add(scoreBoard);
////				 		scoreBoard.requestFocus();
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
		mainWindow.add(welcomeScreen);
		welcomeScreen.add(clickMe);
//		timer.setInitialDelay(1000);
		
		
		
		
		
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}

		       
			
		
	   
		
		
	
	

