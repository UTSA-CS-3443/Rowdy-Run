package application.model;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SmallPowerUp extends PowerUp {

	public SmallPowerUp(Pane layer, Image image, double x, double y) {
		super(layer, image, x, y);
	}
	
	/**
	 * This method is used to create the side scrolling effect in the game
	 */
	@Override
	public void updateUI() {
		x -= Settings.SPEED_DIFFICULTY;
		imageView.relocate(x, y);
	}

}
