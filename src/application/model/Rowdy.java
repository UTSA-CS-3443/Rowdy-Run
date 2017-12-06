package application.model;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

import application.controller.PlayerController;

/**
 * Rowdy: Used to create a player to be used throughout the game
 * @author oscarsanjuan
 *
 */
public class Rowdy extends Sprite {

	/**
	 * Creates controls to be linked to Rowdy
	 */
	PlayerController controls;
	double speed;

	/**
	 * ArrayList to keep track of Rowdy's Frames and Game Platforms
	 */
	private ArrayList<Image> frames = new ArrayList<Image>();
	private ArrayList<Platform> platforms = new ArrayList<Platform>();

	/**
	 * Initializing first frame to 1;
	 */
	private int frameIndex = 1;
	
	/**
	 * Time will be used to slow animation to look more fluent
	 */
	private int time = 1;

	/**
	 * Sets Jump Starting Position
	 */
	private double jumpStartPos;

	/**
	 * States what if Rowdy can jump or not
	 */
	private boolean canJump = true;
	
	/**
	 * Tracker to see if Rowdy is currenyl jumping
	 */
	private boolean jumping;
	
	private boolean bigRowdy = false;
	private boolean smallRowdy = false;


	public Rowdy(Pane layer, Image image, double x, double y, double speed, PlayerController controls, 
				ArrayList<Image> frames, ArrayList<Platform> platforms) {

		super(layer, image, x, y);

		this.speed = speed;
		this.controls = controls;
		this.frames = frames;
		this.platforms = platforms;

	}

	@Override
	public void checkRemovability() {
	}

	/**
	 * Checks to see if Rowdy left the boundaries of the map
	 * @return
	 */
	public boolean checkBoundaries() {
		if (y > Settings.SCENE_HEIGHT) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Allows Rowdy to jump
	 * @param speed
	 */
	public void jump(double speed) {

		if (!canMove)
			return;

		if (y > jumpStartPos - Settings.PLAYER_JUMP_HEIGHT) {
			y -= 10;
		}

		if (y == jumpStartPos - Settings.PLAYER_JUMP_HEIGHT) {
			jumping = false;
		}
	}

	/**
	 * Sets Big Rowdy Variable
	 * @param value
	 */
	public void setBigRowdy(boolean value) {
		bigRowdy = value;
	}
	
	/**
	 * Sets Small Rowdy Variable
	 * @param value
	 */
	public void setSmallRowdy(boolean value) {
		smallRowdy = true;
	}
	
	/**
	 * Keeps Rowdy falling even when their is no playform under him
	 */
	public void fall() {
		if (jumping) {
			return;
		}

		y += 10;

		for (Platform platform : platforms) {
			if (this.collidesWith(platform)) {
				y = platform.y - h;
				canJump = true;
			}

		}
	}

	/**
	 * Updates Rowdy Frame
	 */
	@Override
	public void updateUI() {

		if (frameIndex + 1 == frames.size()) {
			frameIndex = 0;
		}

		if (time % 15 == 0) {
			frameIndex++;
		}

		/**
		 * Changes the size of Rowdy if  Big Power Up is enabled
		 */
		if(bigRowdy) {
			imageView.setFitHeight(100);
			imageView.setFitWidth(100);
			h = 100;
			bigRowdy = false;
		}
		
		/**
		 * Changes the size of Rowdy if  Small Power Up is enabled
		 */
		if(smallRowdy) {
			imageView.setFitHeight(25);
			imageView.setFitWidth(25);
			h = 25;
			smallRowdy = false;	
		}
		
		imageView.setImage(frames.get(frameIndex));
		imageView.relocate(x, y);

		time++;
	}

	/**
	 * Process Input from user
	 */
	public void processInput() {

		if (controls.isJump() && canJump == true) {
			canJump = false;
			jumping = true;
			jumpStartPos = y;
			jump(jumpStartPos);
		}

		if (jumping) {
			jump(jumpStartPos);
		}

	}

}
