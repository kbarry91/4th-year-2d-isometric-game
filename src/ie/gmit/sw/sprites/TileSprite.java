package ie.gmit.sw.sprites;

/**
 * Represents Tile Sprite. A subclass of <code>ObjectSprite</code>.
 * 
 * @author Kevin Barry
 */
public class TileSprite extends ObjectSprite {
	// flyweight pattern
	// extrinsic state

	private boolean isTrigger;
	private int moveCost;

	public TileSprite() {

	}

	public boolean isTrigger() {
		return isTrigger;
	}

	public void setTrigger(boolean isTrigger) {
		this.isTrigger = isTrigger;
	}

	public int getMoveCost() {
		return moveCost;
	}

	public void setMOveCost(int cost) {
		this.moveCost = cost;
	}

}
