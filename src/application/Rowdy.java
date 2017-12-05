package application;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

import application.controller.PlayerController;


public class Rowdy extends Sprite {

	PlayerController controls;
	double speed;
	
	private ArrayList<Image> frames = new ArrayList<Image>();   
	private ArrayList<Platform> platforms = new ArrayList<Platform>();
	
	private int frameIndex = 1;
	private int time = 1;
	
	private double jumpStartPos;
	
	private boolean canJump = true;
	private boolean jumping;
	
	
	public Rowdy(Pane layer, Image image, double x, double y, double dx, double dy, double speed, 
				PlayerController controls, ArrayList<Image> frames, 
				ArrayList<Platform> platforms) {
		
		super(layer, image, x, y, dx, dy);
		
        this.speed = speed;
        this.controls = controls;
        this.frames = frames;
        this.platforms = platforms;

	}

	@Override
	public void checkRemovability() {

	}
	
	public boolean checkBoundaries() {
		if(y > Settings.SCENE_HEIGHT) {
			return false;
		}else {
			return true;
		}
	}
	
	public void jump(double speed) {
		
		if( !canMove)
            return;
       	
       if(y > jumpStartPos - Settings.PLAYER_JUMP_HEIGHT) {
    	   		y -= 10;
        	}
			
    		if(y == jumpStartPos - Settings.PLAYER_JUMP_HEIGHT) {
    			jumping = false;
    		}		
    }
	
	public void fall() {
		if(jumping) {
			return;
		}
		
		y += 10;
		
		for(Platform platform: platforms) {
			if(this.collidesWith(platform)) {
				y = platform.y - 50;
   				canJump = true;
			}
			
		}
	}
	
	@Override
	public void updateUI() {
		
		if(frameIndex + 1 == frames.size()) {
			frameIndex = 0;
		}
		
		if(time % 15 == 0) {
			frameIndex++;
		}
		
		imageView.setImage(frames.get(frameIndex));
        imageView.relocate(x, y);
        
        time++;
    }

	public void processInput() { 
        
		if(controls.isJump() && canJump == true) {		
        		canJump = false;
        		jumping = true;
        		jumpStartPos = y;
        		jump(jumpStartPos);
        }
		
		if(jumping) {
        		jump(jumpStartPos);
        }

		
        
	}	

}
