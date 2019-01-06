package ie.gmit.sw.sprites;

/*
 * Represents a set of x and y co-ordinates.
 * 
 * @author Kevin Barry
 */
public class Point {
	private int x;
	private int y;

	/**
	 * Creates a new <code>Point</code> object.
	 *
	 * @param x The x value.
	 * @param y The y value.
	 */
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
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
}