import java.awt.*;
public class sidePaddle {
	private int xPos, yPos, paddleSpeed, paddleLength, paddleWidth, margin, scoreBoardWidth, WINDOW_WIDTH;
	
	public sidePaddle(int xPos, int yPos, int paddleSpeed, int paddleLength, int paddleWidth, int margin, int scoreBoardWidth, int WINDOW_WIDTH) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.paddleSpeed = paddleSpeed;
		this.paddleLength = paddleLength;
		this.paddleWidth = paddleWidth;
		this.margin = margin;
		this.scoreBoardWidth = scoreBoardWidth;
		this.WINDOW_WIDTH = WINDOW_WIDTH;
	}
	
	public int getPaddleSpeed() {
		return paddleSpeed;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getPaddleWidth() {
		return paddleWidth;
	}
	
	public void setPaddleSpeed(int paddleSpeed) {
		this.paddleSpeed = paddleSpeed;
	}
	
	public void setPaddleWidth(int paddleLength) {
		this.paddleWidth = paddleLength;
	}
	
	public void right() {
		if((xPos - (2*paddleLength)/3 ) < (WINDOW_WIDTH))
			xPos += paddleSpeed;
	}
	public void actRight() {
		if ((xPos + paddleLength) < (WINDOW_WIDTH))
			xPos += paddleSpeed;
	}
	
	public void left() {
		
		if(xPos > (margin + scoreBoardWidth)) {
			xPos -= paddleSpeed;
		}	
	}
	
//	public boolean collides(Ball pongBall) {
////		System.out.println("xPos: " + xPos + "    xPos+paddleWidth: " + (xPos+paddleWidth) + "   center: " + (pongBall.getX() + pongBall.getBallRadius()));
//		if((((((pongBall.getX() + pongBall.getBallRadius()) >= (xPos)) && ((pongBall.getX()-pongBall.getBallRadius()) <= (xPos+paddleWidth)))))){
////			System.out.println("Apassed");
//			if((pongBall.getY() > yPos) && ((pongBall.getY() - 2*pongBall.getBallRadius()) < (yPos+paddleLength))) {
//				System.out.println("passed");
//				return true;
//			}
//		}
//		return false;
//	}
	
	public boolean sideCollides(Ball pongBall) {
//		System.out.println("xPos: " + xPos + "    xPos+paddleWidth: " + (xPos+paddleWidth) + "   center: " + (pongBall.getX() + pongBall.getBallRadius()));
//		if ()
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.GREEN); // experimenting by making fill color green
		
		g.fillRect(xPos, yPos, paddleLength, paddleWidth); // make a rectangle that has dimensions of 10x10
	}
}

