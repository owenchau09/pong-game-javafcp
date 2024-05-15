package testing_workspace;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//main class
public class PongTest extends JPanel implements ActionListener
{	
	private int WINDOW_WIDTH = 800, WINDOW_HEIGHT = 400, level = 4;
	JPanel welcomeScreen;
	JFrame mainWindow;
	JButton clickCPU, clickPVP, clickEasy, clickMedium, clickHard, clickRandom;
	Drawer panel, panel2;
	
	public PongTest() {
		mainWindow = new JFrame("Pong Game Remix");
		clickCPU = new JButton("Press to play against a cpu!");
//		clickEasy = new JButton("Easy");  //4 cpu modes
//		clickMedium = new JButton("Medium");
//		clickHard = new JButton("Hard");
//		clickHard = new JButton("Random Mode");
		clickPVP = new JButton("Press to play against your friend!");
		mainWindow.setBounds(150, 50, WINDOW_WIDTH+15, WINDOW_HEIGHT+82);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, level); //MAKE SURE the value of 'level' changes depending on what button is clicked
		panel2 = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT);
		mainWindow.setVisible(true);
		welcomeScreen = new JPanel();
		welcomeScreen.setBackground(Color.GREEN);
		welcomeScreen.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		JLabel label = new JLabel("Welcome To Pong");
		
		clickCPU.setPreferredSize(new Dimension(250, 100));
		clickCPU.setBackground(Color.RED);
		clickPVP.setPreferredSize(new Dimension(300, 100));
		clickPVP.setBackground(Color.PINK);
		
		welcomeScreen.add(label);
		
		clickCPU.addActionListener(
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
		
		
		clickPVP.addActionListener(
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

		welcomeScreen.add(clickCPU);
		welcomeScreen.add(clickPVP);
	}
	
	
	public static void main(String[] args)
	{
		new PongTest();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}

		       
			
		
	   
		
		
	
	

