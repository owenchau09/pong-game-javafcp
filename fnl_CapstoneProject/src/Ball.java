import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	private int ballSpeed, ballRadius, x, y, dirX=1, dirY=1, margin;
	private Color ballColor;
	private int WINDOW_WIDTH, WINDOW_HEIGHT, paddleWidth, scoreBoardHeight;
	
	
	public Ball(int x, int y, int dirX, int dirY, int ballSpeed, int ballRadius, Color ballColor, int WINDOW_WIDTH, int margin) {
		this.ballSpeed = ballSpeed;
		this.ballColor = ballColor;
		this.ballRadius = ballRadius;
		this.x = x;
		this.y = y;
		this.dirX = dirX;
		this.dirY = dirY;
		this.WINDOW_WIDTH = WINDOW_WIDTH;
		this.margin = margin;
	}
	
	public Ball (int x, int y, int dirX, int dirY, int ballSpeed, int ballRadius, Color ballColor, int WINDOW_WIDTH, int margin, int WINDOW_HEIGHT, int scoreBoardHeight, int paddleWidth) {
		this.ballSpeed = ballSpeed;
		this.ballColor = ballColor;
		this.ballRadius = ballRadius;
		this.x = x;
		this.y = y;
		this.dirX = dirX;
		this.dirY = dirY;
		this.WINDOW_WIDTH = WINDOW_WIDTH;
		this.WINDOW_HEIGHT = WINDOW_HEIGHT;
		this.paddleWidth = paddleWidth;
		this.scoreBoardHeight = scoreBoardHeight;
		this.margin = margin;
	}
	
	// This method gets the current speed of the ball
	public int getBallSpeed() {
		return ballSpeed;
	}
	
	// This method gets the x position of the ball
	public int getX() {
		return x;
	}
	
	// This method gets the y position of the ball
	public int getY() {
		return y;
	}
	
	// This method returns the radius of the ball
	public int getBallRadius() {
		return ballRadius;
	}
	
	// This method gets the color of the ball
	public Color getBallColor() {
		return ballColor;
	}
	
	// This method sets the x value of the ball
	public void setX(int x) {
		this.x = x;
	}
	
	// This method sets the y value of the ball
	public void setY(int y) {
		this.y = y;
	}
	
	// In the case of a collision between a ball and the paddle this method will be run
	public void changeDirX() {
		dirX *= -1;
	}
	
	public void changeDirY() {
		dirY *= -1;
	}
	
	// This method sets the speed of the ball
	public void setBallSpeed(int ballSpeed) {
		this.ballSpeed = ballSpeed;
	}
	
	// This method sets the radius of the ball
	public void setBallRadius(int ballRadius) {
		this.ballRadius = ballRadius;
	}
	
	// This method sets the color of the ball
	public void setBallColor(Color ballColor) {
		this.ballColor = ballColor;
	}
	
	// This method determines how the ball bounces
	public void bounce(int topSide, int bottomSide) {
		if(y >= (bottomSide-(ballRadius)) || y < (topSide+(ballRadius))) {
			dirY*=-1;
		}
	}
	
	public void move() {
		x += (ballSpeed*dirX);
		y += (ballSpeed*dirY);
	}
	
	public boolean checkScoreCPU(Ball pongBall) {
		if(pongBall.getX() >= WINDOW_WIDTH-margin) {
			return true;
		}
		return false;
	}
	
	public boolean checkScoreP1(Ball pongBall) {
		if(pongBall.getX() < margin) {
			return true;
		}
		return false;
	}
	
	public boolean checkScoreP2(Ball pongBall) {
		if(pongBall.getX() >= WINDOW_WIDTH-margin) {
			return true;
		}
		return false;
	}
	
	public boolean checkScoreP3(Ball pongBall) {
		if(pongBall.getY() < margin + scoreBoardHeight) {
			return true;
		}
		return false;
	}
	public boolean checkScoreP4(Ball pongBall) {
		if(pongBall.getY() >= WINDOW_HEIGHT + margin - paddleWidth - 1) {
			return true;
		}
		return false;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(ballColor); 
		
		g.fillOval(x-ballRadius, y-ballRadius, ballRadius*2, ballRadius*2); 
	}
	
}
