import java.awt.Color;

public class Ball extends OG {
	private static int numBalls;
	private int x = 505;// change
	private int y = 695;// change
	private int deltax;// for the slope
	private int deltay;// for the slope
	private final int diameter = 10;// might need to be changed

	public Ball(int x, int y, int deltax, int deltay) {// this is for when there are multiple balls
		this.x = x;
		this.y = y;
		this.deltax = deltax;
		this.deltay = deltay;
		numBalls++;

	}

	public Ball(int deltax, int deltay) {// this is for easier use at the beginning of a level or when the ball goes out of bounds
		// x=starting x value
		// y=starting y value
		this.deltax = deltax;
		this.deltay = deltay;
		numBalls++;
	}

	public int getDiameter() {
		return diameter;
	}

	public static int getNumBalls() {
		return numBalls;
	}

	public static void setNumBalls(int numBalls) {// to reset once the number of balls goes down
		Ball.numBalls = numBalls;
	}

	public int getX() {// to get the x position
		return x;
	}

	public void setX(int x) {// to change its position
		this.x = x;
	}

	public int getY() {// to get its y position
		return y;
	}

	public void setY(int y) {// to change its position
		this.y = y;
	}

	public int getDeltax() {//to help change the position of the ball
		return deltax;
	}

	public void setDeltax(int deltax) {// to be used in the bounce method
		this.deltax = deltax;
	}

	public int getDeltay() {//to help change the position of the ball
		return deltay;
	}

	public void setDeltay(int deltay) {// to be used in the bounce method
		this.deltay = deltay;
	}

	public boolean isInBounds() {//checks if the ball is still above the bottom of the frame
		if (y > 770)
			return false;
		return true;
	}

	public boolean isTouchingLeftBounds() {//checks if the ball is touching the left wall
		// 31 is the x value for the left bounds
		if (x <= 31) {
			return true;
		}
		return false;
	}

	public void bounceLeftBounds() {//used if ball is touching the left wall, changes the direction and position of the ball
		if(deltax==0)
			deltax=1;
		x = ((int) x-deltax);
		y = ((int) y-deltay);
		deltax = deltax * -1;
	}

	public boolean isTouchingRightBounds() {//checks if the ball is touching the right wall
		// 960 is the x value for the right bounds
		if (x + diameter >= 960) {
			return true;
		}
		return false;
	}

	public void bounceRightBounds() {//used if ball is touching the right wall, changes the direction and position of the ball
		if(deltax==0)
			deltax=-1;
		x = ((int) x-deltax);
		y = ((int) y-deltay);
		deltax = deltax * -1;
	}

	public boolean isTouchingTopBounds() {//checks if the ball is touching the top
		// 25 is the y value of the top bounds
		if (y <= 25)
			return true;
		return false;
	}

	public void bounceTopBounds() {//used if ball is touching the top, changes the direction and position of the ball
		x = ((int) x-deltax);
		y = ((int) y-deltay);
		deltay = deltay * -1;
	}

	public boolean isTouchingBottomBounds() {//checks if the ball is touching the bottom, only for concrete powerup
		// 737 is the y value of the bottom bounds
		if (y + diameter >= 737)
			return true;
		return false;
	}

	public void bounceBottomBounds() {//used if ball is touching the bottom, changes the direction of the ball, only for concrete powerup
		deltay = deltay * -1;
	}

	public void fillBall() {//paints graphics for the ball
		getG().setColor(Color.black);
		getG().fillOval(x, y, diameter, diameter);
		getG().setColor(Color.white);
		getG().fillOval(x + 2, y + 2, 2, 2);
	}

}