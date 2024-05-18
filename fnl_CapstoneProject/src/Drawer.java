import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Random; 
import java.awt.event.*;

@SuppressWarnings("serial")
public class Drawer extends JPanel implements KeyListener
{
	
	private static int p1Score, p2Score, cpuScore;
	private int WINDOW_WIDTH, WINDOW_HEIGHT;
	private boolean upKeyPressed, downKeyPressed, wKeyPressed, sKeyPressed, aKeyPressed, dKeyPressed, leftKeyPressed, rightKeyPressed;
	private int paddleLength, x, y, paddleSpeed, paddleWidth, paddleCenterY, margin, scoreBoardHeight, level, r, g, b, ballSpeed, rand, scoreBoardWidth; 
	private Paddle cpu, p1, p2;
	private SidePaddle p3, p4;
	private Ball pongBall;
	private Random random; 
	private boolean isMultiplayer = false, isQuadPlayer = false;
	
	public Drawer(int WINDOW_WIDTH, int WINDOW_HEIGHT, int level)
	{
		this.WINDOW_WIDTH = WINDOW_WIDTH;
		this.WINDOW_HEIGHT = WINDOW_HEIGHT;
		this.level = level;
		p1Score = 0;
		cpuScore = 0;
		upKeyPressed = false;
		downKeyPressed = false;
		random = new Random();
		ballSpeed = 10;
		paddleLength = (WINDOW_HEIGHT)/7;
		margin = 20;
		scoreBoardHeight = WINDOW_HEIGHT/16;
		x = margin;
		y = (WINDOW_HEIGHT)/2-paddleLength/2;
		paddleSpeed = 6;
		paddleWidth = 11;
		paddleCenterY = y-(paddleLength/2);
		if(level == 1) {
			cpu = new Paddle(x, y, paddleSpeed-1, (WINDOW_HEIGHT)/6, paddleWidth, margin, scoreBoardHeight, WINDOW_HEIGHT, Color.RED);
			p1 = new Paddle(WINDOW_WIDTH-paddleWidth-margin+1, y, paddleSpeed, (WINDOW_HEIGHT)/6, paddleWidth, margin, scoreBoardHeight, WINDOW_HEIGHT, Color.BLUE);
			pongBall = new Ball((15+WINDOW_WIDTH)/2-5, WINDOW_HEIGHT/2, 1, 1, 6, 10, Color.GREEN, WINDOW_WIDTH, margin, WINDOW_HEIGHT, scoreBoardHeight, paddleWidth);
		}
		else if(level == 2) {
			cpu = new Paddle(x, y, paddleSpeed, paddleLength, paddleWidth, margin, scoreBoardHeight, WINDOW_HEIGHT, Color.RED);
			p1 = new Paddle(WINDOW_WIDTH-paddleWidth-margin+1, y, paddleSpeed, paddleLength, paddleWidth, margin, scoreBoardHeight, WINDOW_HEIGHT, Color.BLUE);
			pongBall = new Ball((15+WINDOW_WIDTH)/2-5, WINDOW_HEIGHT/2, 1, 1, 7, 10, Color.ORANGE, WINDOW_WIDTH, margin, WINDOW_HEIGHT, scoreBoardHeight, paddleWidth);	
		}
		else if(level == 3) {
			cpu = new Paddle(x, y, paddleSpeed+4, paddleLength, paddleWidth, margin, scoreBoardHeight, WINDOW_HEIGHT, Color.RED);
			p1 = new Paddle(WINDOW_WIDTH-paddleWidth-margin+1, y, paddleSpeed, paddleLength, paddleWidth, margin, scoreBoardHeight, WINDOW_HEIGHT, Color.BLUE);
			pongBall = new Ball((15+WINDOW_WIDTH)/2-5, WINDOW_HEIGHT/2, 1, 1, 10, 10, Color.RED, WINDOW_WIDTH, margin, WINDOW_HEIGHT, scoreBoardHeight, paddleWidth);
		}
		else if(level == 4) {
			cpu = new Paddle(x, y, paddleSpeed+4, paddleLength, paddleWidth, margin, scoreBoardHeight, WINDOW_HEIGHT, Color.RED);
			p1 = new Paddle(WINDOW_WIDTH-paddleWidth-margin+1, y, paddleSpeed+4, paddleLength, paddleWidth, margin, scoreBoardHeight, WINDOW_HEIGHT, Color.BLUE);
			pongBall = new Ball((15+WINDOW_WIDTH)/2-5, WINDOW_HEIGHT/2, 1, 1, 10, 10, Color.BLACK, WINDOW_WIDTH, margin, WINDOW_HEIGHT, scoreBoardHeight, paddleWidth);
		}
		
		else if(level == 5) {
			p1 = new Paddle(WINDOW_WIDTH-paddleWidth-margin+1, y, paddleSpeed, paddleLength, paddleWidth, margin, scoreBoardHeight, WINDOW_HEIGHT, Color.BLUE);
			p2 = new Paddle(x, y, paddleSpeed, paddleLength, paddleWidth, margin, scoreBoardHeight, WINDOW_HEIGHT, Color.RED);

			pongBall = new Ball((15+WINDOW_WIDTH)/2-5, WINDOW_HEIGHT/2, 1, 1, 5, 10, Color.BLACK, WINDOW_WIDTH, margin, WINDOW_HEIGHT, scoreBoardHeight, paddleWidth);
			isMultiplayer = true;
		}
		
		else if (level == 6)
		{
			p1 = new Paddle(WINDOW_WIDTH-paddleWidth-margin+1, y, paddleSpeed, paddleLength, paddleWidth, margin, scoreBoardHeight, WINDOW_HEIGHT, Color.BLUE);
			p2 = new Paddle(x, y, paddleSpeed, paddleLength, paddleWidth, margin, scoreBoardHeight, WINDOW_HEIGHT, Color.RED);
			p3 = new SidePaddle((15+WINDOW_WIDTH)/2-paddleLength/2, margin+scoreBoardHeight, paddleSpeed, paddleLength, paddleWidth, margin, scoreBoardWidth, WINDOW_WIDTH, scoreBoardHeight, WINDOW_HEIGHT, Color.RED);
			p4 = new SidePaddle((15+WINDOW_WIDTH)/2-paddleLength/2, WINDOW_HEIGHT + scoreBoardHeight - margin - paddleWidth + 1, paddleSpeed, paddleLength, paddleWidth, margin, scoreBoardWidth, WINDOW_WIDTH, scoreBoardHeight, WINDOW_HEIGHT, Color.BLUE);
			pongBall = new Ball((15+WINDOW_WIDTH)/2-5, WINDOW_HEIGHT/2, 1, 1, 5, 10, Color.BLACK, WINDOW_WIDTH, margin, WINDOW_HEIGHT, scoreBoardHeight, paddleWidth);
			isQuadPlayer = true;
		}
	}
	
	
	public void reset() {
		pongBall.setX(WINDOW_WIDTH/2);
		pongBall.setY(WINDOW_HEIGHT/2);
	}

		
	public void keyPressed(KeyEvent e) {
	  	if (e.getKeyCode() == KeyEvent.VK_UP) {
	  		upKeyPressed = true;
	  	}
	  	else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	  		downKeyPressed = true;
	  	}
	  	else if (e.getKeyCode() == KeyEvent.VK_W) {
	  		wKeyPressed = true;
	  	}
	  	else if (e.getKeyCode() == KeyEvent.VK_S) {
	  		sKeyPressed = true;
	  	}
	  	else if (e.getKeyCode() == KeyEvent.VK_A) {
	  		aKeyPressed = true;
	  	}
	  	else if (e.getKeyCode() == KeyEvent.VK_D) {
	  		dKeyPressed = true;
	  	}
	  	else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	  		rightKeyPressed = true;
	  	}
	  	else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	  		leftKeyPressed = true;
	  	}
	  	
	  		
	  }
	
	public void run() {
		
		pongBall.move();
		if (isMultiplayer)
		{
			if (p1.collides(pongBall) || p2.collides(pongBall)) {
				pongBall.changeDirX();
			}
			
			pongBall.bounce(margin+scoreBoardHeight, WINDOW_HEIGHT+scoreBoardHeight-margin-1);
			
			if(upKeyPressed) {
				p1.up();
			}
			if(downKeyPressed) {
				p1.down();
			}
			if(wKeyPressed) {
				p2.up();
			}
			if(sKeyPressed) {
				p2.down();
			}
			if(pongBall.checkScoreP1(pongBall)) {
				p1Score++;
				reset();
			}
			
			if(pongBall.checkScoreP2(pongBall)) {
				p2Score++;
				reset();
			}
			
			if(pongBall.checkScoreP2(pongBall)) {
				p2Score++;
				reset();
			}
		}
		else if (level == 4) {
			if (p1.collides(pongBall) || cpu.collides(pongBall)) {
				pongBall.changeDirX();
				r = random.nextInt(256); 
				g = random.nextInt(256);	 
				b = random.nextInt(256);	 
				Color randomColor = new Color(r, g, b);
				pongBall.setBallColor(randomColor);
				rand = (int) random.nextInt(20);
				pongBall.setBallSpeed(ballSpeed + rand);
				cpu.setPaddleSpeed(rand + paddleSpeed + (int) random.nextInt(20));
				p1.setPaddleSpeed(rand + paddleSpeed + (int) random.nextInt(20));
				cpu.setPaddleLength(paddleLength + (int) random.nextInt(WINDOW_HEIGHT-6*margin));
				p1.setPaddleLength(paddleLength + (int) random.nextInt(WINDOW_HEIGHT-6*margin));
			}
			pongBall.bounce(margin+scoreBoardHeight, WINDOW_HEIGHT+scoreBoardHeight-margin-1);
			
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
			if(pongBall.checkScoreP1(pongBall)) {
				p1Score++;
				reset();
			}
			
			if(pongBall.checkScoreCPU(pongBall)) {
				cpuScore++;
				reset();
			}
			
			if(pongBall.checkScoreP2(pongBall)) {
				p2Score++;
				reset();
			}
		}
		else if (isQuadPlayer)
		{
			if (p1.collides(pongBall) || p2.collides(pongBall)) {
				pongBall.changeDirX();
			}
			 if (p3.horizontalCollides(pongBall) || p4.horizontalCollides(pongBall))
			{
				pongBall.changeDirY();
			}
			
			
			if(upKeyPressed) {
				p1.up();
			}
			if(downKeyPressed) {
				p1.down();
			}
			if(wKeyPressed) {
				p2.up();
			}
			if(sKeyPressed) {
				p2.down();
			}
			if (aKeyPressed) {
				p3.left();
			}
			if (leftKeyPressed) {
				p4.left();
			}
			if (dKeyPressed) {
				p3.right();
			}
			if (rightKeyPressed) {
				p4.right();
			}
			
			
			if(pongBall.checkScoreP1(pongBall)) {
				p2Score++;
				reset();
			}
			
			if(pongBall.checkScoreP2(pongBall)) {
				p1Score++;
				reset();
			}
			
			if(pongBall.checkScoreP3(pongBall)) {
				p1Score++;
				reset();
			}
			
			if(pongBall.checkScoreP4(pongBall)) {
				p2Score++;
				reset();
			}
		}
		else
		{
			if (p1.collides(pongBall) || cpu.collides(pongBall)) {
				pongBall.changeDirX();
			}
			pongBall.bounce(margin+scoreBoardHeight, WINDOW_HEIGHT+scoreBoardHeight-margin-1);
			
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
			if(pongBall.checkScoreP1(pongBall)) {
				p1Score++;
				reset();
			}
			
			if(pongBall.checkScoreCPU(pongBall)) {
				cpuScore++;
				reset();
			}
			
			if(pongBall.checkScoreP2(pongBall)) {
				p2Score++;
				reset();
			}
		}
		
		
	
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (isMultiplayer)
		{
			String p1Scores = p1Score + "";
			String p2Scores = p2Score+ "";
			
			g.drawRect(margin, margin+scoreBoardHeight, WINDOW_WIDTH-2*margin, WINDOW_HEIGHT-2*margin);
			g.drawRect(margin, 0, WINDOW_WIDTH-margin, scoreBoardHeight); 
			g.drawRect(margin, 1, (WINDOW_WIDTH-margin)/3, scoreBoardHeight - 2);
			g.drawString(p1Scores, margin + 700, scoreBoardHeight/2);
			g.drawString(p2Scores, margin + 50, scoreBoardHeight/2);

			g.drawRect(margin + (2*WINDOW_WIDTH) / 3, 1, (WINDOW_WIDTH - margin)/3, scoreBoardHeight - 2);
			pongBall.draw(g);
			p2.draw(g);
			p1.draw(g);
		}
		else if (isQuadPlayer)
		{
			String p1Scores = p1Score + "";
			String p2Scores = p2Score+ "";
			
			g.drawRect(margin, margin+scoreBoardHeight, WINDOW_WIDTH-2*margin, WINDOW_HEIGHT-2*margin);
			g.drawRect(margin, 0, WINDOW_WIDTH-margin, scoreBoardHeight); 
			g.drawRect(margin, 1, (WINDOW_WIDTH-margin)/3, scoreBoardHeight - 2);
			g.drawString(p1Scores, margin + 700, scoreBoardHeight/2);
			g.drawString(p2Scores, margin + 50, scoreBoardHeight/2);

			g.drawRect(margin + (2*WINDOW_WIDTH) / 3, 1, (WINDOW_WIDTH - margin)/3, scoreBoardHeight - 2);

			pongBall.draw(g);
			p2.draw(g);
			p1.draw(g);
			p3.draw(g);
			p4.draw(g);
		}
		
		else {
			String p1Scores = p1Score + "";
			String cpuScores = cpuScore + "";
			
			g.drawRect(margin, margin+scoreBoardHeight, WINDOW_WIDTH-2*margin, WINDOW_HEIGHT-2*margin);
			g.drawRect(margin, 0, WINDOW_WIDTH-margin, scoreBoardHeight); 
			g.drawRect(margin, 1, (WINDOW_WIDTH-margin)/3, scoreBoardHeight - 2);
			g.drawString(p1Scores, margin + 700, scoreBoardHeight/2);
			g.drawString(cpuScores, margin + 50, scoreBoardHeight/2);

			g.drawRect(margin + (2*WINDOW_WIDTH) / 3, 1, (WINDOW_WIDTH - margin)/3, scoreBoardHeight - 2);
			pongBall.draw(g);
			cpu.draw(g);
			p1.draw(g);
		}
		
		
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
		if (e.getKeyCode() == KeyEvent.VK_W) {
			wKeyPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			sKeyPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			aKeyPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			dKeyPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rightKeyPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			leftKeyPressed = false;
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
