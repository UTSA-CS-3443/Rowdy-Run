package application;

import application.model.GameOverView;
import application.model.LevelOneView;
import application.model.LevelSelectView;
import application.model.WelcomeView;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * @author oscarsanjuan
 * Main Class to run game
 */
public class Main extends Application {

	
	
	/**
	 * Stage: Main stage to be used throughout the game;
	 */
	public static Stage stage;
	
	/**
	 * Different Views in the game
	 */
	public static WelcomeView welcome;
	public static LevelSelectView levelSelect;
	public static LevelOneView levelOne;
	public static GameOverView gameover;
	
	
	/**
	 * Booleans to allow to know what screen we are in
	 */
	public boolean welcomeScreen = true;
	public static boolean gameScreen = false;
	public static boolean scoreScreen = false;

	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent welcomeRoot = FXMLLoader.load(getClass().getResource("view/MainView.fxml"));
			welcome = new WelcomeView(welcomeRoot);
			
			Parent levelSelectRoot = FXMLLoader.load(getClass().getResource("view/LevelSelectView.fxml"));
			levelSelect = new LevelSelectView(levelSelectRoot);
			
			Pane levelOneRoot = FXMLLoader.load(getClass().getResource("view/LevelOneView.fxml"));
			levelOne = new LevelOneView(primaryStage, levelOneRoot);
			
			Pane gameOverRoot = FXMLLoader.load(getClass().getResource("view/GameOverView.fxml"));
			gameover = new GameOverView(gameOverRoot);

			primaryStage.setResizable(false);
			primaryStage.setScene(welcome.welcomeScene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

		this.stage = primaryStage;	
				
		/**
		 * Animation Timer to run through frames and change views
		 */
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
						
				/**
				 * Checks to see if we are in the game view
				 */
				if(gameScreen) {
					
					/**
					 * Checks if the we have lost the game or not
					 * If we have it will change to the game over Scene
					 * If we are still playing it will update the game
					 */
					if(!levelOne.getGameover()) {
						levelOne.update();
					}else {
						System.out.println("TEST");
						gameScreen = false;
						gameover.setScene();
						stage.setScene(gameover.scene);
						stage.show();
					}
				}
			}
		};
		
		timer.start();
			
	}

	public static void main(String[] args) {
		launch(args);
	}

}
