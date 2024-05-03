package test;
import javax.swing.JFrame;



public class PongTest 
{
	boolean startGame = true;
	int score1 = 0, score2 = 0;
	static final int WIDTH = 1280, HEIGHT = 1280;
	Ball pongBall;
	
	Paddle p1 = new Paddle(0, 0, 0, HEIGHT/10);
	Paddle cpu = new Paddle(0, 0, 0, HEIGHT/10);
//	p1.setPaddleSpeed(10);
//	cpu.setPaddleLength(HEIGHT/10);
	
	public void reset() {
		
	}
	
	public boolean collides() {
		return false;
	}
	public void paintComponent() {
		
	}
	public void draw() {
		
	}
	public void keyPressed() {
		
	}
	public void estimatedPosition() {
		
	}
	public void cpuMove() {
		
	}
 	public static void main(String[] args) {
		JFrame window = new JFrame("Pong Game Remix");
		window.setBounds(150, 50, 1280, 750); 
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Drawer panel = new Drawer();
		window.add(panel);
		Paddle paddle = new Paddle(0, 0, 0, 0);
		paddle.setPaddleSpeed(10);
		window.setVisible(true);
	}
	
}
