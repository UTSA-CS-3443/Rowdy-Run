package application.model;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public abstract class PowerUp extends Sprite{

	public PowerUp(Pane layer, Image image, double x, double y, double dx, double dy) {
		super(layer, image, x, y, dx, dy);
	}

	@Override
	public void checkRemovability() {
		// TODO Auto-generated method stub
		
	}
	
	public abstract void power();
	
}
