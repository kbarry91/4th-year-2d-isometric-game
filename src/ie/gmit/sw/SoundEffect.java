package ie.gmit.sw;

import java.io.*;
import javax.sound.sampled.*;

/**
 * This enum encapsulates all the sound effects of a game, so as to separate the
 * sound playing codes from the game codes.
 * 
 * Code is adapted from
 * http://www.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html.
 * 
 * @author Kevin Barry
 * @see <a href=
 *      "http://www.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html">http://google.com</a>
 */
public enum SoundEffect {

	ACTION("./resources/sounds/action.wav"), BOO("./resources/sounds/boo.wav"),
	APPLAUSE("./resources/sounds/applause.wav"); // explosion

	// Nested class for specifying volume
	public static enum Volume {
		MUTE, LOW, MEDIUM, HIGH
	}

	public static Volume volume = Volume.LOW;

	// Each sound effect has its own clip, loaded with its own sound file.
	private Clip clip;

	// Constructor to construct each element of the enum with its own sound file.
	SoundEffect(String soundFileName) {
		try {

			File dir = new File(soundFileName);
			// Set up an audio input stream piped from the sound file.
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(dir);
			// Get a clip resource.
			clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioInputStream);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Play or Re-play the sound effect from the beginning, by rewinding.
	 */
	public void play() {
		if (volume != Volume.MUTE) {
			if (clip.isRunning())
				clip.stop(); // Stop the player if it is still running
			clip.setFramePosition(0); // rewind to the beginning
			clip.start(); // Start playing
		}
	}

	/**
	 * Optional static method to pre-load all the sound files.
	 */
	static void init() {
		values(); // calls the constructor for all the elements
	}
}
