import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bar extends OG{
	
	private int x;
	private final int y = 740;//height = 20, approx:737-height=710, space at bottom
	private int deltaX;//velocity of the bar
	private final int regLength=200;
	private final int longLength=400;
	private int length = 200;
	private boolean longShort=true;//short is true, long is false
	
	public boolean isLongShort() {
		return longShort;
	}
	public void setLongShort(boolean longShort) {
		this.longShort = longShort;
		if(longShort==true)
			length=regLength;
		else
			length=longLength;
	}
	public Bar() {//the position of a bar will always begin the same, then once the level begins, it can move
		x=408;// starting x position
		deltaX=0;
	}
	public int getDeltaX() {
		return deltaX;
	}
	public void setDeltaX(int a) {
		deltaX=a;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {//change position based on arrows
		this.x = x;
	}

	public void bounce(Ball b, int xpos) {//gradient, 5 sections with different resulting velocities depending on where the ball hits
		if (xpos<=x+length/5) {//farthest left section
			b.setDeltay(-2);//negative because top of the panel is zero and bottom is a positive number
			b.setDeltax(-4);
		}
		else if(xpos<=x+length*2/5) {
			b.setDeltax(-3);
			b.setDeltay(-3);
			
		}
		
		else if(xpos<=x+length*3/5) {//middle
			b.setDeltax(0);
			b.setDeltay(-3);//may have to change to make it move faster
		}
		else if(xpos<=x+length*4/5) {
			b.setDeltax(3);
			b.setDeltay(-3);
		}
			
		else{//farthest right section
			b.setDeltax(4);
			b.setDeltay(-2);
		}
			
	}
	public boolean isTouching(Ball b) {//check if the ball is touching it, then call bounce method
		if(!(b.getY()+b.getDiameter()>=y))
			return false;
		else if(b.getX()+b.getDiameter()>=x&&b.getX()<=x+length)
			return true;
		return false;
	}
	public void paintBar() {//graphics for bar
		BufferedImage img = null;
		if(longShort==true) {
			try {// take title jpeg and paint it
				img = ImageIO.read(new File("redBar.jpg"));
			} catch (IOException exc) {
				// TODO: Handle exception.
			}
			
		}
		else {
			try {// take title jpeg and paint it
				img = ImageIO.read(new File("longRedBar.jpg"));
			} catch (IOException exc) {
				// TODO: Handle exception.
			}
		}
		
		
		getG().drawImage(img, x, y, getC());
		
	}
	
	public int getLength() {
		return length;
	}
	public void reset() {//resets the bar, for the start of levels
		if(longShort==true)
		x=408;
		else
			x=308;
	}


}