import java.awt.Color;
import java.awt.Graphics;

public class SidePaddle extends Paddle {
	private int xPos, yPos, paddleSpeed, paddleLength, paddleWidth, margin, WINDOW_WIDTH;
	private Color paddleColor;
	
	public SidePaddle(int xPos, int yPos, int paddleSpeed, int paddleLength, int paddleWidth, int margin, int scoreBoardWidth, int WINDOW_WIDTH, int scoreBoardHeight, int WINDOW_HEIGHT, Color color) {
		super(xPos, yPos, paddleSpeed, paddleLength, paddleWidth, margin, scoreBoardHeight, WINDOW_HEIGHT, color);
		this.xPos = xPos;
		this.yPos = yPos;
		this.paddleSpeed = paddleSpeed;
		this.paddleLength = paddleLength;
		this.paddleWidth = paddleWidth;
		this.margin = margin;
		this.WINDOW_WIDTH = WINDOW_WIDTH;
		this.paddleColor = color;
	}
		
	public void right() {
		if ((xPos + paddleLength) < (WINDOW_WIDTH-margin))
			xPos += paddleSpeed *2;
	}
	
	public void left() {
		
		if(xPos > (margin)) {
			xPos -=  2*paddleSpeed;
		}	
	}
	
	public boolean horizontalCollides(Ball pongBall) {
		if ((pongBall.getY() + pongBall.getBallRadius()) >=  yPos && ((pongBall.getY() - pongBall.getBallRadius()) <= (yPos + paddleWidth)))
		{
			if ((pongBall.getX() > xPos) && ((pongBall.getX() - 2*pongBall.getBallRadius()) < (xPos+paddleLength)))
			{
				return true;
			}	
		}
		else
		{
			return false;
		}
		return false;
	}

	
	public void draw(Graphics g)
	{
		g.setColor(paddleColor); 
		
		g.fillRect(xPos, yPos, paddleLength, paddleWidth); 
	}


}

