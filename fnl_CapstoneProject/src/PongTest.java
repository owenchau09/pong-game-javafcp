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
//	static Drawer panel = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT);
	static JPanel welcomeScreen;
	static JFrame mainWindow;
	static JButton clickMe;
	JPanel scoreBoard = new JPanel();
	Drawer panel = new Drawer (1000, 500);
	
	public static void main(String[] args)
	{
		
		new PongTest();
	
	}
	public PongTest()
	{
		mainWindow = new JFrame("Pong Game Remix");
		mainWindow.setResizable(false);
		mainWindow.setBounds(150, 50, WINDOW_WIDTH+15, WINDOW_HEIGHT+32);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		PongTest panel = new PongTest();		
//		mainWindow.add(panel);
		mainWindow.setResizable(true);
		mainWindow.setVisible(true);
		
		mainWindow.addKeyListener(panel);
		Timer timer = new Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        panel.run();
		        panel.repaint();
			}
		});
		//timer.start();
		
		welcomeScreen = new JPanel();
		welcomeScreen.setBackground(Color.GREEN);
		welcomeScreen.setBounds(0, 0, 800, 800);
		JLabel label = new JLabel("Hello and welcome to the Pong Game Remix!");
		welcomeScreen.add(label);
		clickMe = new JButton("Press to play against a cpu");
		clickMe.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent l)
					{
						welcomeScreen.setVisible(false);
						mainWindow.remove(welcomeScreen);
					
						mainWindow.add(panel);
						timer.start();
					}
				});
		welcomeScreen.add(clickMe);
		welcomeScreen.setVisible(true);
		
		mainWindow.add(welcomeScreen);
		
		
		
		
//		
		
// 		Drawer drawer1 = new Drawer();
// 		int p1sScore = drawer1.getp1Score();
// 		int cpuScore = drawer1.getcpuScore();
// 		
// 		
// 		
// 		scoreBoard.setBounds(0, 0, 100, 50);
// 		
// 		JPanel p1Score = new JPanel();
// 		p1Score.setBounds(10, 20, 25, 25);
// 		p1Score.setBackground(Color.WHITE);
// 		JLabel actp1Sco = new JLabel("" + p1sScore);
// 		p1Score.add(actp1Sco);
// 		scoreBoard.add(p1Score);
// 		
// 		JPanel cpusScore = new JPanel();
// 		cpusScore.setBounds(40, 20, 25, 25);
// 		cpusScore.setBackground(Color.WHITE);
// 		JLabel actSco = new JLabel("" + cpuScore);
// 		cpusScore.add(actSco);
// 		scoreBoard.add(cpusScore);
// 		
// 		
// 		scoreBoard.setBackground(Color.BLACK);
		
		
		
		
		
		
		//JPanel welcomeScreen = new JPanel();
		
		 		
// 		welcomeScreen = new JPanel();
// 		JLabel label = new JLabel("Hello:");
// 		welcomeScreen.add(label);
// 		JButton clickMe = new JButton("Press for new screen!");
// 		welcomeScreen.setVisible(true);
// 		
// 		mainWindow.add(welcomeScreen);
		
		
// 		secondScreen = new JPanel();
// 		JLabel label1 = new JLabel("Hello again!");
// 		secondScreen.add(label1);
// 		secondScreen.setVisible(false);
// 		
// 		mainWindow.add(secondScreen);
		
			
	}
	
//	@Override
	public void actionPerformed(ActionEvent k) {
	
	}
//		// TODO Auto-generated method stub
//		
//		if (k.getSource() == clickMe)
//		{
//			welcomeScreen.setVisible(false);
//			mainWindow.remove(welcomeScreen);
//			
//			
//			
//
//			
//			//mainWindow.add(scoreBoard);
//			mainWindow.add(panel);
//			
//		}
//		
//		
//		
//		
//		
//		bottomPanel.setVisible(false);
//		
//		
////		Timer timer = new Timer(30, new ActionListener() {
////			public void actionPerformed(ActionEvent e) {
////		        panel.run();
////		        panel.repaint();
////			}
////		});
////		timer.start();
//		
//	}
//	
//	public void actionPerformed(KeyEvent b)
//	{
//		
//	}
	
	
}
		       
			
		
	   
		
		
	
	

