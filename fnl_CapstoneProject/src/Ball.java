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
	
	public int getBallSpeed() {
		return ballSpeed;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getBallRadius() {
		return ballRadius;
	}
	
	public Color getBallColor() {
		return ballColor;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void changeDirX() {
		dirX *= -1;
	}
	
	public void changeDirY() {
		dirY *= -1;
	}
	
	public void setBallSpeed(int ballSpeed) {
		this.ballSpeed = ballSpeed;
	}
	
	public void setBallRadius(int ballRadius) {
		this.ballRadius = ballRadius;
	}
	
	public void setBallColor(Color ballColor) {
		this.ballColor = ballColor;
	}
	
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
