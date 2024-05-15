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
			clickCPU = new JButton("Press to play against a cpu!");
			clickEasy = new JButton("Easy");  //4 cpu modes
			clickMedium = new JButton("Medium");
			clickHard = new JButton("Hard");
			clickRandom = new JButton("Random Mode");
			clickPVP = new JButton("Press to play against your friend!");
			clickFourPVP = new JButton("Press to play a four paddle game!");
			mainWindow.setBounds(150, 50, WINDOW_WIDTH+15, WINDOW_HEIGHT+82);
			mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			easy = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, 1);
			medium = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, 2);
			hard = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, 3);
			random = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, 4);
			PVP = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, 5);
			fourPVP = new Drawer(WINDOW_WIDTH, WINDOW_HEIGHT, 6);
			mainWindow.setVisible(true);
			welcomeScreen = new JPanel();
			welcomeScreen.setBackground(Color.GREEN);
			welcomeScreen.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
			JLabel label = new JLabel("Welcome To Pong");
			
			clickCPU.setPreferredSize(new Dimension(250, 100));
			clickCPU.setBackground(Color.RED);
			clickPVP.setPreferredSize(new Dimension(300, 100));
			clickPVP.setBackground(Color.PINK);
//			clickEasy.setPreferredSize(new Dimension(100, 100));
//			clickEasy.setBackground(Color.CYAN);
			
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
							
							clickRandom.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent l) { 
								welcomeScreen.setVisible(false);
								mainWindow.remove(welcomeScreen);
								Timer timer = new Timer(30, new ActionListener() {
									public void actionPerformed(ActionEvent e) {
								        random.run();
								        random.repaint();
									}
								});
								timer.setInitialDelay(1000);
								timer.start();
								mainWindow.addKeyListener(random);
								mainWindow.add(random);
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
	
			welcomeScreen.add(clickCPU);
			welcomeScreen.add(clickEasy);
			welcomeScreen.add(clickMedium);
			welcomeScreen.add(clickHard);
			welcomeScreen.add(clickRandom);
			welcomeScreen.add(clickPVP);
			welcomeScreen.add(fourPVP);
		}
	
	
	public static void main(String[] args)
	{
		new PongTest();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
		       
			
		
	   
		
		
	
	

