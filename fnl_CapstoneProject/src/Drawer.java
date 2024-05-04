
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Drawer extends JPanel //implements ActionListener
{
	
	boolean startGame = true;
	int score1 = 0, score2 = 0;
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
	static final int WIDTH = 1280, HEIGHT = 750;
	int paddleLength = HEIGHT/10, x = 0, y = HEIGHT/2-paddleLength, paddleSpeed = 3, paddleWidth = 10; 
	Paddle cpu = new Paddle(x, y, paddleSpeed, paddleLength, paddleWidth);
	Paddle p1 = new Paddle(WIDTH-26, y, paddleSpeed, paddleLength, paddleWidth);
//	Paddle p1 = new Paddle(1250, y, paddleSpeed, paddleLength, paddleWidth);
	
	Ball pongBall = new Ball(WIDTH/2, HEIGHT/2, 1, 1, 3, 10, Color.BLUE);
	
	
	public Drawer()
	{
		
		
	}
	
	public void run() {
		pongBall.moveBall();
		pongBall.bounce(0, HEIGHT);
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		pongBall.draw(g);
		cpu.draw(g);
		p1.draw(g);
	}



}
