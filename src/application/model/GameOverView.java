package application.model;

import application.Main;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class GameOverView {

	private int score;

	private Text scoreText = new Text();

	public Scene scene;
	private Pane uiRoot;

	public GameOverView(Pane uiRoot) {
		this.score = 0;
		this.uiRoot = uiRoot;
	}
	
	public void setScene() {
		
		score = Main.levelOne.getScore();
		
		scoreText.setFont(new Font("Comic Sans MS", 50));
		scoreText.setStroke(Color.BLACK);
		scoreText.setFill(Color.BLACK);
		scoreText.setText("Score: " + score);
		scoreText.setBoundsType(TextBoundsType.VISUAL);
		
		double textWidth = scoreText.getLayoutBounds().getWidth();
		double textHeight = scoreText.getLayoutBounds().getHeight();
		scoreText.setLayoutX(Settings.SCENE_WIDTH / 2 - (textWidth/2));
		scoreText.setLayoutY(Settings.SCENE_HEIGHT / 2 - (textHeight/2));

		uiRoot.getChildren().add(scoreText);
		
		scene = new Scene(uiRoot, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
	}

}
