package application.controller;


import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LevelController implements EventHandler<ActionEvent>
{
	@Override
	public void handle(ActionEvent event) 
	{
		// print a message to the console (debugging step, to ensure everything is connected)
		System.out.println("\"Jump\" button was clicked!");
		try 
		{
			//make sprite jump
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

}
