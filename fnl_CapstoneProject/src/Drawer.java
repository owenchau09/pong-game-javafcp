import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.*;

public class Drawer extends JPanel implements KeyListener
{
	
	private boolean startGame;
	private static int p1Score, cpuScore;
	private int WINDOW_WIDTH, WINDOW_HEIGHT;
	private boolean upKeyPressed, downKeyPressed;
	private int paddleLength, x, y, paddleSpeed, paddleWidth, paddleCenterY, margin; 
	Paddle cpu;
	Paddle p1;
	Ball pongBall;
	
	public Drawer(int WINDOW_WIDTH, int WINDOW_HEIGHT)
	{
		this.WINDOW_WIDTH = WINDOW_WIDTH;
		this.WINDOW_HEIGHT = WINDOW_HEIGHT;
		startGame = true;
		p1Score = 0;
		cpuScore = 0;
		upKeyPressed = false;
		downKeyPressed = false;
		paddleLength = (WINDOW_HEIGHT)/8;
		margin = 20;
		x = margin;
		y = (WINDOW_HEIGHT)/2-paddleLength/2;
		paddleSpeed = 5;
		paddleWidth = 11;
		paddleCenterY = y-(paddleLength/2);
		cpu = new Paddle(x, y, paddleSpeed, paddleLength, paddleWidth);
		p1 = new Paddle(WINDOW_WIDTH-paddleWidth-margin+1, y, paddleSpeed, paddleLength, paddleWidth);
		pongBall = new Ball(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, 1, 1, 5, 10, Color.BLUE, WINDOW_WIDTH, margin);
		
	}
	
	public Drawer()
	{
		
	}
	
	
	public void reset() {
		pongBall.setX(WINDOW_WIDTH/2);
		pongBall.setY(WINDOW_HEIGHT/2);
	}
	
	
	public void estimatedPosition() {
		
	}
	public void cpuMove() {
//		paddleCenterY = cpu.getYPos()-(paddleLength/2);
//		if(paddleCenterY > pongBall.getY()) {
//			cpu.down();
//		}
//		else if(paddleCenterY < pongBall.getY()) {
//			cpu.up();
//		}
	}

		
	public void keyPressed(KeyEvent e) {
	  	if (e.getKeyCode() == KeyEvent.VK_UP) {
	  		upKeyPressed = true;
	  	}
	  	else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	  		downKeyPressed = true;
	  	}
	  }
	
	public void run() {
		pongBall.moveBall();
		if(cpu.collides(pongBall) || p1.collides(pongBall)) {
			System.out.println("ADAJBFAJGFAKF");
			pongBall.changeDirX();
		}
		
//		if(p1.collides(pongBall)) {
//			pongBall.changeDirX();
//		}
		
		pongBall.bounce(0, WINDOW_HEIGHT);
		
		//player move
		if(upKeyPressed) {
			p1.up();
		}
		if(downKeyPressed) {
			p1.down();
		}
		
		//cpu move
		paddleCenterY = cpu.getYPos()+(paddleLength/2);
		if(paddleCenterY < pongBall.getY()) {
			cpu.down();
		}
		if(paddleCenterY > pongBall.getY()) {
			cpu.up();
		}
		
		//score check
		if(pongBall.checkScoreP1(pongBall)) {
			p1Score++;
			reset();
			System.out.println("player score:   " + p1Score); //make sure to comment out when creating the scoreboard
		}
		
		if(pongBall.checkScoreCPU(pongBall)) {
			cpuScore++;
			reset();
			System.out.println("cpu score:   " + cpuScore); //make sure to comment out when creating the scoreboard
		}
	
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(margin, margin, WINDOW_WIDTH-2*margin, WINDOW_HEIGHT-2*margin);
		pongBall.draw(g);
		cpu.draw(g);
		p1.draw(g);
	}

	public void keyTyped(KeyEvent e) {
		
		
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
	  		upKeyPressed = false;
	  	}
	  	else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	  		downKeyPressed = false;
	  	}
		
	}
	
	public int getCpuScore()
	{
		int cpuScore1 = this.cpuScore;
		
		return cpuScore1;
	}
	
	public int getP1Score()
	{
		int p1Score1 = this.p1Score;
		
		return p1Score1;
	}

	


}
