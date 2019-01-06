package ie.gmit.sw.sprites;

import java.awt.image.BufferedImage;

import ie.gmit.sw.Direction;

/**
 * Represents a Player Sprite. This is the main user controlled game piece.
 * 
 * @author Kevin Barry
 */
public class PlayerSprite implements SpriteInterface {

	private String name; // The name of the sprite
	private BufferedImage[][] images = new BufferedImage[4][3]; // The images used in the animation
	private Direction direction = Direction.DOWN; // The current orientation of the sprite
	private int index = 0; // The current image index.
	private Point position; // The current x, y position
	private int chestsCollected = 0;
	private boolean endPointActivated = false;

	/**
	 * Creates a new <code>PlayerSprite</code>.
	 */
	public PlayerSprite() {
		super();
	}

	/**
	 * Creates a new <code>PlayerSprite</code>.
	 *
	 * @param name The name of the player.
	 * @param p    The starting position of player..
	 */
	public PlayerSprite(String name, Point p) {
		super();
		this.name = name;
		this.position = p;
	}

	/**
	 * Draws the sprite.
	 *
	 * @param img Array of images for sprite.
	 */
	public void drawSprite(BufferedImage[] img) {
		int row = 0, col = 0;
		for (int i = 0; i < img.length; i++) {
			images[row][col] = img[i];
			if (col == images[row].length - 1) {
				row++;
				col = 0;
			} else {
				col++;
			}
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Point getPosition() {
		return position;
	}

	@Override
	public void setPosition(Point position) {
		this.position = position;
	}

	public BufferedImage getImage() {
		return images[direction.getOrientation()][index];
	}

	/**
	 * @param d The direction of the sprite image.
	 */
	public BufferedImage step(Direction d) {
		setDirection(d);
		if (index < images[direction.getOrientation()].length - 1) {
			index++;
		} else {
			index = 0;
		}

		return images[d.getOrientation()][index];
	}

	/**
	 * Sets the sprite position and moves unless sprite is at edge od board.
	 */
	public void move() {
		step(direction);

		switch (direction.getOrientation()) {
		case 1:
			if (position.getY() + 1 < 10)// restrict player from moving off game grid
				position.setY(position.getY() + 1); // UP
			break;
		case 2:
			if (position.getX() - 1 > -1)
				position.setX(position.getX() - 1); // DOWN
			break;
		case 3:
			if (position.getX() + 1 < 10)
				position.setX(position.getX() + 1); // LEFT
			break;
		default:
			if (position.getY() - 1 > -1)
				position.setY(position.getY() - 1); // RIGHT
			break;
		}
	}

	public int getChestsCollected() {
		return chestsCollected;
	}

	public void setChestsCollected(int chestsCollected) {
		this.chestsCollected = chestsCollected;
	}

	public boolean isEndPointActivated() {
		return endPointActivated;
	}

	public void setEndPointActivated(boolean endPointActivated) {
		this.endPointActivated = endPointActivated;
	}

	public void setDirection(Direction d) {
		direction = d;
	}

	public Direction getDirection() {
		return this.direction;
	}
}