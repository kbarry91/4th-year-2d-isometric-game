package ie.gmit.sw.sprites;

import java.awt.image.BufferedImage;

public abstract class ObjectSprite implements Spriteable {
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
