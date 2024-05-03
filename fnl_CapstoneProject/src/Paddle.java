import java.awt.*;

public class Paddle {
	private int paddleSpeed, paddleLength;
	int xPos = window.width / 3;
	
	
	public Paddle() {
		
	}
	
	public void up() {
		
	}
	
	public void down() {
		
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.GREEN); // experimenting by making fill color green
		
		g.fillRect(xPos, yPos, 10, paddleLength); // make a rectangle that has dimensions of 10x10
	}
}
