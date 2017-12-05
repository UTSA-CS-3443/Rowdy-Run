package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LevelSelectController implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {

		try {
			Main.levelOne.initLevel();
			Main.gameScreen = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
