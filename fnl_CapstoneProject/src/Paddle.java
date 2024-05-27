import java.awt.*;

/*
 * Author: Owen Chau
 * Date: 5/27/2024
 * Revision: Production Release
 * Notes: Moves up and down and checks collisions with Ball
*/

public class Paddle {
	private int xPos, yPos, paddleSpeed, paddleLength, paddleWidth, margin, scoreBoardHeight, WINDOW_HEIGHT;
	private Color paddleColor;
	
	public Paddle(int xPos, int yPos, int paddleSpeed, int paddleLength, int paddleWidth, int margin, int scoreBoardHeight, int WINDOW_HEIGHT, Color color) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.paddleSpeed = paddleSpeed;
		this.paddleLength = paddleLength;
		this.paddleWidth = paddleWidth;
		this.margin = margin;
		this.scoreBoardHeight = scoreBoardHeight;
		this.WINDOW_HEIGHT = WINDOW_HEIGHT;
		this.paddleColor = color;
	}
	
	// This method returns the current paddle speed
	public int getPaddleSpeed() {
		return paddleSpeed;
	}
	
	// This method returns the current y position of the paddle
	public int getYPos() {
		return yPos;
	}
	
	// This method returns the current paddle length
	public int getPaddleLength() {
		return paddleLength;
	}
	
	// This method sets the paddle speed
	public void setPaddleSpeed(int paddleSpeed) {
		this.paddleSpeed = paddleSpeed;
	}
	
	// This method sets the paddle length
	public void setPaddleLength(int paddleLength) {
		this.paddleLength = paddleLength;
	}
	
	// This method moves the paddle up by the paddle speed amount
	public void up() {
		if(yPos > (margin + scoreBoardHeight)) {
			yPos -= paddleSpeed;
		}	
	}
	
	// This method moves the paddle down by the paddle speed amount
	public void down() {
		if((yPos + paddleLength) < (WINDOW_HEIGHT-margin+scoreBoardHeight))
		yPos += paddleSpeed;
	}
	
	// This method returns whether the ball collides with the left and right paddles or not
	public boolean collides(Ball pongBall) {
		if((((((pongBall.getX() + pongBall.getBallRadius()) >= (xPos)) && ((pongBall.getX()-pongBall.getBallRadius()) <= (xPos+paddleWidth)))))){
			if((pongBall.getY() > yPos) && ((pongBall.getY() - 2*pongBall.getBallRadius()) < (yPos+paddleLength))) {
				return true;
			}
		}
		return false;
	}
	
	// This method draws the paddle at its current coordinates and color
	public void draw(Graphics g) {
		g.setColor(paddleColor);
		
		g.fillRect(xPos, yPos, paddleWidth, paddleLength);
	}
}
