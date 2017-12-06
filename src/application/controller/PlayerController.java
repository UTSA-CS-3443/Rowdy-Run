package application.controller;

import java.util.BitSet;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * 
 * @author oscarsanjuan
 * PLayer Controller: Defines possible controls within the game
 */
public class PlayerController {

	/**
	 * Bitset which registers if any {@link KeyCode} keeps being pressed or if it is
	 * released.
	 */
	private BitSet keyboardBitSet = new BitSet();

	/**
	 *  Key Code that links the spacebar control
	 */
	private KeyCode spacebar = KeyCode.SPACE;

	Scene scene;

	public PlayerController(Scene scene) {
		this.scene = scene;
	}
	
	/**
	 * Adds Listeners for when the key is pressed and released
	 */
	public void addListeners() {

		scene.addEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
		scene.addEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);

	}

	/**
	 * Removes Listeners for when the key is pressed and released
	 */
	public void removeListeners() {

		scene.removeEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
		scene.removeEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);

	}

	/**
	 * "Key Pressed" handler for all input events
	 */
	private EventHandler<KeyEvent> keyPressedEventHandler = new EventHandler<KeyEvent>() {
		@Override
		public void handle(KeyEvent event) {
			keyboardBitSet.set(event.getCode().ordinal(), true);
		}
	};

	/**
	 * "Key Released" handler for all input events
	 */
	private EventHandler<KeyEvent> keyReleasedEventHandler = new EventHandler<KeyEvent>() {
		@Override
		public void handle(KeyEvent event) {
			keyboardBitSet.set(event.getCode().ordinal(), false);
		}
	};


	/**
	 * 
	 * @return
	 *  isJump: returns true if the user presses spacebar
	 */
	public boolean isJump() {
		return keyboardBitSet.get(spacebar.ordinal());
	}

}