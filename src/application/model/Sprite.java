package application.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Sprite: Implements Boundary Check and Display of Images in Game
 * @author oscarsanjuan
 *
 */
public abstract class Sprite {

	/**
	 * Image and ImageView Objects to link image to object
	 */
	Image image;
	ImageView imageView;

	/**
	 * layer to be used when implementing other objects
	 */
	Pane layer;

	/** Location
	 * x, y
	 */
	double x;
	double y;

	/**
	 * Lets you know if object is removable
	 */
	boolean removable = false;

	/**
	 * Width and Height of Object
	 */
	double w;
	double h;

	/**
	 * Boolean to track if object can move or not
	 */
	boolean canMove = true;

	public Sprite(Pane layer, Image image, double x, double y) {

		this.layer = layer;
		this.image = image;
		this.x = x;
		this.y = y;

		this.imageView = new ImageView(image);
		this.imageView.relocate(x, y);

		imageView.setFitHeight(50);
		imageView.setFitWidth(50);

		this.w = 49;
		this.h = 49;

		addToLayer();

	}

	/**
	 * Add Sprite to working layer
	 */
	public void addToLayer() {
		this.layer.getChildren().add(this.imageView);
	}

	/**
	 * Remove Sprite from working layer
	 */
	public void removeFromLayer() {
		this.layer.getChildren().remove(this.imageView);
	}

	/**
	 * Getter for layer
	 * @return
	 */
	public Pane getLayer() {
		return layer;
	}

	/**
	 * Setter for layer
	 * @param layer
	 */
	public void setLayer(Pane layer) {
		this.layer = layer;
	}

	/**
	 * Gets X
	 * @return
	 */
	public double getX() {
		return x;
	}

	/**
	 * Sets X
	 * @param x
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Gets Y
	 * @return
	 */
	public double getY() {
		return y;
	}

	/**
	 * Sets Y
	 * @param y
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Returns if object is removable
	 * @return
	 */
	public boolean isRemovable() {
		return removable;
	}

	/**
	 * Sets removability on Object
	 * @param removable
	 */
	public void setRemovable(boolean removable) {
		this.removable = removable;
	}

	/**
	 * Gets current image View
	 * @return
	 */
	public ImageView getView() {
		return imageView;
	}

	/**
	 * Updates Rowdy location
	 */
	public void updateUI() {

		imageView.relocate(x, y);

	}

	/**
	 * Gets Width
	 * @return
	 */
	public double getWidth() {
		return w;
	}

	/**
	 * Gets Height
	 * @return
	 */
	public double getHeight() {
		return h;
	}

	/**
	 * Checks if it collides with another sprite
	 * @param otherSprite
	 * @return
	 */
	public boolean collidesWith(Sprite otherSprite) {

		return (otherSprite.x + otherSprite.w >= x && otherSprite.y + otherSprite.h >= y && otherSprite.x <= x + w
				&& otherSprite.y <= y + h);
	}

	/**
	 * Set flag that the sprite can be removed from the UI.
	 */
	public void remove() {
		setRemovable(true);
	}

	/**
	 * Set flag that the sprite can't move anymore.
	 */
	public void stopMovement() {
		this.canMove = false;
	}

	/**
	 * Abstract method to check if Sprite can be removed
	 */
	public abstract void checkRemovability();

}