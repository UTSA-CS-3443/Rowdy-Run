package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;


public class Main extends Application 
{
	
	public static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
		
			Parent root = FXMLLoader.load(getClass().getResource("/MainView.fxml"));
			Scene welcomeScene = new Scene(root, 800, 500); 
			primaryStage.setResizable(false);
			primaryStage.setScene(welcomeScene);
			primaryStage.show();
			
			//TODO Implement Background
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		this.stage = primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
