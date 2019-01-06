package ie.gmit.sw.sprites;

import java.awt.image.BufferedImage;

/*
 * An abstract concrete flyweight class representing a sprite object.
 * 
 * @author Kevin Barry
 * */
public abstract class ObjectSprite implements SpriteInterface {
	
	// Allows different name, postion and image for each sprite.
	protected BufferedImage image;
	protected Point position;
	protected String name;
	

	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	@Override
	public Point getPosition() {
		return position;
	}
	
	@Override
	public void setPosition(Point position) {
		this.position = position;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
}
