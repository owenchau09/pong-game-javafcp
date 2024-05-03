import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;


public class PongTest 
{
	boolean startGame = true;
	int score1 = 0, score2 = 0;
	static final int WIDTH = 1280, HEIGHT = 1280;
	Ball pongBall;
	Paddle p1, cpu;
	
	public void reset() {
		
	}
	
	public boolean collides() {
		return false;
	}
	public void paintComponent() {
		
	}
	public void draw() {
		
	}
	public void keyPressed() {
		
	}
	public void estimatedPosition() {
		
	}
	public void cpuMove() {
		
	}
 	public static void main(String[] args) {
		JFrame window = new JFrame("Pong Game Remix");
		window.setBounds(300, 300, 400, 150); // experimenting by making the window 200 wider
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Drawer panel = new Drawer();
		window.add(panel);

		window.setVisible(true);
	}
	
}
