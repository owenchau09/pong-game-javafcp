import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;

/*
 * Author: Hayden Floyd
 * Date: 5/27/2024
 * Revision: Production Release
 * Notes: Sets up window and executes Drawer (Contains main method)
*/

@SuppressWarnings("serial")
public class PongTest extends JPanel implements ActionListener, KeyListener
{	
	private int WINDOW_WIDTH = 800, WINDOW_HEIGHT = 400;
	private JPanel welcomeScreen;
	private JFrame mainWindow;
	private JButton clickCPU, clickEasy, clickMedium, clickHard, clickRandom, clickPVP, clickFourPVP;
	private JLabel welcomeLabel;
	private Drawer easy, medium, hard, random, PVP, fourPVP;
	private Color color;
	@SuppressWarnings("unused")
	private boolean escPressed = false, isRunning = true, easyPressed = false, mediumPressed = false, hardPressed = false, randomPressed = false, pvpPressed = false, fourPVPPressed = false;
	private Timer timerEasy, timerMedium, timerHard, timerRandom, timerPVP, timerFourPVP;
	
	public PongTest() {
		mainWindow = new JFrame("Pong Game Remix");
		mainWindow.setBounds(150, 50, WINDOW_WIDTH+15, WINDOW_HEIGHT+82);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setResizable(false);
		color = new Color(51,102,204);
		welcomeScreen = new JPanel();
		welcomeScreen.setBackground(color);
		welcomeScreen.setBounds(0, 0, WINDOW_WIDTH+15, WINDOW_HEIGHT+82);
		welcomeScreen.setLayout(null);
		
		
		welcomeLabel = new JLabel("Welcome To Pong!");
		welcomeLabel.setSize(WINDOW_WIDTH, 120);
		welcomeLabel.setFont(new Font ("Serif", Font.BOLD, 80));
		welcomeLabel.setLocation(80, 0);
		
		clickCPU = new JButton("Press to play against a cpu!");
		clickEasy = new JButton("Easy");  
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
		
		clickCPU.setSize(250, 70);
		clickCPU.setLocation((WINDOW_WIDTH+15)/2-125, 130);
		clickCPU.setBackground(Color.RED);
		clickPVP.setSize(250, 70);
		clickPVP.setLocation((WINDOW_WIDTH+15)/2-125, 230);
		clickPVP.setBackground(Color.ORANGE);
		clickFourPVP.setSize(250, 70);
		clickFourPVP.setLocation((WINDOW_WIDTH+15)/2-125, 330);
		clickFourPVP.setBackground(Color.GREEN);
		
		timerEasy = new Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        easy.run();
		        easy.repaint();
			}
		});
		
		timerMedium = new Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        medium.run();
		        medium.repaint();
			}
		});
		
		timerHard = new Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        hard.run();
		        hard.repaint();
			}
		});
		
		timerRandom = new Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        random.run();
		        random.repaint();
			}
		});
		
		timerPVP = new Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        PVP.run();
		        PVP.repaint();
			}
		});

		timerFourPVP = new Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        fourPVP.run();
		        fourPVP.repaint();
			}
		});
		
		mainWindow.addKeyListener(this);
		welcomeScreen.add(welcomeLabel);
		
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
							mainWindow.requestFocus(); 
							easyPressed = true;
							mainWindow.remove(clickMedium);
							mainWindow.remove(clickEasy);
							mainWindow.remove(clickHard);
							mainWindow.remove(clickRandom);
							welcomeScreen.setVisible(false);
							mainWindow.repaint();
							mainWindow.addKeyListener(easy);
							mainWindow.add(easy);
								
							timerEasy.restart();
							timerEasy.setInitialDelay(1000);
							if (isRunning) {
								timerEasy.start();
							}
							else {
								timerEasy.stop();
								timerEasy.restart();
								timerEasy.start();
							}					
							mainWindow.setVisible(true);
						}});
						
						clickMedium.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent l) { 
							mainWindow.requestFocus(); 
							mediumPressed = true;
							mainWindow.remove(clickMedium);
							mainWindow.remove(clickEasy);
							mainWindow.remove(clickHard);
							mainWindow.remove(clickRandom);
							welcomeScreen.setVisible(false);
							mainWindow.repaint();
							mainWindow.addKeyListener(medium);
							mainWindow.add(medium);
								
							timerMedium.restart();
							timerMedium.setInitialDelay(1000);
							if (isRunning) {
								timerMedium.start();
							}
							else {
								timerMedium.stop();
								timerMedium.restart();
								timerMedium.start();
							}							
							mainWindow.setVisible(true);
						}});
						
						clickHard.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent l) { 
							mainWindow.requestFocus(); 
							hardPressed = true;
							mainWindow.remove(clickMedium);
							mainWindow.remove(clickEasy);
							mainWindow.remove(clickHard);
							mainWindow.remove(clickRandom);
							welcomeScreen.setVisible(false);
							mainWindow.repaint();
							mainWindow.addKeyListener(hard);
							mainWindow.add(hard);
								
							timerHard.restart();
							timerHard.setInitialDelay(1000);
							if (isRunning) {
								timerHard.start();
							}
							else {
								timerHard.stop();
								timerHard.restart();
								timerHard.start();
							}						
							mainWindow.setVisible(true);
						}});
						
						clickRandom.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent l) { 
							mainWindow.requestFocus();
							randomPressed = true;
							mainWindow.remove(clickMedium);
							mainWindow.remove(clickEasy);
							mainWindow.remove(clickHard);
							welcomeScreen.setVisible(false);
							mainWindow.repaint();
							mainWindow.addKeyListener(random);
							mainWindow.add(random);
								
							timerRandom.restart();
							timerRandom.setInitialDelay(1000);
							if (isRunning) {
								timerRandom.start();
							}
							else {
								timerRandom.stop();
								timerRandom.restart();
								timerRandom.start();
							}						
							mainWindow.setVisible(true);
						}});
						mainWindow.getContentPane().add(BorderLayout.SOUTH, clickRandom);
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
						pvpPressed = true;
						
						timerPVP.restart();
						timerPVP.setInitialDelay(1000);
						if (isRunning) {
							timerPVP.start();
						}
						else {
							timerPVP.stop();
							timerPVP.restart();
							timerPVP.start();
						}
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
						fourPVPPressed = true;
						
						timerFourPVP.restart();
						timerFourPVP.setInitialDelay(1000);
						if (isRunning) {
							timerFourPVP.start();
						}
						else {
							timerFourPVP.stop();
							timerFourPVP.restart();
							timerFourPVP.start();
						}
					}
				});
		welcomeScreen.add(clickCPU);
		welcomeScreen.add(clickPVP);
		welcomeScreen.add(clickFourPVP);
		mainWindow.add(welcomeScreen);
		mainWindow.setVisible(true);
	}
	
	// This method determines when the escape key is pressed and changes the boolean value to true if so, bringing the user to the menu screen
	public void keyPressed(KeyEvent j) {
		if (j.getKeyCode() == KeyEvent.VK_ESCAPE) {
			escPressed = true;
			if(easyPressed) {
				easyPressed = false;
				easy.resetLevel(1);
				timerEasy.stop();
				mainWindow.remove(easy);
				easy.repaint();
			}
			
			else if(mediumPressed) {
				mediumPressed = false;
				medium.resetLevel(2);
				timerMedium.stop();
				mainWindow.remove(medium);
				medium.repaint();
			}
			
			else if(hardPressed) {
				hardPressed = false;
				hard.resetLevel(3);
				timerHard.stop();
				mainWindow.remove(hard);
				hard.repaint();
			}
			
			else if(randomPressed) {
				randomPressed = false;
				random.resetLevel(4);
				timerRandom.stop();
				mainWindow.remove(random);
				random.repaint();
			}
			
			else if(pvpPressed) {
				pvpPressed = false;
				PVP.resetLevel(5);
				timerPVP.stop();
				mainWindow.remove(PVP);
				PVP.repaint();
			}
			
			else if(fourPVPPressed) {
				fourPVPPressed = false;
				fourPVP.resetLevel(6);
				timerFourPVP.stop();
				mainWindow.remove(fourPVP);
				fourPVP.repaint();
			}
			
			mainWindow.repaint();
			mainWindow.add(welcomeScreen);
			welcomeScreen.setVisible(true);
		}
	}
	
	// This method determines when the escape key is released, changing the boolean value to false 
	public void keyReleased(KeyEvent j) {
		if (j.getKeyCode() == KeyEvent.VK_ESCAPE) {
			escPressed = false;
		}
	}
	
	// This is the main method that instantiates the constructor
	public static void main(String[] args)
	{
		new PongTest();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent j) {
		
	}
	
}
		       
			
		
	   
		
		
	
	
