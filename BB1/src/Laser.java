public class Laser {
	private int x;//position
	private int y;
	
	public Laser(int xpos) {
		x=xpos;
		y=680;
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
	public boolean isTouching(Block b) {//if it's touching then the block's strength goes down
		if(y<=b.getY()+b.getHeight()&&y+15>=b.getY()) {
			if(x-3<=b.getX()+b.getWidth()&&x+3>=b.getX())
				return true;
		}
		return false;
	}

}