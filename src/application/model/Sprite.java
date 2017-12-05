package application.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class Sprite {

	Image image;
	ImageView imageView;

	Pane layer;

	double x;
	double y;

	double dx;
	double dy;

	boolean removable = false;

	double w;
	double h;

	boolean canMove = true;

	public Sprite(Pane layer, Image image, double x, double y, double dx, double dy) {

		this.layer = layer;
		this.image = image;
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;

		this.imageView = new ImageView(image);
		this.imageView.relocate(x, y);

		imageView.setFitHeight(50);
		imageView.setFitWidth(50);

		this.w = 49;
		this.h = 49;

		addToLayer();

	}

	public void addToLayer() {
		this.layer.getChildren().add(this.imageView);
	}

	public void removeFromLayer() {
		this.layer.getChildren().remove(this.imageView);
	}

	public Pane getLayer() {
		return layer;
	}

	public void setLayer(Pane layer) {
		this.layer = layer;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public boolean isRemovable() {
		return removable;
	}

	public void setRemovable(boolean removable) {
		this.removable = removable;
	}

	public ImageView getView() {
		return imageView;
	}

	public void updateUI() {

		imageView.relocate(x, y);

	}

	public double getWidth() {
		return w;
	}

	public double getHeight() {
		return h;
	}

	public double getCenterX() {
		return x + w * 0.5;
	}

	public double getCenterY() {
		return y + h * 0.5;
	}

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

	public abstract void checkRemovability();

}