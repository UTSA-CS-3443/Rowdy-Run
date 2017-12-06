package application.model;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 * Defines the PLatform Object to be used during the game
 * @author oscarsanjuan
 *
 */
public class Platform extends Sprite {

	public Platform(Pane layer, Image image, double x, double y) {
		super(layer, image, x, y);
	}

	/**
	 * Used to provide the side scrolling experience in the game
	 */
	@Override
	public void updateUI() {

		x -= Settings.SPEED_DIFFICULTY;
		imageView.relocate(x, y);
	}

	@Override
	public void checkRemovability() {
	}

}
