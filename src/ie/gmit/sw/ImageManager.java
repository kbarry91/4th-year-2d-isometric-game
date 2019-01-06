package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

/*
 * Controls loading of BufferedImages.
 * 
 * @author Kevin Barry
 */
public class ImageManager {

	public ImageManager() {
		super();
	}

	/**
	 * Loads an array buffered images for animations.
	 * 
	 * @param directory The directory path of the images.
	 * @param Array     of buffered images to manipulate.
	 * @return An array of bufferedImages.
	 */
	public static BufferedImage[] loadImages(String directory, BufferedImage[] img) throws Exception {

		File dir = new File(directory);
		File[] files = dir.listFiles();
		Arrays.sort(files, (s, t) -> s.getName().compareTo(t.getName()));

		img = new BufferedImage[files.length];
		for (int i = 0; i < files.length; i++) {
			img[i] = ImageIO.read(files[i]);
		}
		return img;
	}

	/**
	 * Loads a single buffered image.
	 * 
	 * @param img A string containing the file path of the image to load
	 * @return A bufferedImage.
	 */
	public static BufferedImage loadImage(String img) throws IOException {
		return ImageIO.read(new File(img));

	}
}
