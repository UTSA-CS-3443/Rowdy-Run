package application.model;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Coin extends Sprite {

	public Coin(Pane layer, Image image, double x, double y, double dx, double dy) {
		super(layer, image, x, y, dx, dy);
		// TODO Auto-generated constructor stub
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
