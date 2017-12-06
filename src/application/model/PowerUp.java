package application.model;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 * Sets main class to be used for inheritance of the power ups
 * @author oscarsanjuan
 *
 */
public abstract class PowerUp extends Sprite{

	public PowerUp(Pane layer, Image image, double x, double y) {
		super(layer, image, x, y);
	}

	@Override
	public void checkRemovability() {
	}
	
}
