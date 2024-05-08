package testing_workspace;

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
	
	boolean startGame;
	int p1Score, cpuScore;
	private int WINDOW_WIDTH, WINDOW_HEIGHT;
	private boolean upKeyPressed, downKeyPressed;
	int paddleLength, x, y, paddleSpeed, paddleWidth; 
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
		paddleLength = (WINDOW_HEIGHT)/10;
		x = 0;
		y = (WINDOW_HEIGHT)/2-paddleLength;
		paddleSpeed = 5;
		paddleWidth = 10; 
		cpu = new Paddle(x+1, y, paddleSpeed, paddleLength, paddleWidth);
		p1 = new Paddle(WINDOW_WIDTH-24, y, paddleSpeed, paddleLength, paddleWidth);
		pongBall = new Ball(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, 1, 1, 5, 10, Color.BLUE, WINDOW_WIDTH);
		
	}
	
	
	public void reset() {
		pongBall.setX(WINDOW_WIDTH/2);
		pongBall.setY(WINDOW_HEIGHT/2);
	}
	
	
	public void estimatedPosition() {
		
	}
	public void cpuMove() {
		
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
		pongBall.bounce(0, WINDOW_HEIGHT);
		if(p1.collides(pongBall)) {
			pongBall.changeDirX();
		}
		
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
		
		if(upKeyPressed) {
			p1.up();
		}
		else if(downKeyPressed) {
			p1.down();
		}
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
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



}
