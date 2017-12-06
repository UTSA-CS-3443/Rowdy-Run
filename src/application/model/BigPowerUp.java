package application.model;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 * 
 * @author oscarsanjuan
 * Big Rowdy: This class is used to define the Big Rowdy Power up
 */
public class BigPowerUp extends PowerUp {

	public BigPowerUp(Pane layer, Image image, double x, double y) {
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

}
