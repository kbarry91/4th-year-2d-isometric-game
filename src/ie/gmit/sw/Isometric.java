package ie.gmit.sw;

import ie.gmit.sw.sprites.Point;

/*
 * Handles get and set of isometric co-ordinates..
 * 
 * @author Kevin Barry
 */
public class Isometric {

	/**
	 * Retrieve isometric value for x
	 * 
	 * @param x the x value.
	 * @param y the y value.
	 * @return An integer representation the isometric value of x
	 */
	public int getIsoX(int x, int y) {
		int rshift = (Properties.getDefaultViewSize() / 2) - (Properties.getTileWidth() / 2) + (x - y); // Pan camera to
																										// the right
		return (x - y) * (Properties.getTileWidth() / 2) + rshift;
	}

	/**
	 * Retrieve isometric value for y
	 * 
	 * @param x the x value.
	 * @param y the y value.
	 * @return An integer representation the isometric value of y
	 */
	public int getIsoY(int x, int y) {
		return (x + y) * (Properties.getTileHeight() / 2);
	}

	/**
	 * Retrieve isometric point object
	 * 
	 * @param x the x value.
	 * @param y the y value.
	 * @return A <code>Point</code> object containing isometric values.
	 */
	public Point getIso(int x, int y) {
		return new Point(getIsoX(x, y), getIsoY(x, y)); // Could be more efficient...
	}

}
