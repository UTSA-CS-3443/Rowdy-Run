package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * 
 * @author oscarsanjuan
 * Level Select Controller: Assists in transition from Level Select View to Level One View
 */
public class LevelSelectController implements EventHandler<ActionEvent> {

	/**
	 * Initializes game content and launches game
	 */
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
