package application.controller;

import application.GameOverView;
import application.Level;
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LevelSelectController implements EventHandler<ActionEvent>
{
	@Override
	public void handle(ActionEvent event) 
	{
		
		try 
		{
			Level levelOne = new Level();
			levelOne.initLevel(Main.stage);
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

}
