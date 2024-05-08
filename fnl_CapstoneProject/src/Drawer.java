
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
	
	boolean startGame = true;
	int score1 = 0, score2 = 0;
	public void reset() {
		
	}
	
	public void estimatedPosition() {
		
	}
	public void cpuMove() {
		
	}
	int WIDTH = getWidth(), HEIGHT = getHeight();
	private boolean upKeyPressed = false, downKeyPressed = false;
	int paddleLength = HEIGHT/10, x = 0, y = HEIGHT/2-paddleLength, paddleSpeed = 5, paddleWidth = 10; 
	Paddle cpu = new Paddle(x, y, paddleSpeed, paddleLength, paddleWidth);
	Paddle p1 = new Paddle(WIDTH-26, y, paddleSpeed, paddleLength, paddleWidth);
//	Paddle p1 = new Paddle(1250, y, paddleSpeed, paddleLength, paddleWidth);
	
	Ball pongBall = new Ball(WIDTH/2, HEIGHT/2, 1, 1, 5, 10, Color.BLUE);
	
	
	public Drawer()
	{
		
		
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
		pongBall.bounce(0, HEIGHT);
		if(p1.collides(pongBall)) {
			pongBall.changeDirX();
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
		
		g.setColor(Color.RED);
	    g.fillRect(400, 25, 400,300);
	    

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
