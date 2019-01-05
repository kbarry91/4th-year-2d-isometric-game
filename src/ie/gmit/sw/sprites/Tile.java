package ie.gmit.sw.sprites;

public class Tile extends ObjectSprite {
	// flyweight pattern: extrinsic state

	private boolean isTrigger;

	private int moveCost;

	public Tile() {

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
