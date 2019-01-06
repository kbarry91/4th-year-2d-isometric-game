package ie.gmit.sw;

/**
 * Main Runner class, sets up gameWindow and runs on its own thread.
 * 
 * @author Kevin Barry
 * @version 1.0
 */
public class Runner {
	public static void main(String[] args) throws Exception {

		// Load in sound effects once for reuse
		SoundEffect.init();

		// Launch GameWindow in thread.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new GameWindow();
				} catch (Exception e) {
					MenuDialogs.showInfo("Could not launch game window", "Error Has occurred");
				}
			}
		});
	}
}