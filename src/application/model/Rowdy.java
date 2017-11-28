package application.model;

import java.awt.Point;


import gamefx.Levels;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Rowdy {
	public boolean bigRowdy = false, smallRowdy = false, invRowdy = false, ignoreWall = false;
	protected boolean goRight, goLeft, ground;
	protected Point pos;
	protected Image rowdy;
	// OR
	protected Node player;
	private int x, y;
	/*private Point2D playerVelocity = new Point2D(0, 0);
	
	// this is so rowdy won't go off width of level, unsure if used here
	private int levelWidth = Levels.LEVEL1[0].length() * 60; //the Levels class can be changed to whatever Oscar decides
	*/
	
	public Rowdy() {
		this.player = Create();
		this.goLeft = true;
		this.goRight = true; 
		this.x = 0;
		this.y = 0;
		//this.pos= ??
	}
	public ImageView Create() {
			Image im = new Image("file:///C:/Users/Eric/git/Rowdy-Run/src/gamefx/ROWDY.jpg");
			ImageView view = new ImageView();
			view.setImage(im);
			view.setFitHeight(70);
			view.setFitWidth(40);
			view.getProperties().put("alive", true);
			return view;
	}
	
	public ImageView powerPlay(Node player) {
		Image im = new Image("file:///C:/Users/Eric/git/Rowdy-Run/src/gamefx/ROWDY.jpg"); 
		ImageView view = new ImageView();
		view.setImage(im);
		if (bigRowdy = true) {
			view.setFitHeight(90);
			view.setFitWidth(60);
		}
		else if (smallRowdy = true) {
			view.setFitHeight(50);
			view.setFitWidth(20);
		}
		else if(invRowdy = true){
			ignoreWall = true;
			//original dimensions
			view.setFitHeight(70);
			view.setFitWidth(40);
		}
		
		return view;
	}
	

}
