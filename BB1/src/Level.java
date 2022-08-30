import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Level extends OG {
	private ArrayList<Block> blocks;//different for each level
	private ArrayList<Ball> b = new ArrayList<Ball>();//all the balls in the level
	private boolean reset = true;//helps with the beginning of levels
	private Bar bar = new Bar();
	private int numLives = 3;
	private int lineX = 530;//starting value for the aiming line
	private ArrayList<Laser> lasers = new ArrayList<Laser>();//lasers in the level for the laser powerup
	private ArrayList<Powerup> powerups = new ArrayList<Powerup>();//the powerups that are falling and need to be drawn
	private boolean shot;//creates new laser
	private int catchInt;//for the catch powerup
	private boolean isCatch;//for the catch powerup
	private Ball b1;//the ball at the beginning of the level
	
	public Ball getB1() {
		return b1;
	}

	public void setB1(Ball b1) {
		this.b1 = b1;
	}

	public boolean isShot() {
		return shot;
	}

	public void setShot(boolean shot) {
		this.shot = shot;
	}

	public int getLineX() {
		return lineX;
	}

	public void setLineX(int lineX) {
		this.lineX = lineX;
	}

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public ArrayList<Ball> getB() {
		return b;
	}

	public void setB(ArrayList<Ball> b) {
		this.b = b;
	}

	public ArrayList<Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(ArrayList<Block> blocks) {
		this.blocks = blocks;
	}

	public int getNumLives() {
		return numLives;
	}

	public void setNumLives(int numLives) {
		this.numLives = numLives;
	}

	public boolean isReset() {
		return reset;
	}

	public void setReset(boolean reset) {
		this.reset = reset;
	}

	public Level() {// lives carry over from last level
		super();
	}

	public int numConcreteBlocks() {//how to know when the level is beaten
		int count = 0;
		for (int i = 0; i < blocks.size(); i++) {
			if (blocks.get(i) instanceof ConcreteBlock)
				count++;
		}
		return count;
	}

	public int playLevel(ColorPanel c) {//each iteration of the level

		if (reset == true) {//beginning of the level
			b1 = new Ball(0, 0);
			b1.setX(bar.getX() + (bar.getLength()) / 2 - 5);
			b1.setY(725);
			b1.fillBall();
			bar.paintBar();
			
			getG().setColor(Color.BLACK);//aiming line
			getG().drawLine(lineX,665 - (int) (Math.sqrt(70 * 70 - Math.abs(b1.getDeltax() - 5 - lineX) * Math.abs(b1.getDeltax() - 5 - lineX))),b1.getX() + 5, 735);
			for (Block b : blocks)//drawing the blocks
				b.updateGraphic();
			
			return 0;
		} else {

			if (getPowers()[2]) {// extra balls powerup
				b.add(new Ball(b.get(0).getX(), b.get(0).getY(), b.get(0).getDeltax() - 4, b.get(0).getDeltay()));
				b.add(new Ball(b.get(0).getX(), b.get(0).getY(), b.get(0).getDeltax() - 2, b.get(0).getDeltay()));
				b.add(new Ball(b.get(0).getX(), b.get(0).getY(), b.get(0).getDeltax() + 2, b.get(0).getDeltay()));
				powers[2] = false;
			}
			if (powers[1])// longBar powerup
				bar.setLongShort(false);
			else//regular bar
				bar.setLongShort(true);
			if (powers[6]) {// laser powerup
				getG().setColor(Color.red);
				if (shot) {//new lasers
					lasers.add(new Laser(bar.getX() + (bar.getLength()) / 2));
					shot = false;
				}
				for (Laser l : lasers) {//draws the lasers
					getG().fillRect(l.getX() - 3, l.getY(), 6, 15);
					l.setY(l.getY() - 5);
				}
				for (int i = lasers.size() - 1; i >= 0; i--) {//deals damage from the lasers to the blocks then gets rid of them
					for (Block blo : blocks) {
						if (lasers.get(i).isTouching(blo)) {
							if (blo instanceof Brick) {
								((Brick) blo).setStrength(((Brick) blo).getStrength() - 1);
							}
							lasers.remove(i);
							break;
						}
					}
				}
			}
			for (Ball ball : b) {//draws the balls
				if (ball.getDeltay() > 3)//if its too fast
					ball.setDeltay(ball.getDeltay() / 2);
				ball.fillBall();
			}
			for (Block b : blocks)//draws the blocks
				b.updateGraphic();
			bar.paintBar();//paints the bar
			if (powers[7])//concrete bottom powerup
				for (int i = 0; i < 7; i++) {
					ConcreteBlock cb = new ConcreteBlock(37 + 136 * i, 750);
					cb.updateGraphic();
				}
			for (int i = powerups.size() - 1; i >= 0; i--) {//gets rid of the powerups that are out of bounds
				if (powerups.get(i).isActive() == true)
					powerups.remove(powerups.indexOf(powerups.get(i)));
				else
					powerups.get(i).fall(bar);
			}

			for (int i = b.size() - 1; i >= 0; i--) {//checks all of the boundaries
				if (b.get(i).getX() < 31)//left
					b.get(i).setX(b.get(i).getX() + 10);
				if (b.get(i).getX() + b.get(i).getDiameter() > 960)//right
					b.get(i).setX(b.get(i).getX() - 10);
				if (b.get(i).getY() < 25)//top
					b.get(i).setY(b.get(i).getY() + 10);
				if (b.get(i).isInBounds() && blocks.size() > this.numConcreteBlocks()) {//still in bounds
					if (powers[4]) {// slow ball powerup
						b.get(i).setX(b.get(i).getX() + b.get(i).getDeltax() * 2);
						b.get(i).setY(b.get(i).getY() + b.get(i).getDeltay() * 2);
					} else if (powers[5]) {// fast ball powerup
						b.get(i).setX(b.get(i).getX() + b.get(i).getDeltax() * 12);
						b.get(i).setY(b.get(i).getY() + b.get(i).getDeltay() * 12);
					} else {//regular
						b.get(i).setX(b.get(i).getX() + b.get(i).getDeltax() * 5);
						b.get(i).setY(b.get(i).getY() + b.get(i).getDeltay() * 5);
					}
					if (bar.isTouching(b.get(i)))//bounce on the bar
						bar.bounce(b.get(i), b.get(i).getX());
					else if (b.get(i).isTouchingLeftBounds())//bounce left wall
						b.get(i).bounceLeftBounds();
					else if (b.get(i).isTouchingRightBounds())//bounce right wall
						b.get(i).bounceRightBounds();
					else if (b.get(i).isTouchingTopBounds())//bounce roof
						b.get(i).bounceTopBounds();
					else if (powers[7] && b.get(i).isTouchingBottomBounds())//bounce for concrete powerup
						b.get(i).bounceBottomBounds();

					else {

						for (int j = blocks.size() - 1; j >= 0; j--) {// Check if touch, bounce, block response
							if (blocks.get(j).isTouching(b.get(i)))
								blocks.get(j).bounce(b.get(i), blocks);
							if (blocks.get(j).getStrength() <= 0) {
								powerups.add(((Brick) blocks.get(j)).getP());
								blocks.remove(j);
							}
						}
					}


				}

				if (powers[9] && bar.isTouching(b.get(i))) {// catch powerup
					c.setStart(false);
					reset = true;
					catchInt = i;
					isCatch = true;
					if (b.size() <= 0) {
						numLives++;

					}
				}
				if (!b.get(i).isInBounds()) {//removes balls that are out of bounds
					b.remove(i);

				}
			}
			if (b.size() <= 0) {//if all the balls are gone, lives goes down and it resets
				numLives--;
				b1=new Ball(0,0);
				lineX=b1.getX();
				reset = true;
				getC().setStart(false);
				bar.reset();

			} else if (powers[9] && isCatch) {//catch powerup
				b.remove(catchInt);
				isCatch = false;
				lineX=bar.getX() + (bar.getLength()) / 2 - 5;
			}
			if (powers[8]) {// extra life powerup
				c.setNumLives(numLives + 1);
				powers[8] = false;
			} else
				c.setNumLives(numLives);
			for (Block b : blocks)//draws blocks
				b.updateGraphic();
			if (blocks.size() == this.numConcreteBlocks())// Win
				return 1;
			if (numLives <= 0)// Game over
				return -1;
			return 0;// keep going
		}
	}

}