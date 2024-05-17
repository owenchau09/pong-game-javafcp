import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
public class PongTest extends JPanel implements ActionListener
{	
	private int WINDOW_WIDTH = 800, WINDOW_HEIGHT = 400;
	JPanel welcomeScreen;
	JFrame mainWindow;
	JButton clickCPU, clickPVP, clickEasy, clickMedium, clickHard, clickRandom, clickFourPVP;
	Drawer random, fourPVP, easy, medium, hard, PVP;
	
		public PongTest() {
			mainWindow = new JFrame("Pong Game Remix");
			mainWindow.setBounds(150, 50, WINDOW_WIDTH+15, WINDOW_HEIGHT+82);
			mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainWindow.setVisible(true);
			mainWindow.setResizable(false);
			
			welcomeScreen = new JPanel();
			welcomeScreen.setBackground(Color.GREEN);
			welcomeScreen.setBounds(0, 0, WINDOW_WIDTH+15, WINDOW_HEIGHT+82);
			
			JLabel label = new JLabel("Welcome To Pong");
			
			clickCPU = new JButton("Press to play against a cpu!");
			clickEasy = new JButton("Easy");  //4 cpu modes
			clickMedium = new JButton("Medium");
			clickHard = new JButton("Hard");
			clickRandom = new JButton("Random Mode");
			clickPVP = new JButton("Press to play against your friend!");
			clickFourPVP = new JButton("Press to play a four paddle game!");
			
			easy = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, 1);
			medium = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, 2);
			hard = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, 3);
			random = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, 4);
			PVP = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, 5);
			fourPVP = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, 6);
			
			clickCPU.setPreferredSize(new Dimension(250, 100));
			clickCPU.setBackground(Color.RED);
			clickPVP.setPreferredSize(new Dimension(300, 100));
			clickPVP.setBackground(Color.PINK);
			clickEasy.setPreferredSize(new Dimension(100, 100));
			clickEasy.setBackground(Color.CYAN);
			clickFourPVP.setPreferredSize(new Dimension(100, 100));
			clickFourPVP.setBackground(Color.CYAN);
			
			welcomeScreen.add(label);
			
			clickCPU.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent l)
						{
							
							welcomeScreen.setVisible(false);
							mainWindow.remove(welcomeScreen);
						
							welcomeScreen.setVisible(true);
							mainWindow.requestFocus();
							
							
							
							mainWindow.getContentPane().add(BorderLayout.WEST, clickEasy);
							
							
							
							clickEasy.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent l) { 
//								mainWindow.remove(welcomeScreen);
								mainWindow.requestFocus(); 
								mainWindow.remove(clickMedium);
								mainWindow.remove(clickEasy);
								mainWindow.remove(clickHard);
								welcomeScreen.setVisible(false);
								mainWindow.repaint();
								mainWindow.addKeyListener(easy);
								mainWindow.add(easy);
									
								Timer timer = new Timer(30, new ActionListener() {
									public void actionPerformed(ActionEvent e) {
								        easy.run();
								        easy.repaint();
									}
								});
								timer.setInitialDelay(1000);
								timer.start();							
								
								mainWindow.setVisible(true);
								
							}});
							
							clickMedium.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent l) { 
								mainWindow.requestFocus(); 
								mainWindow.remove(clickMedium);
								mainWindow.remove(clickEasy);
								mainWindow.remove(clickHard);
								welcomeScreen.setVisible(false);
								mainWindow.repaint();
								mainWindow.addKeyListener(medium);
								mainWindow.add(medium);
									
								Timer timer = new Timer(30, new ActionListener() {
									public void actionPerformed(ActionEvent e) {
								        medium.run();
								        medium.repaint();
									}
								});
								timer.setInitialDelay(1000);
								timer.start();							
								
								mainWindow.setVisible(true);
							}});
							
							clickHard.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent l) { 
								mainWindow.requestFocus(); 
								mainWindow.remove(clickMedium);
								mainWindow.remove(clickEasy);
								mainWindow.remove(clickHard);
								welcomeScreen.setVisible(false);
								mainWindow.repaint();
								mainWindow.addKeyListener(hard);
								mainWindow.add(hard);
									
								Timer timer = new Timer(30, new ActionListener() {
									public void actionPerformed(ActionEvent e) {
								        hard.run();
								        hard.repaint();
									}
								});
								timer.setInitialDelay(1000);
								timer.start();							
								
								mainWindow.setVisible(true);
							}});
							
							clickRandom.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent l) { 
								mainWindow.requestFocus(); 
								mainWindow.remove(clickMedium);
								mainWindow.remove(clickEasy);
								mainWindow.remove(clickHard);
								welcomeScreen.setVisible(false);
								mainWindow.repaint();
								mainWindow.addKeyListener(random);
								mainWindow.add(random);
									
								Timer timer = new Timer(30, new ActionListener() {
									public void actionPerformed(ActionEvent e) {
								        random.run();
								        random.repaint();
									}
								});
								timer.setInitialDelay(1000);
								timer.start();							
								
								mainWindow.setVisible(true);
							}});

							mainWindow.getContentPane().add(BorderLayout.CENTER, clickMedium);
							mainWindow.getContentPane().add(BorderLayout.EAST, clickHard);
							
						}
					});
			
			
			clickPVP.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent l)
						{
							welcomeScreen.setVisible(false);
							mainWindow.remove(welcomeScreen);
							mainWindow.addKeyListener(PVP);
							mainWindow.add(PVP);
							welcomeScreen.setVisible(true);
							mainWindow.requestFocus();
							
							Timer timer = new Timer(30, new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									PVP.run();
									PVP.repaint();
								}
							});
							timer.setInitialDelay(1000);
							timer.start();
						}
					});
			clickFourPVP.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent l)
						{
							welcomeScreen.setVisible(false);
							mainWindow.remove(welcomeScreen);
							mainWindow.addKeyListener(fourPVP);
							mainWindow.add(fourPVP);
							welcomeScreen.setVisible(true);
							mainWindow.requestFocus();
							
							Timer timer = new Timer(30, new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									fourPVP.run();
									fourPVP.repaint();
								}
							});
							timer.setInitialDelay(1000);
							timer.start();
						}
					});
			
			mainWindow.add(welcomeScreen);
//	
			welcomeScreen.add(clickCPU);
//			welcomeScreen.add(clickEasy);
//			welcomeScreen.add(clickMedium);
//			welcomeScreen.add(clickHard);
//			welcomeScreen.add(clickRandom);
			welcomeScreen.add(clickPVP);
			welcomeScreen.add(clickFourPVP);
			welcomeScreen.setVisible(true);
		}
	
	
	public static void main(String[] args)
	{
		new PongTest();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
		       
			
		
	   
		
		
	
	

