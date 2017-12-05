package application;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Platform extends Sprite {

	public Platform(Pane layer, Image image, double x, double y, double dx, double dy) {
		super(layer, image, x, y, dx, dy);
	}
	
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
