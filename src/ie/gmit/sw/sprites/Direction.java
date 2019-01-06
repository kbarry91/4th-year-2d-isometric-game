package ie.gmit.sw.sprites;

/*
 * Used to change the direction of a sprite.
 * 
 * @author Kevin Barry
 * */
public enum Direction {
	UP (0), 
	DOWN (1), 
	LEFT (2), 
	RIGHT (3);

	private final int orientation;

    private Direction(int orientation) {
        this.orientation = orientation;
    }
    
    public int getOrientation() {
        return this.orientation;
    }
}