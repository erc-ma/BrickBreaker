import java.awt.Color;
import java.awt.Graphics;

public class Powerup extends OG {
	private static final int diameter = 40;
	private int x;//position
	private int y;//position
	private int type;//gives power
	private boolean active;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Powerup(int xval, int yval) {
		x = xval;
		y = yval;
		type = (int) (Math.random() * 30);
	}

	public static int getDiameter() {
		return diameter;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/*list of powerups with their indices
	 * 0-OppPU colorpanel
	 * 1LongPU bar or level 
	 * 2-BallsPU level 
	 * 3-PowerPU brick
	 * 4-SlowPU level:) 
	 * 5-FastPU level:) 
	 * 6-LaserPU level and colorpanel 
	 * 7-ConcretePU
	 * level 8-LifePU level 
	 * 9-CatchPU level
	 */
	public boolean isTouching(Bar b) {//checks if it is touching the bar
		if (y + diameter < 740||y>760)//if its above the bar
			return false;
		else if (x + diameter >= b.getX() && x <= b.getX() + b.getLength())//touching the bar
			return true;
		return false;//missed the bar
	}

	public void fall(Bar b) {
		if (type < 10 && !(y + diameter >= 750) && !isTouching(b)) {
			switch (type) {//changes the color of the falling powerup
			case 0:// Opposite bar
				getG().setColor(Color.RED);
				break;
			case 1://long bar
				getG().setColor(Color.ORANGE);
				break;
			case 2:// Many Balls
				getG().setColor(Color.YELLOW);
				break;
			case 3://strong ball (power)
				getG().setColor(Color.GREEN);
				break;
			case 4://slow ball
				getG().setColor(Color.BLUE);
				break;
			case 5://fast ball
				getG().setColor(Color.CYAN);
				break;
			case 6://laser
				getG().setColor(Color.MAGENTA);
				break;
			case 7://concrete bottom
				getG().setColor(Color.PINK);
				break;
			case 8://extra life
				getG().setColor(Color.WHITE);
				break;
			case 9://catch
				getG().setColor(Color.DARK_GRAY);
				break;

			}

			getG().fillOval(x, y, 20, 20);//draws the falling powerup
			
		}
		if (isTouching(b)&& type < 10) {//if its touching it then give the powerup
			boolean[] p = new boolean[10];
			p[type] = true;
			setPowers(p);
			active = true;

		}
		y += 4;//changes the position

	}
}