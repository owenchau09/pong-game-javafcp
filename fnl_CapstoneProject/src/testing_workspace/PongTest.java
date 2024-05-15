package testing_workspace;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
public class PongTest extends JPanel implements ActionListener
{	
	private int WINDOW_WIDTH = 800, WINDOW_HEIGHT = 400, level = 4,y=1, x= 2, z=3;
	JPanel welcomeScreen;
	JFrame mainWindow;
	JButton clickCPU, clickPVP, clickEasy, clickMedium, clickHard, clickRandom, clickMe3;
	Drawer panel, panel2, panel3, easy, medium, hard;
	
		public PongTest() {
			mainWindow = new JFrame("Pong Game Remix");
			clickCPU = new JButton("Press to play against a cpu!");
			clickEasy = new JButton("Easy");  //4 cpu modes
			clickMedium = new JButton("Medium");
			clickHard = new JButton("Hard");
			clickHard = new JButton("Random Mode");
			clickPVP = new JButton("Press to play against your friend!");
			clickMe3 = new JButton("Press to play a four paddle game!");
			mainWindow.setBounds(150, 50, WINDOW_WIDTH+15, WINDOW_HEIGHT+82);
			mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			panel = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, y);
			panel2 = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, x);
			panel3 = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, z);
			easy = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, 1);
			medium = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, 2);
			hard = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, 3);
			mainWindow.setVisible(true);
			welcomeScreen = new JPanel();
			welcomeScreen.setBackground(Color.GREEN);
			welcomeScreen.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
			JLabel label = new JLabel("Welcome To Pong");
			
			clickCPU.setPreferredSize(new Dimension(250, 100));
			clickCPU.setBackground(Color.RED);
			clickPVP.setPreferredSize(new Dimension(300, 100));
			clickPVP.setBackground(Color.PINK);
			clickEasy.setPreferredSize(new Dimension(100, 100));
			clickEasy.setBackground(Color.CYAN);
			
			welcomeScreen.add(label);
			
			clickCPU.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent l)
						{
							
							clickEasy.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent l) { 
								welcomeScreen.setVisible(false);
								mainWindow.remove(welcomeScreen);
								Timer timer = new Timer(30, new ActionListener() {
									public void actionPerformed(ActionEvent e) {
								        easy.run();
								        easy.repaint();
									}
								});
								timer.setInitialDelay(1000);
								timer.start();
								mainWindow.addKeyListener(easy);
								mainWindow.add(easy);
								welcomeScreen.setVisible(true);
								mainWindow.requestFocus();
							}});
							
							clickMedium.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent l) { 
								welcomeScreen.setVisible(false);
								mainWindow.remove(welcomeScreen);
								Timer timer = new Timer(30, new ActionListener() {
									public void actionPerformed(ActionEvent e) {
								        medium.run();
								        medium.repaint();
									}
								});
								timer.setInitialDelay(1000);
								timer.start();
								mainWindow.addKeyListener(medium);
								mainWindow.add(medium);
								welcomeScreen.setVisible(true);
								mainWindow.requestFocus();
							}});
							
							clickHard.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent l) { 
								welcomeScreen.setVisible(false);
								mainWindow.remove(welcomeScreen);
								Timer timer = new Timer(30, new ActionListener() {
									public void actionPerformed(ActionEvent e) {
								        hard.run();
								        hard.repaint();
									}
								});
								timer.setInitialDelay(1000);
								timer.start();
								mainWindow.addKeyListener(hard);
								mainWindow.add(hard);
								welcomeScreen.setVisible(true);
								mainWindow.requestFocus();
							}});
							
							
							
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
			clickMe3.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent l)
						{
							welcomeScreen.setVisible(false);
							mainWindow.remove(welcomeScreen);
							mainWindow.addKeyListener(panel3);
							mainWindow.add(panel3);
							welcomeScreen.setVisible(true);
							mainWindow.requestFocus();
							
							Timer timer = new Timer(30, new ActionListener() {
								public void actionPerformed(ActionEvent e) {
							        panel3.run();
							        panel3.repaint();
								}
							});
							timer.setInitialDelay(1000);
							timer.start();
						}
					});
			mainWindow.add(welcomeScreen);
	
			welcomeScreen.add(clickCPU);
			welcomeScreen.add(clickEasy);
			welcomeScreen.add(clickMedium);
			welcomeScreen.add(clickHard);
			welcomeScreen.add(clickRandom);
			welcomeScreen.add(clickPVP);
			welcomeScreen.add(clickMe3);
		}
	
	
	public static void main(String[] args)
	{
		new PongTest();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
		       
			
		
	   
		
		
	
	

