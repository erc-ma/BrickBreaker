import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ConcreteBlock extends Block {
	public ConcreteBlock(int x, int y) {
		super(x, y);
	}

	public void updateGraphic() {//metallic
		BufferedImage im = null;
		try {
			im = ImageIO.read(new File("concreteblock.jpg"));
		} catch (IOException exc) {
			// TODO: Handle exception.

		}
		getG().drawImage(im, getX(), getY(), OG.getC());
	}
}