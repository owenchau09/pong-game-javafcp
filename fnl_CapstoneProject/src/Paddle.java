import java.awt.*;

public class Paddle {
	private int xPos, yPos, paddleSpeed, paddleLength, paddleWidth;

	
	
	public Paddle(int xPos, int yPos, int paddleSpeed, int paddleLength, int paddleWidth) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.paddleSpeed = paddleSpeed;
		this.paddleLength = paddleLength;
		this.paddleWidth = paddleWidth;
	
//		xPos = 100;
//		yPos = 100;
//		height = 128;
//		width = 64;
		
		
	}
	
	public int getPaddleSpeed() {
		return paddleSpeed;
	}
	
	public int getPaddleLength() {
		return paddleLength;
	}
	
	public void setPaddleSpeed(int paddleSpeed) {
		this.paddleSpeed = paddleSpeed;
	}
	
//	public void setPaddleLength(int paddleLength) {
//		this.paddleLength = paddleLength;
//	}
	
	public void up() {
		
	}
	
	public void down() {
		
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.GREEN); // experimenting by making fill color green
		
		g.fillRect(xPos, yPos, paddleWidth, paddleLength); // make a rectangle that has dimensions of 10x10
	}
}
