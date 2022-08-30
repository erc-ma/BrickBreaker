import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Brick extends Block{
	private Powerup p;//all have a powerup
	private int strength;//to tell when to get rid of it
	//4 levels of strength
	
	
	public Brick(int strength, int x, int y) {
		super(x,y);
		p=new Powerup(x,y);//random powerup
		this.strength=strength;
	}
	
	
	public Powerup getP() {
		return p;
	}


	public void setP(Powerup p) {
		this.p = p;
	}


	
	
	public int getStrength() {
		return strength;
	}


	public void setStrength(int strength) {
		this.strength = strength;
	}


	public void updateGraphic() {//graphics for corresponding strengths
		BufferedImage im=null;
		if(strength == 0) {
			//Brick gets deleted
		}
		if(strength==4) {//strongest, brightest red
			
			try {
				im = ImageIO.read(new File("brick4.jpg"));
			} catch (IOException exc) {
				// TODO: Handle exception.
				
			}
		}
		else if(strength==3){
			try {
				im = ImageIO.read(new File("brick3.jpg"));
			} catch (IOException exc) {
				// TODO: Handle exception.
			}
		}		
		else if(strength==2){
			try {
				im = ImageIO.read(new File("brick2.jpg"));
			} catch (IOException exc) {
				// TODO: Handle exception.
			}
		}
		else if (strength==1){//weakest, darkest red
			try {
				im = ImageIO.read(new File("brick1.jpg"));
			} catch (IOException exc) {
				// TODO: Handle exception.
			}
		}
		getG().drawImage(im, getX(), getY(), OG.getC());
		
	}
	public void bounce(Ball b,ArrayList<Block>blocks) {//if it bounces for a brick, the strength goes down
		super.bounce(b,blocks);
		if(powers[3]) {//strong ball powerup, strength goes down by two
			strength-=2;
		}
		else 
		strength--;
	}
	
	
}