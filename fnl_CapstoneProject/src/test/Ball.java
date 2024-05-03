package test;
import java.awt.Color;

public class Ball {
	private int ballSpeed, ballRadius;
	private Color ballColor;
	
	public Ball(int ballSpeed, int ballRadius, Color ballColor) {
		this.ballSpeed = ballSpeed;
		this.ballColor = ballColor;
		this.ballRadius = ballRadius;
	}
	
	public int getBallSpeed() {
		return ballSpeed;
	}
	
	public int getBallRadius() {
		return ballRadius;
	}
	
	public Color getBallColor() {
		return ballColor;
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
	
	public void bounce() {
		
	}
	
	public void moveBall() {
		
	}
}
