package testing_workspace;
import java.awt.*;

public class Paddle {
	private int xPos, yPos, paddleSpeed, paddleLength, paddleWidth, margin, scoreBoardHeight, WINDOW_HEIGHT;
	Color color;

	
	
	public Paddle(int xPos, int yPos, int paddleSpeed, int paddleLength, int paddleWidth, int margin, int scoreBoardHeight, int WINDOW_HEIGHT, Color color) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.paddleSpeed = paddleSpeed;
		this.paddleLength = paddleLength;
		this.paddleWidth = paddleWidth;
		this.margin = margin;
		this.scoreBoardHeight = scoreBoardHeight;
		this.WINDOW_HEIGHT = WINDOW_HEIGHT;
		this.color = color;
	}
	
	public int getPaddleSpeed() {
		return paddleSpeed;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public int getPaddleLength() {
		return paddleLength;
	}
	
	public void setPaddleSpeed(int paddleSpeed) {
		this.paddleSpeed = paddleSpeed;
	}
	
	public void setPaddleLength(int paddleLength) {
		this.paddleLength = paddleLength;
	}
	
	public void up() {
		if(yPos > (margin + scoreBoardHeight)) {
			yPos -= paddleSpeed;
		}	
	}
	
	public void down() {
		if((yPos + paddleLength) < (WINDOW_HEIGHT-margin+scoreBoardHeight))
		yPos += paddleSpeed;
	}
	
	public boolean collides(Ball pongBall) {
//		System.out.println("xPos: " + xPos + "    xPos+paddleWidth: " + (xPos+paddleWidth) + "   center: " + (pongBall.getX() + pongBall.getBallRadius()));
		if((((((pongBall.getX() + pongBall.getBallRadius()) >= (xPos)) && ((pongBall.getX()-pongBall.getBallRadius()) <= (xPos+paddleWidth)))))){
//			System.out.println("Apassed");
			if((pongBall.getY() > yPos) && ((pongBall.getY() - 2*pongBall.getBallRadius()) < (yPos+paddleLength))) {
//				System.out.println("passed");
				return true;
			}
		}
		return false;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(color); // experimenting by making fill color green
		
		g.fillRect(xPos, yPos, paddleWidth, paddleLength); // make a rectangle that has dimensions of 10x10
	}
}
