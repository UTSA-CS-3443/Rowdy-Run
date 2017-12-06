package application.model;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 * 
 * @author oscarsanjuan
 * Coin: Is build off the Sprite class
 * 
 */
public class Coin extends Sprite {

	public Coin(Pane layer, Image image, double x, double y) {
		super(layer, image, x, y);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method is used to create the side scrolling effect in the game
	 */
	@Override
	public void updateUI() {
		x -= Settings.SPEED_DIFFICULTY;
		imageView.relocate(x, y);
	}

	@Override
	public void checkRemovability() {
		// TODO Auto-generated method stub

	}

}
