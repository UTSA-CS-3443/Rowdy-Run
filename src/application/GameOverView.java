package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class GameOverView {
	private int score;
	
	private Text finalScore;
	
	
	private Stage stage;
	private Scene scene;
	private Pane uiRoot;
	
	public GameOverView(int score, Stage primaryStage){
		this.score = score;
		this.stage = primaryStage;
	}
	
	public void displayGameOverView() {
        
        try {
			uiRoot = FXMLLoader.load(getClass().getResource("/GameOverView.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        finalScore.setFont(new Font("Comic Sans MS", 50));
        finalScore.setStroke(Color.BLACK);
        finalScore.setFill(Color.BLACK);

        uiRoot.getChildren().add(finalScore);

        double x = (Settings.SCENE_WIDTH - 400);
        finalScore.relocate(x, 0);
        finalScore.setText("Score: " + score);

        finalScore.setBoundsType(TextBoundsType.VISUAL);

        scene = new Scene( uiRoot, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        stage.setScene(scene);
        stage.show();
	}

}
