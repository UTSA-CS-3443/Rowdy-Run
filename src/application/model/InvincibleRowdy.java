package application.model;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 * 
 * @author oscarsanjuan
 * Invicible Rowdy: Will allow Rowdy to destroy any objects that my get in his way
 */
public class InvincibleRowdy extends PowerUp {

	public InvincibleRowdy(Pane layer, Image image, double x, double y) {
		super(layer, image, x, y);
	}
	
}
