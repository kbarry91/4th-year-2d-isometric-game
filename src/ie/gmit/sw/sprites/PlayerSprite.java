package ie.gmit.sw.sprites;

/*
 *   
 *   BufferedImage[][]
 *   --------------------------
 *   {U0, U1, U2, U3}, =>Up
 *   {D0, D1, D2, D3}, =>Down
 *   {L0, L1, L2, L3}, =>Left
 *   {R0, R1, R2, R3}, =>Right
 * 
 */
import java.awt.image.BufferedImage;
public class PlayerSprite implements Spriteable { //Sprite belongs in some sort of hierarchy....
	
	private String name; //The name of the sprite
	private BufferedImage[][] images = new BufferedImage[4][3]; //The images used in the animation 
	private Direction direction = Direction.DOWN; //The current orientation of the sprite
	private int index = 0; //The current image index.
	private Point position; //The current x, y position
	private int chestsCollected = 0;
	private boolean endPointActivated = false;
	public PlayerSprite() {
		super();
	}
	
	public PlayerSprite(String name, Point p) {
		super();
		this.name = name;
		this.position = p;
	}
	

	public void drawSprite(BufferedImage [] img) {
		int row = 0, col = 0;
		for (int i = 0; i < img.length; i++) {
			images[row][col] = img[i];
			if (col == images[row].length - 1) {
				row++;
				col = 0;
			}else {
				col++;
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.Spriteable#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Spriteable#getPosition()
	 */
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
	
	public BufferedImage step(Direction d) {
		setDirection(d);
		if (index < images[direction.getOrientation()].length - 1) {
			index++;
		}else {
			index = 0;
		}
		
		return images[d.getOrientation()][index];
	}
	
	public void setDirection(Direction d) {
		direction = d;
	}
	
	public Direction getDirection() {
        return this.direction;
    }
	
	public void move() { //This method is suspiciously like one I've seen already....
		step(direction);
		
		switch(direction.getOrientation()) {
		case 1:
			position.setY(position.getY() + 1); //UP
			System.out.println(position.getY());
			System.out.println(direction);
			break;
		case 2:
			position.setX(position.getX() - 1); //DOWN
			System.out.println(position.getX());
			System.out.println(direction);
			break;
		case 3:
			position.setX(position.getX() + 1); //LEFT
			System.out.println(position.getX());
			System.out.println(direction);
			break;
		default:
			position.setY(position.getY() - 1); //RIGHT
			System.out.println(position.getY());
			System.out.println(direction);
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
}