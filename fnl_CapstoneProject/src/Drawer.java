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
	
	private static int p1Score, cpuScore;
	private int WINDOW_WIDTH, WINDOW_HEIGHT;
	private boolean upKeyPressed, downKeyPressed;
	private int paddleLength, x, y, paddleSpeed, paddleWidth, paddleCenterY, margin, scoreBoardHeight; 
	Paddle cpu;
	Paddle p1;
	Ball pongBall;
	
	public Drawer(int WINDOW_WIDTH, int WINDOW_HEIGHT)
	{
		this.WINDOW_WIDTH = WINDOW_WIDTH;
		this.WINDOW_HEIGHT = WINDOW_HEIGHT;
		p1Score = 0;
		cpuScore = 0;
		upKeyPressed = false;
		downKeyPressed = false;
		paddleLength = (WINDOW_HEIGHT)/8;
		margin = 20;
		scoreBoardHeight = WINDOW_HEIGHT/16;
		x = margin;
		y = (WINDOW_HEIGHT)/2-paddleLength/2;
		paddleSpeed = 5;
		paddleWidth = 11;
		paddleCenterY = y-(paddleLength/2);
		cpu = new Paddle(x, y, paddleSpeed, paddleLength, paddleWidth, margin, scoreBoardHeight, WINDOW_HEIGHT);
		p1 = new Paddle(WINDOW_WIDTH-paddleWidth-margin+1, y, paddleSpeed, paddleLength, paddleWidth, margin, scoreBoardHeight, WINDOW_HEIGHT);
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
			pongBall.changeDirX();
		}
		
//		if(p1.collides(pongBall)) {
//			pongBall.changeDirX();
//		}
		
		pongBall.bounce(margin+scoreBoardHeight, WINDOW_HEIGHT+scoreBoardHeight);
		
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
		
		String p1Scores = p1Score + "";
		String cpuScores = cpuScore + "";
		
		g.drawRect(margin, margin+scoreBoardHeight, WINDOW_WIDTH-2*margin, WINDOW_HEIGHT-2*margin);
		g.drawRect(margin, 0, WINDOW_WIDTH-margin, scoreBoardHeight); //scoreboard
		g.drawRect(margin, 1, (WINDOW_WIDTH-margin)/3, scoreBoardHeight - 2);
		g.drawString(p1Scores, margin + 700, scoreBoardHeight/2);
		g.drawString(cpuScores, margin + 50, scoreBoardHeight/2);

		g.drawRect(margin + (2*WINDOW_WIDTH) / 3, 1, (WINDOW_WIDTH - margin)/3, scoreBoardHeight - 2);
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
		int cpuScore1 = Drawer.cpuScore;
		
		return cpuScore1;
	}
	
	public int getP1Score()
	{
		int p1Score1 = Drawer.p1Score;
		
		return p1Score1;
	}

	


}
