import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

//main class
public class PongTest extends JPanel implements ActionListener
{
//	private static final String JButton = null;
	private static JTextField display;
	JFrame mainwindow = new JFrame();
	JPanel cpuWindow = new JPanel();
	private JTextField search;
	private JTextArea output;

	JPanel bottomPanel = new JPanel(new BorderLayout());
	JPanel topPanel = new JPanel(new BorderLayout());
 	public static void main(String[] args) 
 	{
 		JFrame mainWindow = new JFrame("Pong Game Remix");
 		mainWindow.setResizable(false);
		mainWindow.setBounds(150, 50, 1280, 750); 
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PongTest panel = new PongTest();
		
		mainWindow.add(panel);
		mainWindow.setResizable(true);
		mainWindow.setVisible(true);
		
		
		
//		JFrame mainwindow = new JFrame("Pong Game Remix");
//		mainwindow.setResizable(false);
//		mainwindow.setBounds(150, 50, 1280, 750); 
//		mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Drawer panel = new Drawer();
//		mainwindow.addKeyListener(panel);
//		mainwindow.add(panel);
//		JButton newButton = new JButton("Player vs Cpu");
//		newButton.addActionListener();
//		mainwindow.add(newButton);
//		
//		mainwindow.setVisible(true);
//		
//		//timer so that every 30 ms action occurs
//		Timer timer = new Timer(30, new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//		        panel.run();
//		        panel.repaint();
//			}
//		});
//		timer.start();
//		
//		JFrame cpuWindow = new JFrame("Player vs Cpu");
//		cpuWindow.setResizable(false);
//		cpuWindow.setBounds(150, 50, 1280, 750); 
//		cpuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Drawer secondPanel = new Drawer();
//		cpuWindow.addKeyListener(panel);
//		cpuWindow.add(panel);
//		cpuWindow.setVisible(false);
//		
//		Timer timer1 = new Timer(30, new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JButton b = (JButton)e.getSource();
//				mainwindow.setVisible(false);
//				cpuWindow.setVisible(true);
//			}
//		});
 		
 		new PongTest();
 	
 	}
 	public PongTest()
 	{
 		
 		super(new BorderLayout());
		output = new JTextArea();
		JScrollPane scroll = new JScrollPane(output);
		add(scroll, BorderLayout.CENTER);
		search = new JTextField();
		search.addActionListener(this);
		
		JButton goButton = new JButton("Player vs Cpu");
		goButton.addActionListener(this);
		
//		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.add(goButton, BorderLayout.CENTER);
		bottomPanel.add(goButton, BorderLayout.EAST);
		add(bottomPanel, BorderLayout.SOUTH);
		
//		JPanel topPanel = new JPanel(new BorderLayout());
		
		JLabel label = new JLabel("Welcome to player vs CPU:");
		topPanel.add(label, BorderLayout.CENTER);
		add(topPanel, BorderLayout.NORTH);
		Drawer panel = new Drawer();
		topPanel.addKeyListener(panel);
		topPanel.add(panel, BorderLayout.SOUTH);


//		
//		mainwindow.setVisible(true);
//		
		//timer so that every 30 ms action occurs
		Timer timer = new Timer(30, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        panel.run();
		        panel.repaint();
			}
		});
		timer.start();
		
		topPanel.setVisible(false);
		
		
		
// 		JFrame mainwindow = new JFrame("Pong Game Remix");
//		mainwindow.setResizable(false);
//		mainwindow.setBounds(150, 50, 1280, 750); 
//		mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Drawer panel = new Drawer();
//		mainwindow.addKeyListener(panel);
//		mainwindow.add(panel);
//		
//		JButton newButton = new JButton("Player vs Cpu");
//		newButton.setBounds(getBounds());
//		newButton.addActionListener(this);
//		mainwindow.add(newButton);
//		
//		mainwindow.setVisible(true);
//		
//		JPanel cpuWindow = new JPanel();
//		
//		cpuWindow.setBounds(150, 50, 1280, 750); 
//		//cpuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Drawer secondPanel = new Drawer();
//		cpuWindow.addKeyListener(secondPanel);
//		mainwindow.add(cpuWindow);
//		cpuWindow.setVisible(false);
//		
//		
//		//timer so that every 30 ms action occurs
//		Timer timer = new Timer(30, new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//		        panel.run();
//		        panel.repaint();
//		        
//			}
//		});
//		
//		
//		timer.start();
//		
//		
//		
	}
 	

	@Override
	public void actionPerformed(ActionEvent k) {
		// TODO Auto-generated method stub
		
		bottomPanel.setVisible(false);
		topPanel.setVisible(true);
		
	}
	
}
		        
			

		
	    

		
		
	
	

