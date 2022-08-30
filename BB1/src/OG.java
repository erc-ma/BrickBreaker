import java.awt.Graphics;

public class OG {
	private static Graphics g;//To allow objects without the graphics object to draw their objects
	private static ColorPanel c;//To allow objects not extending JPanel to draw images on the colorpanel
	protected static boolean[] powers=new boolean[10];//array of booleans to indicate the powerup being used

	public static boolean[] getPowers() {
		return powers;
	}

	public static void setPowers(boolean[] powers) {
		OG.powers = powers;
	}

	public static ColorPanel getC() {
		return c;
	}

	public static void setC(ColorPanel c) {
		OG.c = c;
	}

	public static Graphics getG() {
		return g;
	}

	public static void setG(Graphics g) {
		OG.g = g;
	}
	
	
}