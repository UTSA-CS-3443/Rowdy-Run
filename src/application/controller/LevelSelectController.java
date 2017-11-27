package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LevelSelectController implements EventHandler<ActionEvent>
{
	@Override
	public void handle(ActionEvent event) 
	{
		// print a message to the console (debugging step, to ensure everything is connected)
		System.out.println("\"Level One\" button clicked!");
		try 
		{
			// change over to a second view
			// Load the FXML
			Parent root = FXMLLoader.load(getClass().getResource("/LevelOneView.fxml"));
			
			// Add the scene to the stage
			Main.stage.setScene(new Scene(root, 800, 500));
			
			// Show the stage to the user
			Main.stage.show();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

}
