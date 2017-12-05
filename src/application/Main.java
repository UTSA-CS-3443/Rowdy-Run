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

public class Main extends Application {

	public static Stage stage;
	public static WelcomeView welcome;
	public static LevelSelectView levelSelect;
	public static LevelOneView levelOne;
	public static GameOverView gameover;
	
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
				
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
							
				if(gameScreen) {
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
