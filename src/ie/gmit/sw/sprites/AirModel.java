package ie.gmit.sw.sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class AirModel {
private static AirModel instance = new AirModel();
	
	private static BufferedImage image;

	
	private AirModel() {
		try {
			image = ImageIO.read(new File("./resources/images/objects/0000.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static BufferedImage getImage() {
		return image;
	}
	
	public static AirModel getInstance() {
		if (instance == null) {
			instance = new AirModel();
		}
		
		return instance;
	}
}
