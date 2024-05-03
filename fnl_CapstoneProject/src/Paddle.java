import java.awt.*;

public class Paddle {
	private int paddleSpeed, paddleLength;
	int xPos;
	int yPos;
	int height;
	int width;
	
	
	public Paddle(/*int xPos, int yPos, int paddleWidth, int paddleLength*/) {
//		this.paddleLength = paddleLength;
	
		xPos = 100;
		yPos = 100;
		height = 128;
		width = 64;
		
		
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
		
		g.fillRect(xPos, yPos, width, height); // make a rectangle that has dimensions of 10x10
	}
}
