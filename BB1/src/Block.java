import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Block extends OG {
	private static int height = 56;// Size of all Blocks
	private static int width = 136;
	private int x;
	private int y;

	public Block(int x, int y) {
		super();
		this.x = x;
		this.y = y;
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

	public static int getHeight() {
		return height;
	}

	public static int getWidth() {
		return width;
	}

	public boolean isTouching(Ball b) {//checks if ball is touching the block
		if (b.getY() >= y && b.getX() >= x && b.getX() <= x + width
				&& b.getY() <= y + height)
			return true;
		return false;
	}

	public void bounce(Ball b, ArrayList<Block> blocks) {// if isTouching, make the sides bounce
		double tempx = 0.0 + b.getX();
		double tempy = 0.0 + b.getY();

		boolean a = true;
		double smallDY;
		if (b.getDeltax() != 0) {
			smallDY = Math.abs((0.0 + b.getDeltay()) / b.getDeltax());
		} else
			smallDY = Math.abs((0.0 + b.getDeltay()));
		for (int i = 0; i < Math.abs(b.getDeltax()); i++) {// Increment to check if it touches nearby block
			if (b.getDeltax() > 0)//Increments x and y according to where the ball came from(dx and dy)
				tempx--;
			else
				tempx++;
			if (b.getDeltay() > 0)
				tempy -= smallDY;
			else
				tempy += smallDY;

			for (int j = 0; j < blocks.size(); j++) {//Checks if a block was skipped over when isTouching, prevents ball from bouncing inside of a brick
				if (blocks.get(j) != this && blocks.get(j).isTouching(new Ball((int) tempx, (int) tempy, 0, 0))) {
					b.setX((int) tempx);
					b.setY((int) tempy);
					blocks.get(j).bounce(b, blocks);
					return;
				}
			}
		}
		tempx = 0.0 + b.getX();//resets tempx and tempy
		tempy = 0.0 + b.getY();
		while (a) {//increments until reach the side
			if (b.getDeltax() > 0) {
				if (b.getDeltay() > 0) {// +dX +dY
					if (tempy < y || tempx < x) {
						a = false;
					}
				} else {// +dX -dY
					if (tempy > y || tempx < x) {
						a = false;
					}
				}
			} else {
				if (b.getDeltay() > 0) {// -dX +dY
					if (tempy < y || tempx > x) {
						a = false;
					}
				} else {// -dX -dY
					if (tempy > y || tempx > x) {
						a = false;
					}
				}
			}
			if (b.getDeltax() > 0)
				tempx--;
			else
				tempx++;
			if (b.getDeltay() > 0)
				tempy -= smallDY;
			else
				tempy += smallDY;
		}
		if (b.getDeltax() > 0)
			tempx--;
		else
			tempx++;
		if (b.getDeltay() > 0)
			tempy -= smallDY;
		else
			tempy += smallDY;
		b.setX((int) (tempx+0.5));//sets the ball to postion of the side of the block
		b.setY((int) (tempy+0.5));

		//Check which way to bounce
		if (b.getDeltax() > 0) {
			if (b.getDeltay() > 0) {// +dX +dY
				if (Math.abs(y - b.getY()) < Math.abs(x - b.getX()))//checks which distance is shortest
					b.setDeltay(b.getDeltay() * -1);
				else
					b.setDeltax(b.getDeltax() * -1);
			} else {// +dX -dY
				if (Math.abs(y + height - b.getY()) < Math.abs(x - b.getX()))
					b.setDeltay(b.getDeltay() * -1);
				else
					b.setDeltax(b.getDeltax() * -1);
			}
		} else {
			if (b.getDeltay() > 0) {// -dX +dY
				if (Math.abs(y - b.getY()) < Math.abs(x + width - b.getX()))
					b.setDeltay(b.getDeltay() * -1);
				else
					b.setDeltax(b.getDeltax() * -1);
			} else {// -dX -dY
				if (Math.abs(y + height - b.getY()) < Math.abs(x + width - b.getX()))
					b.setDeltay(b.getDeltay() * -1);
				else
					b.setDeltax(b.getDeltax() * -1);
			}
		}

	}


	public abstract void updateGraphic();//to be implemented

	public int getStrength() {//general strength for a ConcreteBlock, unchanging
		// TODO Auto-generated method stub
		return 1;
	}
}