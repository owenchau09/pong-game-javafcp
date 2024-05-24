import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	private int ballSpeed, ballRadius, x, y, dirX=1, dirY=1, margin, WINDOW_WIDTH, WINDOW_HEIGHT, paddleWidth, scoreBoardHeight;
	private Color ballColor;
	
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
	
	// This method returns the current speed of the ball
	public int getBallSpeed() {
		return ballSpeed;
	}
	
	// This method returns the current x position of the ball
	public int getX() {
		return x;
	}
	
	// This method returns the current y position of the ball
	public int getY() {
		return y;
	}
	
	// This method returns the radius of the ball
	public int getBallRadius() {
		return ballRadius;
	}
	
	// This method returns the current color of the ball
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
	
	// In the case of a collision between a ball and the paddle this method will run, changing the x direction of the ball
	public void changeDirX() {
		dirX *= -1;
	}
	
	// In the case of a collision between a ball and the top and bottom borders, this method will run, changing the y direction of the ball
	public void changeDirY() {
		dirY *= -1;
	}
	
	// This method will bounce the ball when it fits the specified conditions
	public void bounce(int topSide, int bottomSide) {
		if(y >= (bottomSide-(ballRadius)) || y < (topSide+(ballRadius))) {
			dirY*=-1;
		}
	}
	
	// This method changes the coordinates of the ball
	public void move() {
		x += (ballSpeed*dirX);
		y += (ballSpeed*dirY);
	}
	
	// This method determines and returns whether a point is scored or not (the ball crosses the right side)
	public boolean checkScoreCPU(Ball pongBall) {
		if(pongBall.getX() >= WINDOW_WIDTH-margin) {
			return true;
		}
		return false;
	}
	
	// This method determines and returns whether a point is scored or not (the ball crosses the left side)
	public boolean checkScoreP1(Ball pongBall) {
		if(pongBall.getX() < margin) {
			return true;
		}
		return false;
	}
	
	// This method determines and returns whether a point is scored or not (the ball crosses the right side)
	public boolean checkScoreP2(Ball pongBall) {
		if(pongBall.getX() >= WINDOW_WIDTH-margin) {
			return true;
		}
		return false;
	}
	
	// This method determines and returns whether a point is scored or not (the ball crosses the top side)
	public boolean checkScoreP3(Ball pongBall) {
		if(pongBall.getY() < margin + scoreBoardHeight) {
			return true;
		}
		return false;
	}
	
	// This method determines and returns whether a point is scored or not (the ball crosses the bottom side)
	public boolean checkScoreP4(Ball pongBall) {
		if(pongBall.getY() >= WINDOW_HEIGHT + margin - paddleWidth - 1) {
			return true;
		}
		return false;
	}
	
	// This method draws the ball at its current coordinates and color
	public void draw(Graphics g) {
		g.setColor(ballColor); 
		
		g.fillOval(x-ballRadius, y-ballRadius, ballRadius*2, ballRadius*2); 
	}
	
}
